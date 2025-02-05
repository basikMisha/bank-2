package com.example.bank;

import java.math.BigDecimal;

public class DebitAccount extends BankAccount {
    public DebitAccount(String accountNumber, String accountHolder, BigDecimal balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Withdrawn = " + amount);
        } else {
            System.out.println("Amount should be <= balance");
        }
    }
}