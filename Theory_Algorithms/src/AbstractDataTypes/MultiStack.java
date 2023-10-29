package AbstractDataTypes;

public interface MultiStack<T> {
	// normal Stack:
	public void push(T item);
	public T pop();
	public T top();
	public boolean isEmpty();
	public Stack<T> emptyStack();
	
	// in addition:
	public T multiPop(int k); // returns the last k elements of the Stack which were added recently
	// returns null if stack was empty before the call multiPop

}
