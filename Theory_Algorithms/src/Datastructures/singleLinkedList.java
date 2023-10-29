package Datastructures;

import AbstractDataTypes.Dictionnary;

public class singleLinkedList<T> implements Dictionnary<T>{
	
	Node<T> head; // head of a List
	
	public singleLinkedList() {
		this.head = null;
	}
	
	public String toString() {
		Node<T> tmp = head;
		String stmp = "";
		while(tmp != null) {
			stmp = stmp.concat("" + tmp.k + " -> ");
			try {tmp = tmp.ref[0];}
			catch (Exception e) {break;}
		}
		stmp = stmp.concat("null");
		return stmp;
	}
	
	@Override
	public void insert(T key) throws IllegalArgumentException {
		Node<T> new_node = new Node<T>(key);
		
		if (this.head == null) {this.head = new_node;}
		else {
			Node<T> tmp = head;
			while(tmp.ref != null) {
				tmp = tmp.ref[0];
			}
			tmp.ref = new Node[]{new_node};
		}
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
