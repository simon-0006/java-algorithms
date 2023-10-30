package DP;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private static Map<Integer, Long> memo = new HashMap<>();
	
	// Testing
	public static void main(String[] args) {for(int i = 0; i < 41; i++) System.out.println(recmemo(i) + " " + dynFib(i));}
	
	// top - down: Momoization
	public static long recmemo(int n) {
		if (n <= 1) return n;
		
		if (memo.containsKey(n)) return memo.get(n);
		
		long result = recmemo(n-1) + recmemo(n-2);
		memo.put(n, result);
		
		return result;
	}
	
	// bottom - up: 
	public static long dynFib(int n) {
		if(n == 0) return 0;
		
		memo.put(1, (long) 1);
		memo.put(2, (long) 1);
		
		for(int i = 3; i<= n; i++) {
			memo.put(i, (memo.get(i - 1) + memo.get(i-2)));
		}
		
		return memo.get(n);
		
	}
	
}
