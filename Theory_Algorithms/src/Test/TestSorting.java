package Test;
import SortingAlgorithms.*;

import java.util.Arrays;
import java.util.Random;

public class TestSorting {
	
	public static void main(String[] args) {
		
		// for all testcases
		int startarraylength = 1;
		int testcases = 100;
		
		// Bubble Sort Test algo 1
		System.out.println("Bubble Sort");
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = bubbleSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Insertion Sort Test algo 1
		System.out.println("\nInsertion Sort");
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = insertionSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Selection Sort Test algo 1
		System.out.println("\nSelection Sort");
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = selectionSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Quick Sort Test algo 1
		System.out.println("\nQuickSort");
		
		for(int j = 1; j<=2; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = quickSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		
		// Merge Sort Test algo 1
		System.out.println("\nMergeSort");
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = mergeSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
			}
			System.out.println("Algotest " + j + " : " + count + " - richtig | falsch - " + failure);
		}
		System.out.println("Algo 2 (straight) noch nicht korrekt");
				
		// Heap Sort Test algo 1
		System.out.println("\nHeap Sort");
		
		for(int j = 1; j<=1; j++) {
			int count = 0;
			int failure = 0;
			
			for(int i = startarraylength; i<= testcases; i++) {
				int[] binary = heapSortTest(i, j);
				if(IsSorted.array(binary) == true) {++count;}
				else {++failure;}
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
		
	// Sorting Algorithms
	public static int[] bubbleSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
//		Arrays.sort(arr);
		
		
		// Algo 1
//		if(algotest == 1) {algotest = BubbleSort.algo1(arr);} 
		
//		if(arr[index] == arr[algotest]) {return true;}
		
		return BubbleSort.algo1(arr);
	}
	
	public static int[] insertionSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
//		Arrays.sort(arr);
		
		return InsertionSort.algo1(arr);
	}
	
	public static int[] selectionSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
//		Arrays.sort(arr);
		
		return SelectionSort.algo1(arr);
	} 
	
	public static int[] quickSortTest(int index, int algotest) {
		int[] arr = randomintarr(index*2, 100);
//		Arrays.sort(arr);
		
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
//		Arrays.sort(arr);
		
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
//		Arrays.sort(arr);
		
		return Heapsort.algo1(arr);
	
	}
}
