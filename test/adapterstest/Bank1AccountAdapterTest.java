package test.adapterstest;

import com.pyyne.challenge.bank.adapter.Bank1AccountAdapter;
import com.pyyne.challenge.bank.dto.BankAccountBalance;
import com.pyyne.challenge.bank.dto.BankAccountTransaction;
import test.util.AbstractTest;
import test.util.Testable;

import java.util.Date;
import java.util.List;

/**
 * Created by Matheus Schmitz on 10/20/22.
 */
public class Bank1AccountAdapterTest extends AbstractTest implements Testable {

    @Override
    public void runTests() {
        testGettingAccountBalance();
        testGettingTransactions();
    }

    private void testGettingAccountBalance() {
        // Arrange
        final long accountId = 1L;

        final String expectedCurrency = "USD";
        final double expectedBalance = 215.5d;

        // Act
        BankAccountBalance accountBalance = new Bank1AccountAdapter().getAccountBalance(accountId);

        // Assert
        assertEquals(expectedCurrency, accountBalance.getCurrency());
        assertEquals(expectedBalance, accountBalance.getBalance());

        printSucceedTestMessage("testGettingAccountBalance");
    }

    private void testGettingTransactions() {
        // Arrange
        final long accountId = 1L;
        final Date fromDate = new Date();
        final Date toDate = new Date();

        final int expectedTransactionsListSize = 3;

        // First Transaction
        final double expectedFirstTransactionAmount = 100d;
        final BankAccountTransaction.TRANSACTION_TYPES expectedFirstTransactionType = BankAccountTransaction.TRANSACTION_TYPES.CREDIT;
        final String expectedFirstTransactionDescription = "Check deposit";

        // Second Transaction
        final double expectedSecondTransactionAmount = 25.5d;
        final BankAccountTransaction.TRANSACTION_TYPES expectedSecondTransactionType = BankAccountTransaction.TRANSACTION_TYPES.DEBIT;
        final String expectedSecondTransactionDescription = "Debit card purchase";

        // Third Transaction
        final double expectedThirdTransactionAmount = 225d;
        final BankAccountTransaction.TRANSACTION_TYPES expectedThirdTransactionType = BankAccountTransaction.TRANSACTION_TYPES.DEBIT;
        final String expectedThirdTransactionDescription = "Rent payment";
        // Act
        List<BankAccountTransaction> accountTransactions = new Bank1AccountAdapter().getAccountTransactions(accountId, fromDate, toDate);

        // Assert
        assertEquals(expectedTransactionsListSize, accountTransactions.size());

        BankAccountTransaction firstBankAccountTransaction = accountTransactions.get(0);
        assertEquals(expectedFirstTransactionAmount, firstBankAccountTransaction.getAmount());
        assertEquals(expectedFirstTransactionType.name(), firstBankAccountTransaction.getType().name());
        assertEquals(expectedFirstTransactionDescription, firstBankAccountTransaction.getDescription());

        BankAccountTransaction secondBankAccountTransaction = accountTransactions.get(1);
        assertEquals(expectedSecondTransactionAmount, secondBankAccountTransaction.getAmount());
        assertEquals(expectedSecondTransactionType.name(), secondBankAccountTransaction.getType().name());
        assertEquals(expectedSecondTransactionDescription, secondBankAccountTransaction.getDescription());

        BankAccountTransaction thirdBankAccountTransaction = accountTransactions.get(2);
        assertEquals(expectedThirdTransactionAmount, thirdBankAccountTransaction.getAmount());
        assertEquals(expectedThirdTransactionType.name(), thirdBankAccountTransaction.getType().name());
        assertEquals(expectedThirdTransactionDescription, thirdBankAccountTransaction.getDescription());

        printSucceedTestMessage("testGettingTransactions");
    }
}
