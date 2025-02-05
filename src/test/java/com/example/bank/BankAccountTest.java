package com.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class BankAccountTest {
    private DebitAccount debitAccount;
    private CreditAccount creditAccount;
    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        debitAccount = BankAccountGenerator.createDebitAccount();
        creditAccount = BankAccountGenerator.createCreditAccount();
        savingsAccount = BankAccountGenerator.createSavingsAccount();
    }

    @Test
    void testDeposit() {
        BigDecimal initialBalance = debitAccount.getBalance();
        debitAccount.deposit(BigDecimal.valueOf(100));
        assertEquals(initialBalance.add(BigDecimal.valueOf(100)), debitAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        BigDecimal initialBalance = debitAccount.getBalance();
        debitAccount.withdraw(BigDecimal.valueOf(50));
        assertTrue(debitAccount.getBalance().compareTo(initialBalance) < 0);
    }

    @Test
    void testCreditLimit() {
        BigDecimal creditLimit = creditAccount.getCreditLimit();
        creditAccount.withdraw(BigDecimal.valueOf(creditAccount.getBalance().doubleValue() + 100));
        assertTrue(creditAccount.getBalance().compareTo(creditLimit) >= 0);
    }

    @Test
    void testInterestCalculation() {
        BigDecimal initialBalance = savingsAccount.getBalance();
        savingsAccount.applyInterest();
        assertTrue(savingsAccount.getBalance().compareTo(initialBalance) > 0);
    }
}