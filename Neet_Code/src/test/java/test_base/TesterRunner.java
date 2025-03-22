package test_base;

import static org.apiguardian.api.API.Status.STABLE;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;

import org.apiguardian.api.API;

public class TesterRunner implements Colors {

	@API(status = STABLE, since = "r1.311")
    private void EqualsTest(Runnable assertion, Object expected, Object actual) {
        String status;
        long startTime = System.currentTimeMillis();
        try {
            assertion.run();
            status = Colors.ANSI_GREEN + getCurrentMethodName() + " : { Test passed }" + Colors.ANSI_RESET;
        } catch (AssertionError | NullPointerException e) {
            status = Colors.ANSI_RED + getCurrentMethodName() + " : { Test failed }" + Colors.ANSI_RESET;
        }
        long runtime = System.currentTimeMillis() - startTime;
        String color = runtime <= 8 ? Colors.ANSI_GREEN : Colors.ANSI_RED;
        System.out.println(status);
        System.out.println("Result: " + actual + " || Expected: " + expected);
        System.out.println("Runtime: " + color + runtime + "ms" + Colors.ANSI_RESET + "\n");
    }
    
	@API(status = STABLE, since = "r1.311")
    private void NotEqualsTest(Runnable assertion, Object expected, Object actual) {
        String status;
        long startTime = System.currentTimeMillis();
        try {
            assertion.run();
            status = Colors.ANSI_GREEN + getCurrentMethodName() + " : { Test passed }" + Colors.ANSI_RESET;
        } catch (AssertionError | NullPointerException e) {
            status = Colors.ANSI_RED + getCurrentMethodName() + " : { Test failed }" + Colors.ANSI_RESET;
        }
        long runtime = System.currentTimeMillis() - startTime;
        String color = runtime <= 8 ? Colors.ANSI_GREEN : Colors.ANSI_RED;
        System.out.println(status);
        System.out.println("Result: " + actual + " || Expected: " + expected);
        System.out.println("Runtime: " + color + runtime + "ms" + Colors.ANSI_RESET + "\n");
    }
	
	@API(status = STABLE, since = "r1.311")
    private String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return stackTrace[4].getMethodName();
    }
	
	@API(status = STABLE, since = "r1.311")
    public <T> void runTestEquals(T expected, T actual) {
        EqualsTest(() -> assertEquals(expected, actual), expected, actual);
    }
    
	@API(status = STABLE, since = "r1.311")
	public void runTestEquals(int[] expected, int[] actual) {
	    EqualsTest(() -> assertArrayEquals(expected, actual), Arrays.toString(expected), Arrays.toString(actual));
	}

	@API(status = STABLE, since = "r1.311")
    public <T> void runTestEquals(T[][] expected, T[][] actual) {
        EqualsTest(() -> assertArrayEquals(expected, actual), Arrays.deepToString(expected), Arrays.deepToString(actual));
    }
    
	@API(status = STABLE, since = "r1.311")
    public <T> void runTestNotEquals(T expected, T actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), expected, actual);
    }
    
	@API(status = STABLE, since = "r1.311")
    public <T> void runTestNotEquals(T[] expected, T[] actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), Arrays.toString(expected), Arrays.toString(actual));
    }
    
	@API(status = STABLE, since = "r1.311")
    public <T> void runTestNotEquals(T[][] expected, T[][] actual) {
    	checkNotEqualValues(expected, actual);
    	NotEqualsTest(() -> assertNotEquals(expected, actual), setArray(expected), setArray(actual));
    }
    
	@API(status = STABLE, since = "r1.311")
    private <T> void checkNotEqualValues(T expected, T actual) {
        if (expected == null && actual == null) {
            throw new AssertionError("Both values are null!");
        }
        if (expected != null && expected.equals(actual)) {
            throw new AssertionError("Values are equal!");
        }
    }
    
	@API(status = STABLE, since = "r1.311")
	private <T> String setArray(T[][] array) {
		return this.printArray(array);
	}

	@API(status = STABLE, since = "r1.311")
	private <T> String printArray(T[][] array) {
		if (array == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < array.length; i++) {
			sb.append("{");
			if (array[i] != null) {
				for (int j = 0; j < array[i].length; j++) {
					sb.append(array[i][j]);
					if (j < array[i].length - 1) {
						sb.append(", ");
					}
				}
			}
			sb.append("}");
			if (i < array.length - 1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
