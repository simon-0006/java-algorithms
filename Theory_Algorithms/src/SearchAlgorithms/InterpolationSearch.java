package SearchAlgorithms;

import java.util.Arrays;

// Interpolation Search differentiates itself from binary search by predicting a value in a spot of an array
public class InterpolationSearch {
	public static int algo1(int[] arr, int k) {
		int left = 0;
		int right = arr.length - 1;
		
		int middle = 0;
		
		while(left<=right) {
			int rho = (k - arr[left])/(arr[right] - arr[left]); // Veränderung zu Binary Search
			
			middle = (int) left + rho * (right - left);
			int val_middle = arr[middle];
			
			if(val_middle == k) {return middle;} // wenn value gefunden
			else if (val_middle > k) {right = middle-1;} // wenn value unterhal
			else {left = middle+1;} // wenn value oberhalb der Mitte
		}
		
		return -1;
	}
	
	public static int algo2(int[] arr, int k, int index) { // index per default = 0
		
		int left = 0;
		int right = arr.length - 1;
		
		int rho = (k - arr[left])/(arr[right] - arr[left]); // Veränderung zu Binary Search
		
		int middle = (int) left + rho * (right - left);
		
		int[] arrayleft = Arrays.copyOfRange(arr, 0, (int) Math.floor(arr.length/2)); 
		int[] arrayright = Arrays.copyOfRange(arr, (int) Math.ceil(arr.length/2), arr.length);
		
		if(arr[middle] == k ) {return middle + index;} // wenn value gefunden
		else if (arr[middle] > k) {return algo2(arrayleft, k, index);} // wenn value unterhal
		else {return algo2(arrayright, k, arrayleft.length + index);} // wenn value oberhalb der Mitte
	}
}
