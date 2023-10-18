package Test;
import java.util.Arrays;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import SearchAlgorithms. *;
import SortingAlgorithms.*;

public class TestSearching {

	public static void main(String[] args) {
		
		// for all testcases
		int startarraylength = 1;
		int testcases = 100;
		
		// Binary Test algo 1
		System.out.println("Binary Search");
		
		for(int j = 1; j<=2; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = binaryTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Interpolation Search
		System.out.println("\nInterpolation Search:");
		
		for(int j = 1; j<=2; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = interpolationTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Exponential Search
		System.out.println("\nExponential Search:");
		
		for(int j = 1; j<=2; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				boolean binary = exponentialTest(i, j);
				if(binary == true) {count++;}
				else {failure++;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
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
	
	// Ist es richtig sortiert
	
	public static boolean arrayequality(int[] arr1) {
		
		int[] arr2 = arr1.clone();
				
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
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
