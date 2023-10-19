package Test;
import SortingAlgorithms.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import Datastructures.*;

class SortingTest {

	@Test
	public void testMergeSort() {
		int startarraylength = 1;
		int testcases = 100;
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = bubbleSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	public static int[] bubbleSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		return BubbleSort.algo1(arr);
	}
	
	// Array Generator
	public static int[] randomintarr(int length, int limit) {
		Random generator = new Random();
		
		int[] arr = new int[length];
		
		for(int i = 0; i < length; i++) {
			arr[i] = generator.nextInt() % limit;
		}
		
		return arr;
		
	}
	

}
