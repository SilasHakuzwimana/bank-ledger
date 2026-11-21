# Bank Ledger

A simple Java banking application built to practice object-oriented design, JUnit 5 testing, and CI/CD pipelines.

## Features

- `CheckingAccount` and `SavingsAccount` implementations behind an `Account` interface
- Deposit and withdraw operations with input validation
- Pluggable `Displayer` for output (mocked during testing)
- 100% branch and instruction coverage on core business logic
- Automated CI pipeline running tests on multiple JDK versions

## Tech Stack

- Java 17 (Tested against JDK 17 and 21)
- Maven
- JUnit 5 (Jupiter)
- Mockito (Mocking framework)
- JaCoCo (Code coverage)
- GitHub Actions (CI/CD)

## Project Structure

```bash
bank-ledger/
├── .github/workflows/     # CI/CD pipelines
│   └── ci.yml
├── pom.xml
├── src/
│   ├── main/java/         # Production code
│   │   ├── Account.java
│   │   ├── CheckingAccount.java
│   │   ├── SavingsAccount.java
│   │   ├── Displayer.java
│   │   └── Main.java
│   └── test/java/         # Test code
│       └── AccountTest.java
└── README.md
```

## How to Build and Test

```bash
# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Package into a jar
mvn package

```

## Running the Application

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```

Or run Main.java directly from your IDE.

## Test Coverage & CI/CD

This project uses JaCoCo to ensure 100% instruction and branch coverage on all business logic.

The GitHub Actions pipeline (.github/workflows/ci.yml) triggers on every push to main and on all Pull Requests. It performs the following:

Runs the full test suite against JDK 17 and JDK 21 in a matrix build.
Uploads Surefire test reports as downloadable artifacts.
Generates and uploads the JaCoCo HTML coverage report.

## Test Scenarios

The AccountTest class covers the following scenarios using JUnit 5 and Mockito:

| Test | Scenario |
|------|----------|
| `testCheckingAccountDeposit` | Successful deposit |
| `testCheckingAccountWithdrawSuccess` | Successful withdraw |
| `testWithdrawExactlyBalance` | Withdraw full balance (boundary) |
| `testDepositNegativeAmount` | Reject negative deposit |
| `testSavingNegativeAmount` | Reject negative savings deposit |
| `testSavingZeroAmount` | Reject zero deposit |
| `testWithdrawingMoreAmount` | Reject overdraft (Savings) |
| `testCheckingAccountWithdrawExceedingBalance` | Reject overdraft (Checking) |
| `testSavingsAccountWithdrawExceedingBalance` | Reject overdraft (Savings boundary) |
| `testSavingAccountWithdrawSuccess` | Successful savings withdraw |
| `testWithdrawNegativeAmount` | Reject negative withdraw (Checking) |
| `testSavingsWithdrawNegativeAmount` | Reject negative withdraw (Savings) |