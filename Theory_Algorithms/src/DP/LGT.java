package DP;

import java.util.Arrays;

public class LGT { // Längste gemeinsame Teilfolge
	
	// Tester
	public static void main(String[] args) {
		String str1 = "Tigerpeterduenkelphalten"; 
		String str2 = "Ziegenmeierhanshalloween";
		
		System.out.println(dynLGT(str1, str2));
	}
	
	public static int dynLGT(String str1, String str2) {
		
		// initialize
		int[][] dpTable = new int[str1.length() + 1][str2.length() + 1];
		
		char[] w1 = str1.toUpperCase().toCharArray();
		char[] w2 = str2.toUpperCase().toCharArray();
		
		
		int equal;
		
		for(int i = 0; i < str2.length() + 1; i ++) dpTable[0][i] = 0;
		for(int i = 0; i < str1.length() + 1; i ++) dpTable[i][0] = 0;
		
		// dynLGT
		for(    int i = 1; i < str1.length() + 1; i ++) {
			for(int j = 1; j < str2.length() + 1; j ++) {
				if(w1[i-1] == w2[j-1]) equal = 1;
				else{equal = 0;}
				
				dpTable[i][j] = Math.max(dpTable[i-1][j-1] + equal, Math.max(dpTable[i][j-1], dpTable[i-1][j]));
			}
		}
		
		System.out.println("Teilfolge: " + recapSol(dpTable, str1.length() + 1, str2.length() + 1, w1, w2));
		
		// print DPTable
		for(int[] i: dpTable) {
			for(int j: i) System.out.print(j + " ");
			System.out.println("\n");
		}
		return dpTable[str1.length()][str2.length()];
	}
	
	
	private static String recapSol(int[][] arr, int length1, int length2, char[] w1, char[] w2) {
		int l1 = length1-1;
		int l2 = length2-1;
		
		int ref = arr[l1][l2];
		String tf = "";
		
		while(ref != 0) {
			if(w1[l1-1] == w2[l2-1] && arr[l1 -1 ][l2 - 1] + 1 == arr[l1][l2]) {
				tf = "" + w1[l1-1] + tf;
				l1 -= 1;
				l2 -= 1;}
			
			else if(arr[l1 -1 ][l2] == arr[l1][l2]) {l1 -= 1;}
			else if(arr[l1][l2 - 1] == arr[l1][l2]) {l2 -= 1;}
			
			ref = arr[l1][l2];
		}
		
		return tf;
	}

}
