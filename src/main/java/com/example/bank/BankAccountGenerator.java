package com.example.bank;

import java.math.BigDecimal;
import java.util.Random;

public class BankAccountGenerator {
    private static final Random RANDOM = new Random();

    public static DebitAccount createDebitAccount() {
        return new DebitAccount(
                "Debit-" + RANDOM.nextInt(1000),
                "User" + RANDOM.nextInt(100),
                BigDecimal.valueOf(RANDOM.nextDouble() * 1000)
        );
    }

    public static CreditAccount createCreditAccount() {
        return new CreditAccount(
                "Credit-" + RANDOM.nextInt(1000),
                "User" + RANDOM.nextInt(100),
                BigDecimal.valueOf(RANDOM.nextDouble() * 1000),
                BigDecimal.valueOf(RANDOM.nextDouble() * 500)
        );
    }

    public static SavingsAccount createSavingsAccount() {
        return new SavingsAccount(
                "Savings-" + RANDOM.nextInt(1000),
                "User" + RANDOM.nextInt(100),
                BigDecimal.valueOf(RANDOM.nextDouble() * 1000),
                BigDecimal.valueOf(0.05) // 5% годовых
        );
    }
}