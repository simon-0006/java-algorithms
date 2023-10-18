package SortingAlgorithms;

public class IsSorted {
	
	// Test ob ein Array sortiert ist
	public static boolean array(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {return false;}
		}
		return true;
	}
}
