package com.pyyne.challenge.bank.adapter;

import com.bank2.integration.Bank2AccountBalance;
import com.bank2.integration.Bank2AccountSource;
import com.bank2.integration.Bank2AccountTransaction;
import com.pyyne.challenge.bank.dto.BankAccountBalance;
import com.pyyne.challenge.bank.dto.BankAccountTransaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter that gets Bank 2 data and map into a common object structure.
 * <p>
 * Created by Matheus Schmitz on 10/20/22.
 */
public class Bank2AccountAdapter implements BankAccountSource {

    private static final Bank2AccountSource externalSource = new Bank2AccountSource();

    @Override
    public BankAccountBalance getAccountBalance(long accountId) {
        Bank2AccountBalance balance = externalSource.getBalance(accountId);
        return new BankAccountBalance(balance.getBalance(), balance.getCurrency());
    }

    @Override
    public List<BankAccountTransaction> getAccountTransactions(long accountId, Date fromDate, Date toDate) {
        List<Bank2AccountTransaction> transactions = externalSource.getTransactions(accountId, fromDate, toDate);
        return transactions.stream()
                .map(this::mapToBankAccountTransaction)
                .collect(Collectors.toList());
    }

    private BankAccountTransaction mapToBankAccountTransaction(Bank2AccountTransaction transaction) {
        BankAccountTransaction.TRANSACTION_TYPES transactionType = transaction.getType() == Bank2AccountTransaction.TRANSACTION_TYPES.CREDIT ? BankAccountTransaction.TRANSACTION_TYPES.CREDIT : BankAccountTransaction.TRANSACTION_TYPES.DEBIT;
        return new BankAccountTransaction(transaction.getAmount(), transactionType, transaction.getText());
    }
}
