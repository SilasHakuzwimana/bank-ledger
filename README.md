# Bank Ledger

A simple Java banking application built to practice object-oriented design and JUnit 5 testing.

## Features

- `CheckingAccount` and `SavingsAccount` implementations behind an `Account` interface
- Deposit and withdraw operations with input validation
- Pluggable `Displayer` for output (supports mocking in tests)

## Tech Stack

- Java 21
- Maven
- JUnit 5 (Jupiter)
- Maven Surefire Plugin 3.2.5

## Project Structure

```bash
bank-ledger/
├── pom.xml
├── src/
│ ├── main/java/ # Production code
│ │ ├── Account.java
│ │ ├── CheckingAccount.java
│ │ ├── SavingsAccount.java
│ │ ├── Displayer.java
│ │ └── Main.java
│ └── test/java/ # Test code
│ └── AccountTest.java
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

## Test Coverage

The AccountTest class covers:

Test	Scenario
testCheckingAccountDeposit	Successful deposit
testCheckingAccountWithdrawSuccess	Successful withdraw
testWithdrawExactlyBalance	Withdraw full balance (boundary)
testDepositNegativeAmount	Reject negative deposit
testSavingNegativeAmount	Reject negative savings deposit
testSavingZeroAmount	Reject zero deposit
testWithdrawingMoreAmount	Reject overdraft