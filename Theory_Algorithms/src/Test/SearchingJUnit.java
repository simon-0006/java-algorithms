package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class SearchingJUnit {
	int startarraylength = 1;
	int testcases = 100;
	
	int count, failure;

	@Test
	void binarySearch() {
		// Binary Test algo 1
		
		for(int j = 1; j<=2; j++) {
			count = 0;
			failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = binaryTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			assertTrue(count == testcases);
		}
	}
	
	@Test
	void interpolationSearch() {
		// Binary Test algo 1
		
		for(int j = 1; j<=2; j++) {
			count = 0;
			failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = interpolationTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			assertTrue(count == testcases);
		}
	}
	
	@Test
	void exponentialSearch() {
		// Binary Test algo 1
		
		for(int j = 1; j<=2; j++) {
			count = 0;
			failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = exponentialTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			assertTrue(count == testcases);
		}
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
	
	// Search Algorithms
	public static boolean binaryTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		Arrays.sort(arr);
		
		
		// Algo 1
		if(algotest == 1) {algotest = SearchAlgorithms.BinarySearch.algo1(arr, 0, arr.length, arr[index]);} 
		
		// Algo 2
		else if (algotest == 2) {algotest = SearchAlgorithms.BinarySearch.algo2(arr, arr[index],0);}
		
		if(arr[index] == arr[algotest]) {return true;}
		
		return false;
	}
	
	public static boolean interpolationTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		Arrays.sort(arr);
		
		// Algo 1
		if(algotest == 1) {algotest = SearchAlgorithms.InterpolationSearch.algo1(arr, arr[index]);} 
		
		// Algo 2
		else if (algotest == 2) {algotest = SearchAlgorithms.InterpolationSearch.algo2(arr, arr[index],0);}
		
		if(arr[index] == arr[algotest]) {return true;}
		
		return false;
	}
	
	public static boolean exponentialTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		Arrays.sort(arr);
		
		// Algo 1
		if(algotest == 1) {algotest = SearchAlgorithms.ExponantialSearch.algo1(arr, arr[index]);} 
		
		// Algo 2
		else if (algotest == 2) {algotest = SearchAlgorithms.ExponantialSearch.algo2(arr, arr[index], 2);}
		
		if(arr[index] == arr[algotest]) {return true;}
		
		return false;
	}

}
