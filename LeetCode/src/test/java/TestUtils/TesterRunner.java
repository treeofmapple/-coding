package testutils;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;
import static org.apiguardian.api.API.Status.STABLE;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apiguardian.api.API;
import org.junit.jupiter.params.ParameterizedTest;

import constructors.ListNode;
import functions.Colors;
import functions.Others;

/**
 * A class that provides methods to run different types of inputs, for testing.
 * Utilizes Junit Jupiter assertions to compare the expected value and the actual to print if is valid. Also prints the test status and runtime.
 * 
 * @author trikwcc
 * 
 * @version r1.0
 * @since 2024-08-07
 */

@API(status = STABLE, since = "r1.0")
public abstract class TesterRunner {
	private static Others othz;

	/**
	 * Runs the test with a specified assertion and prints the status, expected value, and how long it took to run. 
	 * 
	 * @param assertion 
	 * @param expected, expected value you wanna it to be.
	 * @param actual, actual of the operation you wanna to be tested.
	 * @since r1.0
	 */
	@API(status = STABLE, since = "r1.0")
    private void EqualsTest(Runnable assertion, Object expected, Object actual) {
        String status = Colors.ANSI_GREEN + getCurrentMethodName() + " : { Test passed }" + Colors.ANSI_RESET;
        long startTime = System.currentTimeMillis();
        try {
            assertion.run();
        } catch (AssertionError | NullPointerException e) {
            status = Colors.ANSI_RED + getCurrentMethodName() + " : { Test failed }" + Colors.ANSI_RESET;
        }
        long runtime = System.currentTimeMillis() - startTime;
        String color = runtime <= 8 ? Colors.ANSI_GREEN : Colors.ANSI_RED;
        System.out.println(status);
        System.out.println("Result: " + actual + " || Expected: " + expected);
        System.out.println("Runtime: " + color + runtime + "ms" + Colors.ANSI_RESET + "\n");
    }
    
	/**
	 * Runs the test with a specified assertion and prints the status, expected value, and how long it took to run. 
	 * 
	 * @param assertion 
	 * @param expected, expected value you wanna it to be.
	 * @param actual, actual of the operation you wanna to be tested.
	 * @since r1.1
	 */
	@API(status = STABLE, since = "r1.1")
    private void NotEqualsTest(Runnable assertion, Object expected, Object actual) {
        String status = Colors.ANSI_GREEN + getCurrentMethodName() + " : { Test passed }" + Colors.ANSI_RESET;
        long startTime = System.currentTimeMillis();
        try {
            assertion.run();
        } catch (AssertionError | NullPointerException e) {
            status = Colors.ANSI_RED + getCurrentMethodName() + " : { Test failed }" + Colors.ANSI_RESET;
        }
        long runtime = System.currentTimeMillis() - startTime;
        String color = runtime <= 8 ? Colors.ANSI_GREEN : Colors.ANSI_RED;
        System.out.println(status);
        System.out.println("Result: " + actual + " || Expected: " + expected);
        System.out.println("Runtime: " + color + runtime + "ms" + Colors.ANSI_RESET + "\n");
    }
	
	/**
	 * 
	 */
	
	@API(status = STABLE, since = "r1.0")
    private String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[4].getMethodName();
    }
	
	@API(status = EXPERIMENTAL, since = "r1.1")
	private boolean isParameterizedTest(Method method) {
	    Annotation[] annotations = method.getAnnotations();
	    for (Annotation annotation : annotations) {
	        if (annotation.annotationType().equals(ParameterizedTest.class)) {
	            return true;
	        }
	    }
	    return false;
	}
	
    /**
     * Runs a test to compare two int
     * 
     * @param expected. Recieve an int with the value you that you expect the actual returns.
     * @param result. Recieve an int with the value that you wanna use to test.
     * @since r1.0
     */

	@API(status = EXPERIMENTAL, since = "r1.1")
    public <T> void runTestEquals(T expected, T actual) {
        EqualsTest(() -> assertEquals(expected, actual), expected, actual);
    }
    
    public <T> void runTestEquals(T[] expected, T[] actual) {
        EqualsTest(() -> assertArrayEquals(expected, actual), java.util.Arrays.toString(expected), java.util.Arrays.toString(actual));
    }

    public <T> void runTestEquals(T[][] expected, T[][] actual) {
        EqualsTest(() -> assertArrayEquals(expected, actual), othz.setArray(expected), othz.setArray(actual));
    }
    
    @API(status = STABLE, since = "r1.0")
    public void runTestEquals(ListNode expected, ListNode actual) {
        EqualsTest(() -> assertEquals(expected, actual), expected, actual);
    }
    
    @API(status = EXPERIMENTAL, since = "r1.1")
    public <T> void runTestNotEquals(T expected, T actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), expected, actual);
    }
    
    public <T> void runTestNotEquals(T[] expected, T[] actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), Arrays.toString(expected), Arrays.toString(actual));
    }
    
    public <T> void runTestNotEquals(T[][] expected, T[][] actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), othz.setArray(expected), othz.setArray(actual));
    }
    
    private <T> void checkNotEqualValues(T expected, T actual) {
        if (expected == actual) {
            throw new AssertionError("Values are equal!");
        }
    }
}
