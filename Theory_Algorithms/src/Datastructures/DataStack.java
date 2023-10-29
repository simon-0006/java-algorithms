package Datastructures;
import java.util.ArrayList;

import AbstractDataTypes.*;

public class DataStack<T> implements Stack<T>{
	private ArrayList<T> stack = new ArrayList<>();

	@Override
	public void push(T item) {stack.add(item);} // Push Item on top of the Stack

	@Override
	public T pop() { // Delete and return last item
		T tmp = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		
		return tmp;
	}

	@Override
	public T top() {
		// returns last item
		return stack.get(stack.size()-1);
	}

	@Override
	public boolean isEmpty() {return stack.isEmpty();} // returns if empty

	@Override
	public Stack<T> emptyStack() {stack.clear(); return this;}
}
