package uebungsalgo;

public class W4_Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fibonacciRec(10));
		System.out.println(fibonacciFor(100));
	}
	
	public static int fibonacciRec(int n) {
		if(n==0) {
			return 0;} 
		else if(n==1){
			return 1;}
		return fibonacciRec(n-1) + fibonacciRec(n-2);
	}
	
	public static long fibonacciFor(long n) {
		long first = 0;
		long second = 1;
		long third = 0;
		
		for(int i = 2; i <= n; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		
		return third;
	}

}
