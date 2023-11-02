package DP;

public class LAT {// längste Aufsteigende Teilfolge
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,13,17,9,11,4,78,28,15,25,99};
		
		System.out.println(dynLat(arr));
	}
	
	public static int dynLat(int[] arr) {
		int[][] dpTable = new int[arr.length][arr.length];
		
		// dynamic programming
		
		return tableToString(dpTable);
	}
	
	public static int tableToString(int[][] dpTable) {
		return 5;
	}
	
}
