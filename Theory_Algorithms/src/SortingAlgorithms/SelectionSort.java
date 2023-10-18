package SortingAlgorithms;

import java.util.Arrays;

import SearchAlgorithms.BinarySearch;

public class SelectionSort {
	public static int[] algo1(int[] arr) {
		if(IsSorted.array(arr) == true) {return arr;}
		
		// durch alle Werte von Array
		for(int k = 0; k < arr.length-1; k++) {
			
			// Binary Search um arr[k+1] von 0...k einzusetzen
			int pos = 0;
			for(int i = 0; i <= k; i++) {
				if(arr[k+1] >= arr[i]) {pos += 1;}
			}

			
//			für den fall das es -1 returned weil es grösser als der grösste wert im Array ist
			int b = arr[k+1];
			
			for(int j = k; j >= pos; j--) {
				arr[j+1] = arr[j];	// alle Werte rutschen hoch
			}
			arr[pos] = b;
			
		}
		
		return arr;
	}
}
