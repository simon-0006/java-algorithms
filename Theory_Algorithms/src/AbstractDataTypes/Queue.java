package AbstractDataTypes;

public interface Queue<T>{
	public void enQueue(T item);
	public T deQueue();
	public T front();
	public boolean isEmpty();
	public Queue<T> emptyQueue();
}
