package DP;

public class JumpGame {
	
	// Tester
	public static void main(String[] args) {
		int[] minarr = new int[] {1,3,2,4,5,3,4,2,3,1,1,4,5,3,2,1,4,0,0,0,1,3,2,1,2,1,1,1,3,2,1}; System.out.println(jumpdyn(minarr));}
	
	
	public static int jumpdyn(int[] arr) {
		int[] maxJump = new int[arr.length];
		
		int k = 1;
		maxJump[0] = 0;
		maxJump[1] = arr[0];

		while (maxJump[k] < arr.length-1) {
			k = k + 1;
			maxJump[k] = maxInSub(arr, maxJump[k-2], maxJump[k-1]);
			// hat m[k-1] - M[k-2] Elemente
		}
		return k;
	}
	
	private static int maxInSub(int[] arr, int left, int right) {
		// Math.max: i + S[i] | maxJump[k-2] < i <= maxJump[k-1]
		int tmpmax = 0;
		
		for(int i = left; i <= right; i++) {
			if(i + arr[i] > tmpmax) tmpmax = arr[i] + i;
		}
		
		return tmpmax;
	}
	
}
