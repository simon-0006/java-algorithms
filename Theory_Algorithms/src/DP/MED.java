package DP;

public class MED { // minimal Editing distance
	
	public static void main(String[] args) {
		
		String str1 = "Tiger";
		String str2 = "Ziege";
		System.out.println(editierDistanz(str1, str2));
	}
	
	public static int editierDistanz(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		
		int[][] dpTable = new int[m + 1][n + 1];
		
		for(int i = 0; i <= m; i ++) {
			for(int j = 0; j <= n; j ++) {
				if     (i == 0) {dpTable[i][j] = j;}
				else if(j == 0) {dpTable[i][j] = i;}
				
				else if(s1.charAt(i - 1) == s2.charAt(j - 1)) {dpTable[i][j] = dpTable[i - 1][j - 1];}
				else {
					dpTable[i][j] = 1 + Math.min(dpTable[i - 1][j], Math.min(dpTable[i][j - 1], dpTable[i - 1][j - 1]));
				}
				
			}
		}
		
		return dpTable[m][n];
	}

}
