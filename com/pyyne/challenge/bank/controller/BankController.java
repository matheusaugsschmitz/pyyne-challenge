package com.pyyne.challenge.bank.controller;

import com.pyyne.challenge.bank.dto.BankAccountBalance;
import com.pyyne.challenge.bank.dto.BankAccountTransaction;
import com.pyyne.challenge.bank.adapter.Bank1AccountAdapter;
import com.pyyne.challenge.bank.adapter.Bank2AccountAdapter;
import com.pyyne.challenge.bank.adapter.BankAccountSource;

import java.util.Date;
import java.util.List;

/**
 * Controller that pulls information form multiple bank integrations and prints them to the console.
 * <p>
 * Created by Par Renyard on 5/12/21.
 */
public class BankController {

    private final long accountId = 0L;

    public void printBalances() {
        System.out.println("[+] Printing Bank 1 Balances");
        printBalance(new Bank1AccountAdapter());

        System.out.println("\n[+] Printing Bank 2 Balances");
        printBalance(new Bank2AccountAdapter());
    }

    public void printTransactions() {
        System.out.println("[+] Printing Bank 1 Transactions");
        printTransactions(new Bank1AccountAdapter());

        System.out.println("\n[+] Printing Bank 2 Balances");
        printTransactions(new Bank2AccountAdapter());
    }

    private void printBalance(BankAccountSource bankAccountSource) {
        BankAccountBalance accountBalance = bankAccountSource.getAccountBalance(accountId);
        System.out.println("\t- " + accountBalance.getBalance() + " " + accountBalance.getCurrency());
    }
    private void printTransactions(BankAccountSource bankAccountSource) {
        Date fromDate = new Date();
        Date toDate = new Date();
        List<BankAccountTransaction> transactions = bankAccountSource.getAccountTransactions(accountId, fromDate, toDate);
        for (BankAccountTransaction transaction : transactions) {
            System.out.println("\t- " + transaction.getType().name() + " \t| " + transaction.getAmount() + "\t| " + transaction.getDescription());
        }
    }
}
