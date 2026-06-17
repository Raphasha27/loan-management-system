package com.banking.loanmanagementsystem.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Table(name = "repayments")
public class Repayment {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String loanId;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate paidDate;
    private String status = "PENDING"; // PENDING, PAID, OVERDUE
    private BigDecimal lateFee = BigDecimal.ZERO;

    public Repayment() {}
    public Repayment(String loanId, BigDecimal amount, LocalDate dueDate) {
        this.loanId = loanId; this.amount = amount; this.dueDate = dueDate;
    }
    public String getId() { return id; }
    public String getLoanId() { return loanId; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getPaidDate() { return paidDate; }
    public String getStatus() { return status; }
    public BigDecimal getLateFee() { return lateFee; }
    public void setStatus(String s) { this.status = s; }
    public void setPaidDate(LocalDate d) { this.paidDate = d; }
}
