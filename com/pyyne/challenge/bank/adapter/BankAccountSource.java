package com.pyyne.challenge.bank.adapter;

import com.pyyne.challenge.bank.dto.BankAccountBalance;
import com.pyyne.challenge.bank.dto.BankAccountTransaction;

import java.util.Date;
import java.util.List;

/**
 * Created by Matheus Schmitz on 10/20/22.
 */
public interface BankAccountSource {

    BankAccountBalance getAccountBalance(long accountId);

    List<BankAccountTransaction> getAccountTransactions(long accountId, Date fromDate, Date toDate);

}
