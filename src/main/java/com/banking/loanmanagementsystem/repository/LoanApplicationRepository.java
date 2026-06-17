package com.banking.loanmanagementsystem.repository;

import com.banking.loanmanagementsystem.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, String> {
    List<LoanApplication> findByCustomerId(String customerId);
    List<LoanApplication> findByStatus(String status);
}
