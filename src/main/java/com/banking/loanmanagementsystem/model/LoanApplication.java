package com.banking.loanmanagementsystem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity @Table(name = "loan_applications")
public class LoanApplication {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String customerId;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private int termMonths;
    private String purpose;
    private String status = "SUBMITTED"; // SUBMITTED, UNDER_REVIEW, APPROVED, REJECTED, DISBURSED
    private String riskCategory;
    private int creditScore;
    private LocalDateTime submittedAt;
    private LocalDateTime reviewedAt;

    public LoanApplication() {}
    public LoanApplication(String customerId, BigDecimal amount, int termMonths, String purpose) {
        this.customerId = customerId; this.amount = amount;
        this.termMonths = termMonths; this.purpose = purpose;
        this.submittedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getCustomerId() { return customerId; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getInterestRate() { return interestRate; }
    public int getTermMonths() { return termMonths; }
    public String getPurpose() { return purpose; }
    public String getStatus() { return status; }
    public String getRiskCategory() { return riskCategory; }
    public int getCreditScore() { return creditScore; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public LocalDateTime getReviewedAt() { return reviewedAt; }
    public void setStatus(String s) { this.status = s; }
    public void setInterestRate(BigDecimal r) { this.interestRate = r; }
    public void setRiskCategory(String r) { this.riskCategory = r; }
    public void setCreditScore(int s) { this.creditScore = s; }
    public void setReviewedAt(LocalDateTime t) { this.reviewedAt = t; }
}
