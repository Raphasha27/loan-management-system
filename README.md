# Loan Management System

[![CI](https://github.com/koketseraphasha/loan-management-system/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/loan-management-system/actions/workflows/ci.yml)

Loan processing and management platform with application workflow, approval chains, repayment tracking, and credit scoring.

## Features
- Loan applications
- Approval workflow
- Repayment tracking
- Interest calculations
- Credit scoring simulation
- Customer management

## Stack
Java 21, Spring Boot, PostgreSQL, Docker

## Quick Start
```bash
docker compose up -d
```

## Deployment & Architecture

This project is designed with cloud-ready principles:

- **Containerized** using Docker for consistent deployment
- **Environment-based configuration** — no hardcoded secrets
- **Modular structure** for independent scaling
- **Stateless design** where applicable
- **Separation of concerns** for maintainability

### Run Locally

`ash
docker-compose up --build
`

---

*Part of the Kirov Dynamics Technology portfolio — backend engineering focused on security, scalability, and system design.*
