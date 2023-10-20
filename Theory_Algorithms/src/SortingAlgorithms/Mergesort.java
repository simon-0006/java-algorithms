package SortingAlgorithms;

import java.util.Arrays;

public class Mergesort {
	
	public static int[] algo1_rekursiv(int[] arr, int left, int right) {
		
		if(left < right) {
			int middle = (left + right)/2;
			
			algo1_rekursiv(arr, left, middle);
			algo1_rekursiv(arr, middle + 1, right);
			merges(arr, left, middle, right);
		}
		return arr;
	}
	
	public static int[] algo2_straight(int[] arr) {
		int len = 1;
		int l, m;
		
		while(len < arr.length) {
			int r = 0;
			
			while(r+len < arr.length) {
				l = r + 1;
				m = l + len -1;
				r = Math.min(m + len, arr.length);
				merges(arr, l, m, r);
			}
			
			len *= 2;
		}
		return arr;
	}
	
	public static int[] merges(int[] arr, int left, int middle, int right) {
		
		int[] B = new int[right-left + 1];
		int i = left, j = middle + 1, k = 0;
		
		while (i <= middle && j <= right) {
			if(arr[i] < arr[j]) {
				B[k] = arr[i];
				i += 1;} 
			else {
				B[k] = arr[j];
				j += 1;}
			
			k += 1;
		}
		
		// Rest dazuschreiben
		while (i <= middle) {
			B[k++] = arr[i++];}
		
		while(j <= right) {
			B[k++] = arr[j++];}
		
		for(int m = left; m <= right; m ++) {arr[m] = B[m-left];}

		
		return arr;
	}
	
	
	
}
