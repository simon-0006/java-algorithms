package SearchAlgorithms;
import java.util.Arrays;

public class ExponantialSearch {

	public static int algo1(int[] arr, int k) {
		int r = 1;
		
		while(r < arr.length && k >= arr[r]) {
			r *= 2;
		}
		
		return SearchAlgorithms.BinarySearch.algo1(arr, 0, (int) Math.min(r, arr.length), k);
	}
	
	public static int algo2(int[] arr, int k, int expo) { // default expo = 2
		if(expo < arr.length && k >= arr[expo]) {return algo2(arr, k, expo *= 2);} // Rekursiv
		else {
			return SearchAlgorithms.BinarySearch.algo1(arr, 0, (int) Math.min(expo, arr.length), k);
		}
		
	}
}
