package com.example.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditAccount extends BankAccount implements TransactionFee {
    private final BigDecimal creditLimit;
    private static final BigDecimal FEE = new BigDecimal("0.01");

    public CreditAccount(String accountNumber, String accountHolder, BigDecimal balance, BigDecimal creditLimit) {
        super(accountNumber, accountHolder, balance);
        this.creditLimit = creditLimit.negate();
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Withdraw should be > 0");
            return;
        }

        BigDecimal total = applyFee(amount);
        BigDecimal newBalance = balance.subtract(total);

        if (newBalance.compareTo(creditLimit) >= 0) {
            balance = newBalance;
            System.out.println("Withdraw = " + amount + " Balance = " + balance +
                    " Fee = " + total.subtract(amount));
        } else {
            System.out.println("Withdraw > credit limit. Credit limit = " + creditLimit);
        }
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public BigDecimal applyFee(BigDecimal amount) {
        return amount.multiply(BigDecimal.ONE.add(FEE)).setScale(2, RoundingMode.HALF_UP);
    }
}