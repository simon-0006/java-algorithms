package AbstractDataTypes;

public interface PriorityQueue<T> {
	// insert could be implemented by heaps
	
	public void insert(T item, int p); // add an o at position p
	public T extractMax(); // delete the first (with the highest priority) o and returns it
	// we assume there are no elements with same priority
	public T front(); // return the first
	public boolean isEmpty();
	public Queue<T> emptyQueue();
}
