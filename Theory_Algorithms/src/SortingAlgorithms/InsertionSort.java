package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public static int[] algo1(int[] arr){ 
		if(IsSorted.array(arr) == true) {return arr;}
		
		// durch alle Werte von arr
		for(int k = arr.length-1; k >= 1; k--) {
			
			// suche grössten Wert
			int biggest = 0;
			for(int i = 1; i<=k; i++) {
				if(arr[biggest] < arr[i]) {biggest = i;}
			}
			
			// Do the swap biggest an hinterste Stelle k
			int arri = arr[biggest];
			arr[biggest] = arr[k];
			arr[k] = arri;
			
		}
		
		return arr;
	}
}
