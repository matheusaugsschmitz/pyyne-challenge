package com.pyyne.challenge.bank;

import com.pyyne.challenge.bank.controller.BankController;

/**
 * Application execution class to run BankController methods and print either balances and transactions.
 * <p>
 * Created by Matheus Schmitz on 10/20/22.
 */
public class Application {

    public static void main(String[] args) {
        BankController controller = new BankController();
        System.out.println("PRINTING BALANCES...");
        controller.printBalances();
        System.out.println();
        System.out.println("PRINTING TRANSACTIONS...");
        controller.printTransactions();
    }
}
