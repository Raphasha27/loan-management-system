package com.banking.loanmanagementsystem.repository;

import com.banking.loanmanagementsystem.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, String> {
    List<Repayment> findByLoanId(String loanId);
    List<Repayment> findByStatus(String status);
}
