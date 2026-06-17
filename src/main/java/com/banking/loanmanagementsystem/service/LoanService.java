package com.banking.loanmanagementsystem.service;

import com.banking.loanmanagementsystem.model.*;
import com.banking.loanmanagementsystem.repository.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {
    private final LoanApplicationRepository loanRepo;
    private final RepaymentRepository repaymentRepo;

    public LoanService(LoanApplicationRepository loanRepo, RepaymentRepository repaymentRepo) {
        this.loanRepo = loanRepo; this.repaymentRepo = repaymentRepo;
    }

    public LoanApplication apply(String customerId, BigDecimal amount, int termMonths, String purpose) {
        LoanApplication app = new LoanApplication(customerId, amount, termMonths, purpose);
        int score = calculateCreditScore(customerId);
        app.setCreditScore(score);
        if (score >= 700) {
            app.setStatus("APPROVED");
            app.setInterestRate(BigDecimal.valueOf(10.5));
            app.setRiskCategory("LOW");
        } else if (score >= 500) {
            app.setStatus("UNDER_REVIEW");
            app.setInterestRate(BigDecimal.valueOf(15.0));
            app.setRiskCategory("MEDIUM");
        } else {
            app.setStatus("REJECTED");
            app.setRiskCategory("HIGH");
        }
        app.setReviewedAt(LocalDate.now().atStartOfDay());
        LoanApplication saved = loanRepo.save(app);

        if ("APPROVED".equals(saved.getStatus())) {
            generateRepaymentSchedule(saved);
        }
        return saved;
    }

    private int calculateCreditScore(String customerId) {
        return 650 + (int)(Math.random() * 200);
    }

    private void generateRepaymentSchedule(LoanApplication loan) {
        BigDecimal monthlyPayment = loan.getAmount().divide(BigDecimal.valueOf(loan.getTermMonths()), 2, RoundingMode.HALF_UP);
        for (int i = 1; i <= loan.getTermMonths(); i++) {
            LocalDate dueDate = LocalDate.now().plusMonths(i);
            repaymentRepo.save(new Repayment(loan.getId(), monthlyPayment, dueDate));
        }
    }

    public List<LoanApplication> getLoansByCustomer(String customerId) {
        return loanRepo.findByCustomerId(customerId);
    }

    public List<Repayment> getRepayments(String loanId) {
        return repaymentRepo.findByLoanId(loanId);
    }

    public List<LoanApplication> getAllLoans() { return loanRepo.findAll(); }
}
