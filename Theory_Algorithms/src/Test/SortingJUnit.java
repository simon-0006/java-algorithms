package Test;
import SortingAlgorithms.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;
import Datastructures.*;

class SortingJUnit {
	int startarraylength = 1;
	int testcases = 100;
	
	int count, failure;

	@Test
	public void bubbleSort() {
		
		for(int j = 1; j<=1; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = bubbleSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	@Test
	public void insertionSort() {
		
		for(int j = 1; j<=1; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = insertionSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	@Test
	public void selectionSort() {
		
		for(int j = 1; j<=1; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = selectionSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	@Test
	public void quickSort() {
		
		for(int j = 1; j<=2; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = quickSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	@Test
	public void mergeSort() {
		
		for(int j = 1; j<=1; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = mergeSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	@Test
	public void heapSort() {
		
		for(int j = 1; j<=2; j++) {
			count = 0; failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = heapSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
//			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
			assertTrue(count == testcases);
		}
	}
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------
	
	public static int[] bubbleSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		return BubbleSort.algo1(arr);
	}
	
	public static int[] insertionSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		return InsertionSort.algo1(arr);
	}
	
	public static int[] selectionSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		return SelectionSort.algo1(arr);
	} 
	
	public static int[] quickSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		if(algotest == 1) {
			return QuickSort.algo1_rekursiv(arr, 0, arr.length-1);
		}
		else if(algotest == 2) {
			return QuickSort.algo2_randomisiert(arr, 0, arr.length-1);
		}
		
		return arr;
		
	}
	
	public static int[] mergeSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		if(algotest == 1) {
			return Mergesort.algo1_rekursiv(arr, 0, arr.length-1);
		}
		else if(algotest == 2) {
			return Mergesort.algo2_straight(arr);
		}
		
		return arr;
		
	}
	
	public static int[] heapSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
		
		return Heapsort.algo1(arr);
	
	}

	//-----------------------------------------------------------------------------------------------------------------------------------

	
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
