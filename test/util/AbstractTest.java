package test.util;

/**
 * Created by Matheus Schmitz on 10/20/22.
 */
public abstract class AbstractTest {

    protected void assertEquals(String expected, String actual) {
        if (!expected.equals(actual))
            throwAssertionError(expected, actual);
    }

    protected void assertEquals(int expected, int actual) {
        if (expected != actual)
            throwAssertionError(String.valueOf(expected), String.valueOf(actual));
    }

    protected void assertEquals(double expected, double actual) {
        if (expected != actual)
            throwAssertionError(String.valueOf(expected), String.valueOf(actual));
    }

    protected void printSucceedTestMessage(String testTitle) {
        System.out.println("[+] Test " + testTitle + " passed successfully!");
    }

    private void throwAssertionError(String expected, String actual) {
        throw new AssertionError("Assertion failed | Expected: " + expected + " - Actual: " + actual);
    }
}
