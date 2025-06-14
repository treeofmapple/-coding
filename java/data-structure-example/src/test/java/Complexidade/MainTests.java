package Complexidade;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import Others.Colors;
import Others.Others;

public class MainTests {
	
	private static Others othz;
	
	public void runTest(Runnable assertion, Object expected, Object result, String testName) {
		if(testName == null || testName.isEmpty()) {
			testName = getCurrentMethodName();
		}
		try {
			assertion.run();
			System.out.println(Colors.ANSI_GREEN + testName + " : {Test passed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
		} catch (AssertionError | NullPointerException e) {
			System.out.println(Colors.ANSI_RED + testName + " : {Test failed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
			throw e;
		}
	}
	
	@Deprecated
	/*
	 * Need to fix
	 * */
	public void runTimeTest(Runnable assertion, Object expected, Object result, String testName) {
		if (testName == null || testName.isEmpty()) {
			testName = getCurrentMethodName();
		}
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Time of application: " + testName + "\nRunned: " + duration);
		
		try {
			assertion.run();
			System.out.println(Colors.ANSI_GREEN + testName + " : {Test passed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
		} catch (AssertionError | NullPointerException e) {
			System.out.println(Colors.ANSI_RED + testName + " : {Test failed}" + Colors.ANSI_RESET);
			System.out.println("Result: " + result + " || Expected: " + expected + "\n");
			throw e;
		}
	}

	// Create a test to test the speed on inserting variables, or running time how fast it runs depending on inserting values;
	
	@Deprecated
	/*
	 * Need to fix
	 * */
	public void runTestTime(int expected, int result, String testName) {
		runTimeTest(() -> assertEquals(expected, result), expected, result, testName);
	}

	public void runTestEquals(int expected, int result, String testName) {
		runTest(() -> assertEquals(expected, result), expected, result, testName);
	}
	
	public void runTestEquals(String expected, String result, String testName) {
		runTest(() -> assertEquals(expected, result), expected, result, testName);
	}
	
	public void runTestEquals(int[] expected, int[] result, String testName) {
		runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result), testName);
	}
	
	public void runTestEquals(int[][] expected, int[][] result, String testName) {
		runTest(() -> assertArrayEquals(expected, result), othz.setArray(expected), othz.setArray(result), testName);
	}
	
    public void runTestEquals(String[] expected, String[] result, String testName) {
    	runTest(() -> assertArrayEquals(expected, result), java.util.Arrays.toString(expected), java.util.Arrays.toString(result), testName);
    }
    
    public void runTestEquals(Boolean expected, Boolean result, String testName) {
    	runTest(() -> assertEquals(expected, result), expected, result, testName);
    }
    
	private String getCurrentMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return stackTrace[4].getMethodName();
		// [0] is getStackTrace, [1] is getCurrentMethodName, [2] is runTestXXX, [3] is
		// the calling test method
	}
}
