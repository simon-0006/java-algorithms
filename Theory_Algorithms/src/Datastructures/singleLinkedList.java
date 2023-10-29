package Datastructures;

import AbstractDataTypes.Dictionnary;

public class singleLinkedList<T> implements Dictionnary<T>{
	
	Node<T> head = new Node(null); // head of a List
	
	static class Node<T>{
		T k;
		T next;
		
		public Node(T k) {
			this.k = k;
			this.next = null;
		}
		
	}

	@Override
	public void insert(T key) throws IllegalArgumentException {
		Node<T> new_node = new Node(key);
		
		if (this.head == null) {this.head = new_node;}
		
		
	}

	@Override
	public void delete(T key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean search(T key) {
		// TODO Auto-generated method stub
		return false;
	}

}
