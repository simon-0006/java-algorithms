package Datastructures;

import AbstractDataTypes.*;

public class SearchTree<T> implements Dictionnary<T>{
	
	Node<T> head;
	Node<T>[] ref; // ind. 0 : left & ind. 1 : right
	
	public SearchTree() {
		this.head = null;
		this.ref = null;
	}

	@Override
	public void insert(T key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean search(T key) {
		
		return false;
	}
	
}
