package CodeExpert;

import java.util.Arrays;

public class MaxSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 7, 5, 2,1 ,9 ,0, 8, 7, 6};
		System.out.println(Arrays.toString(arr));
		
		System.out.println(maxSubset(arr.length, 4, arr));

	}
	
	public static int maxSubset(int n, int k, int[] A) {
	    // TODO: code
	    selectionSort(n, A);
	    
	    int max = 0;
	    int helpidx = 0, low = 0;
	    
	    while(true) {
	        if(helpidx + 1 < n && A[0] + k >= A[helpidx + 1]) {++helpidx; ++max;} 
	        else {break;}
	        
	      }
	    
	    for(int i = helpidx + 1; i < n; i ++) {
	      
	    	while(A[i]-k > A[low]) {++low;}
	    	
	    	if(i-low+1 > max) {max = i-low+1;}
	      
	    }
	    
	    return max;
	  }
	  
	  public static int[] selectionSort(int n, int[] arr) {
	    
	    for(int i = n - 1; i >= 1; i--) {
	      int idxMaxVal = i;
	      
	      for(int j = i -1; j >= 0; j--) {
	        if(arr[idxMaxVal] < arr[j]) {idxMaxVal = j;}
	      }
	      
	      int tmp = arr[i];
	      arr[i] = arr[idxMaxVal];
	      arr[idxMaxVal] = tmp;
	      
	    }
	    
	    return arr;
	    
	  }

}
