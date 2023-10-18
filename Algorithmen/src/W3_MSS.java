import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class W3_MSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] testcase = {7, -11,15,110, -23, -3,127, -12,1};
		// int[] testcase = {47, -23, 11, -56, 37, -8, 92, -15, 64, -31, 8, -67, 55, -42, 26, -79, 19, -94, 70, -5, 33, -88, 2, -10, 51, -72, 16, -38, 84, -3, 43, -99, 61, -50, 7, -85, 29, -69, 97, -25, 53, -46, 22, -76, 75, -14, 31, -92, 13, -63, 59, -48, 5, -81, 67, -33, 38, -71, 10, -59, 49, -64, 17, -36, 79, -2, 45, -97, 63, -52, 24, -78, 72, -11, 35, -87, 21, -68, 94, -19, 58, -44, 27, -75, 7, -100, 54, -40, 28, -74, 76, -13, 32, -91, 15, -66, 9, -58, 50, -65, 14, -37, 80, -1, 44, -96, 62, -51, 25, -77};
		
		System.out.println(algo1(testcase));
		System.out.println(algo2(testcase));
		// System.out.println(algo3(testcase));
		
		int maxSum = maxSubarraySum(testcase, 0, testcase.length - 1);
		System.out.println(maxSum);
		
		System.out.println(algo4(testcase));
		
	}
	
	// Naiv
	public static int algo1(int[] arr) {
		
		int max = 0;
		int aktuell = 0;
		
		for(int i=0; i<arr.length -1; i++) {
			for(int j=i; j<=arr.length; j++ ) {
				for(int k=i; k<j; k++) {
					aktuell = 0;
					for(int f=i; f<k; f++) {
						aktuell += arr[f];
					}
					if (aktuell>max) {
						max = aktuell;
					
					}
				}
			}
		}
		return max;
		
	}
	
	// Addition Assoziativ
	public static int algo2(int[] arr) {
		
		int max = 0;
		int aktuell = 0;
		
		for(int i=0; i<arr.length -1; i++) {
			for(int j=i; j<=arr.length; j++ ) {
				for(int k=i; k<j; k ++) {
					aktuell = aktuell + arr[k];
				}
				if (aktuell>max) {
					max = aktuell;
				}
				aktuell = 0;
			}
		}
		return max;
		
	}
	
	// Rekursiv eigener Ansatz
	public static int algo3(int[] arr) {
		
		int max = 0;
		int acc = 0;
		
		if(arr.length >2) {
			int[] subarray1 = Arrays.copyOfRange(arr, 0, arr.length/2);
			int[] subarray2 = Arrays.copyOfRange(arr, (arr.length/2), arr.length);
			
			int subsubelement1 = algo3(subarray1);
			int subsubelement2 = algo3(subarray2);
			
			return Math.max(subsubelement1, Math.max(subsubelement2, subsubelement1+subsubelement2));
			
			
			
			
		} else {
			return Math.max(arr[0], 0);
		}
		
		
		
		
	}

	//Rekursiv Chat GPT
	public static int maxSubarraySum(int[] arr, int start, int end) {
        // Basisfall: Wenn die Liste nur ein Element enthält
        if (start == end) {
            return arr[start];
        }

        // Den Mittelpunkt der Liste berechnen
        int mid = (start + end) / 2;

        // Die maximale Teilsumme in der linken Hälfte berechnen
        int leftMax = maxSubarraySum(arr, start, mid);

        // Die maximale Teilsumme in der rechten Hälfte berechnen
        int rightMax = maxSubarraySum(arr, mid + 1, end);

        // Die maximale Teilsumme, die über die Mitte geht, berechnen
        int crossMax = maxCrossingSum(arr, start, mid, end);

        // Das Maximum der drei möglichen Teilsummen zurückgeben
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }
	
	// Kreiert von Chat GPT
    public static int maxCrossingSum(int[] arr, int start, int mid, int end) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        // Berechne die maximale Teilsumme in der linken Hälfte
        for (int i = mid; i >= start; i--) {
            sum += arr[i];
            leftSum = Math.max(leftSum, sum);
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        // Berechne die maximale Teilsumme in der rechten Hälfte
        for (int i = mid + 1; i <= end; i++) {
            sum += arr[i];
            rightSum = Math.max(rightSum, sum);
        }

        // Die maximale Teilsumme, die über die Mitte geht
        return leftSum + rightSum;
    }
	
	// Randsumme
	public static int algo4(int[] arr) {
		
		int max_sum = 0;
		int max_val = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > max_sum + arr[i]) {
				max_sum = arr[i];
			} else {
				max_sum += arr[i];
			}
			
			if(max_sum > max_val) {
				max_val = max_sum;
			}
			
		}
		
		return max_val;
		
	}
	
}
