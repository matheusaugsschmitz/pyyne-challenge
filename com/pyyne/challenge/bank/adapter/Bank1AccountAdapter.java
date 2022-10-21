package com.pyyne.challenge.bank.adapter;

import com.bank1.integration.Bank1AccountSource;
import com.bank1.integration.Bank1Transaction;
import com.pyyne.challenge.bank.dto.BankAccountBalance;
import com.pyyne.challenge.bank.dto.BankAccountTransaction;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Adapter that gets Bank 1 data and map into a common object structure.
 * <p>
 * Created by Matheus Schmitz on 10/20/22.
 */
public class Bank1AccountAdapter implements BankAccountSource {

    private static final Bank1AccountSource externalSource = new Bank1AccountSource();

    @Override
    public BankAccountBalance getAccountBalance(long accountId) {
        Double accountBalance = externalSource.getAccountBalance();
        String accountCurrency = externalSource.getAccountCurrency(accountId);
        return new BankAccountBalance(accountBalance, accountCurrency);
    }

    @Override
    public List<BankAccountTransaction> getAccountTransactions(long accountId, Date fromDate, Date toDate) {
        List<Bank1Transaction> transactions = externalSource.getTransactions(accountId, fromDate, toDate);
        return transactions.stream()
                .map(this::mapToBankAccountTransaction)
                .collect(Collectors.toList());
    }

    private BankAccountTransaction mapToBankAccountTransaction(Bank1Transaction transaction) {
        BankAccountTransaction.TRANSACTION_TYPES transactionType = transaction.getType() == 1 ? BankAccountTransaction.TRANSACTION_TYPES.CREDIT : BankAccountTransaction.TRANSACTION_TYPES.DEBIT;
        return new BankAccountTransaction(transaction.getAmount(), transactionType, transaction.getText());
    }
}
