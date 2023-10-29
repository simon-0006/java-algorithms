package AbstractDataTypes;

public interface Queue<T>{
	public void enQueue(T item); // add an o at the end
	public T deQueue(); // delete the first o and returns
	public T front(); // return the first
	public boolean isEmpty();
	public Queue<T> emptyQueue();
}
