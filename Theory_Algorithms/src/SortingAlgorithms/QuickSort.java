package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] test = {2,3,9,3,4,9,4,9,8,8};
		System.out.println(Arrays.toString(algo2_randomisiert(test, 0, test.length-1)));
	}

	public static int[] algo1_rekursiv(int [] arr, int l, int r) {
		
		if(l < r) {
			int pivot = arr[r];
			
			// Partition
			int i = l, j = r-1;
			
			while(true){
				while(i<r && arr[i] <= pivot) {++i;}
				while(j>l && arr[j] > pivot) {--j;}
				
				if(i<j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;}
				
				if(i >= j) {break;}
				
			}
			int temp = arr[i];
			arr[i] = pivot;
			arr[r] = temp;
			
			// Rekursion
			algo1_rekursiv(arr, l, i-1);
			algo1_rekursiv(arr, i+1, r);
		}
		
		return arr;
	}
	
public static int[] algo2_randomisiert(int [] arr, int l, int r) {
	
	
		
	if(l < r) {
		Random random = new Random();
		int ra = random.nextInt(l, r);
		
		// randomized int swap
		int temp = arr[ra];
		arr[ra] = arr[r];
		arr[r] = temp;
		
		int pivot = arr[r];
		
		// Partition
		int i = l, j = r-1;
		
		while(true){
			while(i<r && arr[i] <= pivot) {++i;}
			while(j>l && arr[j] > pivot) {--j;}
			
			if(i<j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;}
			
			if(i >= j) {break;}
			
		}
		temp = arr[i];
		arr[i] = pivot;
		arr[r] = temp;
		
		// Rekursion
		algo1_rekursiv(arr, l, i-1);
		algo1_rekursiv(arr, i+1, r);
	}
	
	return arr;
	}
	
}
