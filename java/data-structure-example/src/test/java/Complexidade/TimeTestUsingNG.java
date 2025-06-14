package Complexidade;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TimeTestUsingNG {

	private Complexidade comp;
	private int[] array;

	@BeforeClass
	void setUp() {
		comp = new Complexidade();
		array = new int[1000];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * 1000);

	}

	@Test
	void testisIn() {
		int chave = array[500];
		long startTime = System.nanoTime();
		int result = comp.isIn(chave, array);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		
		System.out.println("isIn execution time: " + duration + " nanoseconds");
		Assert.assertTrue(result != -1);
		
	} 
	
    @Test
    public void testIsInBinario() {
        comp.ordena(array); // Binary search requires a sorted array
        int chave = array[500]; // Element we know is in the array
        long startTime = System.nanoTime();
        int result = comp.isInBinario(chave, array);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("isInBinario execution time: " + duration + " nanoseconds");
        Assert.assertTrue(result != -1);
    }

    @Test
    public void testOrdena() {
        int[] unsortedArray = new int[1000];
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedArray[i] = (int) (Math.random() * 1000);
        }
        long startTime = System.nanoTime();
        comp.ordena(unsortedArray);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ordena execution time: " + duration + " nanoseconds");

        // Verify the array is sorted
        for (int i = 0; i < unsortedArray.length - 1; i++) {
            Assert.assertTrue(unsortedArray[i] <= unsortedArray[i + 1]);
        }
    }
	
    
    
	
}
