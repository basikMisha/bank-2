package com.example.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Продемонстрируйте работу:
        // Создайте список счетов (DebitAccount, CreditAccount, SavingsAccount).
        // Вызовите processTransaction() для списка с разной суммой.
        DebitAccount debitAccount = new DebitAccount("1111", "test1", new BigDecimal("1000"));
        CreditAccount creditAccount = new CreditAccount("2222", "test2", new BigDecimal("500"), new BigDecimal("1000"));
        SavingsAccount savingsAccount = new SavingsAccount("3333", "test3", new BigDecimal("3500"), new BigDecimal("0.1"));

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(debitAccount);
        accounts.add(creditAccount);
        accounts.add(savingsAccount);

        TransactionProcessor transactionProcessor = new TransactionProcessor();

        System.out.println("\nTransaction = 500");
        transactionProcessor.processTransaction(accounts, new BigDecimal("500"));

        System.out.println("\nTransaction = 1000");
        transactionProcessor.processTransaction(accounts, new BigDecimal("1000"));
    }
}