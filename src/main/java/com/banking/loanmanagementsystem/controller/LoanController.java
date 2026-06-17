package com.banking.loanmanagementsystem.controller;

import com.banking.loanmanagementsystem.model.*;
import com.banking.loanmanagementsystem.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController @RequestMapping("/api/v1")
public class LoanController {
    private final LoanService loanService;
    public LoanController(LoanService loanService) { this.loanService = loanService; }

    @PostMapping("/loans")
    public ResponseEntity<LoanApplication> apply(@RequestBody Map<String, Object> req) {
        return ResponseEntity.ok(loanService.apply(
            (String)req.get("customerId"), new BigDecimal(req.get("amount").toString()),
            (int)req.get("termMonths"), (String)req.get("purpose")));
    }

    @GetMapping("/loans")
    public ResponseEntity<List<LoanApplication>> allLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/customers/{id}/loans")
    public ResponseEntity<List<LoanApplication>> customerLoans(@PathVariable String id) {
        return ResponseEntity.ok(loanService.getLoansByCustomer(id));
    }

    @GetMapping("/loans/{id}/repayments")
    public ResponseEntity<List<Repayment>> repayments(@PathVariable String id) {
        return ResponseEntity.ok(loanService.getRepayments(id));
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "loan-management-system"));
    }
}
