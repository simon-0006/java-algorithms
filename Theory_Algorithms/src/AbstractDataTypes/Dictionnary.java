package AbstractDataTypes;

public interface Dictionnary<k> { // k: Dynamischer Type
	public void insert(k key) throws IllegalArgumentException;
	public void delete(k key) throws IllegalArgumentException;
	public void search(k key) throws IllegalArgumentException;
}
