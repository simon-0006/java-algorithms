package Datastructures;

import AbstractDataTypes.*;

public class DoublyLinkedList<T> implements MultiStack<T>, PriorityQueue<T>, Queue<T>, Stack<T>, Dictionnary<T> {
	// Stack
	Node<T> head;
	Node<T> tail;
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public String toString() {
		Node<T> tmp = head;
		String stmp = "";
		while(tmp != null) {
			stmp = stmp.concat("" + tmp.k + " <-> ");
			try {tmp = tmp.ref[0];}
			catch (Exception e) {break;}
		}
		stmp = stmp.concat("null");
		return stmp;
	}
	
	@Override
	public boolean isEmpty() {
		if(this.head == null) {return true;}
		return false;
	}
	
//	Stack ----------------------------------------------------------------------------------------------------------
	@Override
	public void push(T item) {
		Node<T> new_node = new Node<T>(item);
		
		if (isEmpty()) {
			this.head = new_node; 
			this.tail = new_node;
			this.tail.ref = new Node[2];}
		else {
			new_node.ref = new Node[2];
			new_node.ref[0] = this.head;
			new_node.ref[1] = this.head.ref[1];
			head.ref[1] = new_node;
			
			this.head = new_node;
		}
	}

	@Override
	public T pop() { // delete first Element
		if (this.head == null) {return null;}
		else {
			T tmp = head.k;
			if(this.head.ref[0] == null) {
				this.head = null;
			}
			else {
				this.head.ref[0].ref[1] = this.head.ref[1];
				this.head = head.ref[0];
			}
			return tmp;
		}
	}

	@Override
	public T top() { // return first element
		if (isEmpty()) {return null;}
		else {return this.head.k;}
	}

	@Override
	public Stack<T> emptyStack() { // delete Stack
		this.head = null;
		return null;
	}

//	Queue ----------------------------------------------------------------------------------------------------------
	@Override
	public void enQueue(T item) {
		Node<T> new_node = new Node<T>(item);
		
		if (isEmpty()) {
			this.head = new_node; 
			this.tail = new_node;
			this.tail.ref = new Node[2];
			this.head.ref[1] = this.tail;}
		else {
			new_node.ref = new Node[2];
			
			new_node.ref[1] = this.head.ref[1];
			this.head.ref[1] = new_node;
			new_node.ref[1].ref[0] = new_node;
		}
		
	}

	@Override
	public T deQueue() {
		return pop();
	}

	@Override
	public T front() {
		return top();
	}


	@Override
	public Queue<T> emptyQueue() {
		this.head = null;
		return null;
	}

//	TODO Priority Queue ----------------------------------------------------------------------------------------------------------

	@Override
	public T extractMax() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(T item, int p) {
		// TODO Auto-generated method stub
		
	}
	
//	Multistack ----------------------------------------------------------------------------------------------------------
	
	@Override
	public T multiPop(int k) {
		if (isEmpty()) {return null;}
		else {
			for(int i = 1; i <= k; i++) {
				if (isEmpty()) {break;}
				pop();
			}
		}
		return null;
	}
	// TODO return all the elements: maybe in a list?

	//	maybe Dictionnary makes not much sense to combine stack with dictionnary ----------------------------------------------------------------------------------------------------------
	@Override
	public void insert(T key) throws IllegalArgumentException {
		
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
