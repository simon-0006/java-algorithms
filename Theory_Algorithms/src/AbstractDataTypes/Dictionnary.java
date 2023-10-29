package AbstractDataTypes;

public interface Dictionnary<k> { // k: Dynamischer Type
	public void insert(k key) throws IllegalArgumentException;
	// if k is already in Dic. returns Exception
	
	public void delete(k key) throws IllegalArgumentException;
	// if k isn't in Dic. return Exception
	
	public boolean search(k key);
	// returns true if key is in D - false when not
}
