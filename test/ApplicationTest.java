package test;

import test.adapterstest.Bank1AccountAdapterTest;
import test.adapterstest.Bank2AccountAdapterTest;

/**
 * Application execution class to run unit tests.
 * <p>
 * Created by Matheus Schmitz on 10/20/22.
 */
public class ApplicationTest {

    public static void main(String[] args) {
        System.out.println("Running Bank1AccountAdapterTest tests:");
        new Bank1AccountAdapterTest().runTests();
        System.out.println("\nRunning Bank2AccountAdapterTest tests:");
        new Bank2AccountAdapterTest().runTests();
    }
}
