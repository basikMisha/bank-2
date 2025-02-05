package com.example.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
public class SavingsAccount extends BankAccount implements InterestBearing {
    private final BigDecimal interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, BigDecimal balance, BigDecimal interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void applyInterest() {
        BigDecimal interest = balance.multiply(interestRate).setScale(2, RoundingMode.HALF_UP);
        balance = balance.add(interest);
        System.out.println("Interest applied: " + interest + ", New balance: " + balance);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
            System.out.println("Withdrawn: " + amount + ", Remaining balance: " + balance);
        } else {
            System.out.println("Amount should be <= balance");
        }
    }
}