package SortingAlgorithms;
//comment
public class BubbleSort {

	public static int[] algo1(int[] arr) {
		if(IsSorted.array(arr) == true) {return arr;}
		
		for(int j = 0; j < arr.length-1; j++) {
			for(int i = 0; i < arr.length-1; i++) {
				if(arr[i] > arr[i+1]) {
					
					// Do the swap arr_i arr_i+1
					int arri = arr[i];
					arr[i] = arr[i+1];
					arr[i + 1] = arri;
					
					// Könnte noch verbessert werden wenn es ein count gibt, wie viele swaps stattfanden pro Loop
					// ist der Count 0 bedeuted das, dass der Array sortiert ist und bricht den Loop ab
				}
			}
		}
		
		return arr;
	}
}
