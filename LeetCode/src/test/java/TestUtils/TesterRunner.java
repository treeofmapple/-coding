package TestUtils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import constructors.ListNode;

public abstract class TesterRunner {
	private static Others othz;

    private void runTest(Runnable assertion, Object expected, Object result) {
        String testName = getCurrentMethodName();

        String status = Colors.ANSI_GREEN + testName + " : { Test passed }" + Colors.ANSI_RESET;
        long startTime = System.currentTimeMillis();
        try {
            assertion.run();
        } catch (AssertionError | NullPointerException e) {
            status = Colors.ANSI_RED + testName + " : { Test failed }" + Colors.ANSI_RESET;
        }
        long runtime = System.currentTimeMillis() - startTime;
        String color = runtime <= 8 ? Colors.ANSI_GREEN : Colors.ANSI_RED;

        System.out.println(status);
        System.out.println("Result: " + result + " || Expected: " + expected);
        System.out.println("Runtime: " + color + runtime + "ms" + Colors.ANSI_RESET + "\n");
    }

    public void runTestEquals(int expected, int result) {
        runTest(() -> assertEquals(expected, result), expected, result);
    }

    public void runTestEquals(int[] expected, int[] result) {
        runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result));
    }

    public void runTestEquals(int[][] expected, int[][] result) {
        runTest(() -> assertArrayEquals(expected, result), othz.setArray(expected), othz.setArray(result));
    }

    public void runTestEquals(String expected, String result) {
        runTest(() -> assertEquals(expected, result), expected, result);
    }

    public void runTestEquals(String[] expected, String[] result) {
        runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result));
    }

    public void runTestEquals(String[][] expected, String[][] result) {
        runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result));
    }

    public void runTestEquals(Boolean expected, Boolean result) {
        runTest(() -> assertEquals(expected, result), expected, result);
    }

    public void runTestEquals(Object expected, Object result) {
        runTest(() -> assertEquals(expected, result), expected, result);
    }

    public void runTestEquals(ListNode expected, ListNode result) {
        runTest(() -> assertEquals(expected, result), expected, result);
    }

    private String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[4].getMethodName();
        // [0] is getStackTrace, [1] is getCurrentMethodName, [2] is runTestXXX, [3] is the calling test method
    }
}
