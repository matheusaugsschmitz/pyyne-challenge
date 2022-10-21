package com.pyyne.challenge.bank.dto;

/**
 * Created by Matheus Schmitz on 10/20/22.
 */
public class BankAccountBalance {
    private final double balance;
    private final String currency;

    public BankAccountBalance(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }
}
