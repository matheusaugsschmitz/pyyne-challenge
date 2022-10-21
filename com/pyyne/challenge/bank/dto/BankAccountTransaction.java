package com.pyyne.challenge.bank.dto;

/**
 * Created by Matheus Schmitz on 10/20/22.
 */
public class BankAccountTransaction {

    public enum TRANSACTION_TYPES {
        DEBIT, CREDIT
    }

    private final double amount;
    private final TRANSACTION_TYPES type;
    private final String description;

    public BankAccountTransaction(double amount, TRANSACTION_TYPES type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public TRANSACTION_TYPES getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
