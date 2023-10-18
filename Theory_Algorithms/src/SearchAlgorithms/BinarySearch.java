package SearchAlgorithms;

import java.util.Arrays;

public class BinarySearch {
	public static int algo1(int[] arr, int left, int right, int key) { // index from left to right (default for hole array: left = 0; right = arr.length - included default = 1 sonst gibt es den index wo es eingefügt werden muss
		left = 0;
		right -= 1;
		
		while(left <= right) {
			int middle = (int) Math.floor((left+right)/2);
						
			if(arr[middle] == key) {return middle;} // wenn value gefunden
			else if (arr[middle] > key) {right = middle-1;} // wenn value unterhal
			else {left = middle+1;} // wenn value oberhalb der Mitte
		}
		
		return -1;
	}
	
	public static int algo2(int[] arr, int k, int index) { // index per default = 0
		
		double left = 0;
		double right = arr.length - 1;
		
		int middle = (int) Math.floor((left+right)/2);
		
		int[] arrayleft = Arrays.copyOfRange(arr, 0, (int) Math.floor(arr.length/2)); 
		int[] arrayright = Arrays.copyOfRange(arr, (int) Math.ceil(arr.length/2), arr.length);
		
		if(arr[middle] == k ) {return middle + index;} // wenn value gefunden
		else if (arr[middle] > k) {return algo2(arrayleft, k, index);} // wenn value unterhal
		else {return algo2(arrayright, k, arrayleft.length + index);} // wenn value oberhalb der Mitte
	}
	
}
