package Datastructures;

import java.util.Arrays;

public class Heap {
	
	int[] heap;
	
	public Heap(int[] arr) {heap = arr;}
	
	public static void main(String[] args) {
		int[] test = {3,5,2,8,7,9,5,3,2,6,8,6,1,1};
		Heap binTree = new Heap(test);
		Heap binTree2 = new Heap(test);
		System.out.println(Arrays.toString(binTree.heap));
		
		
		binTree.buildMaxHeap();
		System.out.println(Arrays.toString(binTree.heap));
		System.out.println(binTree.hasMaxHeapProperty());
		
		binTree2.buildMinHeap();
		System.out.println(Arrays.toString(binTree2.heap));
		System.out.println(binTree.hasMinHeapHeapProperty());
	}
	
	public boolean hasMaxHeapProperty() {
		int child, child2, parent;
		
		for(int i = 0; i < (heap.length/2); i++) {
			parent = heap[i];
			child = heap[2*i + 1];
			if(heap.length > 2*i + 2 && (parent < child || parent < heap[2*i + 2])) {return false;}
		}
		return true;
	}
	
	public boolean hasMinHeapHeapProperty() {
		int child, child2, parent;
				
		for(int i = 0; i < (heap.length/2); i++) {
			parent = heap[i];
			child = heap[2*i + 1];
			if(heap.length > 2*i + 2 && (parent > child || parent > heap[2*i + 2])) {return false;}
		}
		return true;
	}
	
	public void minHeapify(int idx) {
		int parent = heap[idx], child = 0, child2 = 0, index = idx, tmp;
		int[] children = {0 , 0};
		
		if(heap.length-1 >= idx * 2 + 1) {child  = heap[idx * 2 + 1]; children[0] = 1;}
		if(heap.length-1 >= idx * 2 + 2) {child2 = heap[idx * 2 + 2]; children[1] = 1;}
		
		if(children[1] == 1) { 
			index = (child2 > child) ? (parent > child) ? idx * 2 + 1 : idx : (parent > child2) ? idx * 2 + 2 : idx;
		}
		else if (children[0] == 1) {
			index = (parent > child) ? idx * 2 + 1 : idx;
		}
		
		tmp = heap[index];
		heap[index] = heap[idx];
		heap[idx] = tmp;
		
		
		if(idx != index) {minHeapify(index);}
		
	}
	
	public void maxHeapify(int idx) {
		
		int parent = heap[idx], child = 0, child2 = 0, index = idx, tmp;
		int[] children = {0 , 0};
		
		if(heap.length-1 >= idx * 2 + 1) {child = heap[idx * 2 + 1]; children[0] = 1;}
		if(heap.length-1 >= idx * 2 + 2) {child2 = heap[idx * 2 + 2]; children[1] = 1;}
		
		if(children[1] == 1) { 
			index = (child2 < child) ? (parent < child) ? idx * 2 + 1 : idx : (parent < child2) ? idx * 2 + 2 : idx;
		}
		else if (children[0] == 1) {
			index = (parent < child) ? idx * 2 + 1 : idx;
		}
		
		tmp = heap[index];
		heap[index] = heap[idx];
		heap[idx] = tmp;
		
		
		if(idx != index) {maxHeapify(index);}
		
	}

	public void buildMaxHeap() {
		for(int i = heap.length/2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	public void buildMinHeap() {
		for(int i = heap.length/2; i >= 0; i--) {
			minHeapify(i);
		}
	}
	
}
