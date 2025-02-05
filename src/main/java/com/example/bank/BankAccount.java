package com.example.bank;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BankAccount {
    protected String accountNumber;
    protected BigDecimal balance;
    protected String accountHolder;

    public BankAccount(String accountNumber, String accountHolder, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance.setScale(2, RoundingMode.HALF_UP);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
            System.out.println("Added to deposit: " + amount);
        } else {
            System.out.println("Deposit must be positive");
        }
    }

    public abstract void withdraw(BigDecimal amount);
    public BigDecimal getBalance() {
        return balance;
    }
}