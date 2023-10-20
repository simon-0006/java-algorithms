package SortingAlgorithms;
import Datastructures.Heap;

public class Heapsort {
	public static int[] algo1(int[] arr) {
		Heap heap = new Heap(arr);
		heap.heapSort();
		
		return heap.heaparr();
	}

}
