package Datastructures;

import AbstractDataTypes.*;

public class SearchTree implements Dictionnary<Integer>{
	
	Node<Integer> head;
	Node<Integer>[] ref; // ind. 0 : left & ind. 1 : right
	
	public SearchTree() {
		this.head = null;
		this.ref = null;
	}
	
	public String toString() {
        return toStringHelper(this.head, "");
    }

    private String toStringHelper(Node node, String prefix) {
        if (node == null) {
            return "";
        }
        
        String leftStr = toStringHelper(node.ref[0], prefix + "L:");
        String rightStr = toStringHelper(node.ref[1], prefix + "R:");
        return prefix + node.k + "\n" + leftStr + rightStr;
    }
	
	public boolean isEmpty() {
		if(this.head == null) {return true;}
		return false;
	}

	@Override
	public void insert(Integer k) throws IllegalArgumentException {
		Node<Integer> new_node = new Node<Integer>(k);
		new_node.ref = new Node[2];
		
		if (isEmpty()) {this.head = new_node;}
		else {
			Node<Integer> parent = this.head;
			if     (parent.k == new_node.k) {throw new IllegalArgumentException("This key " + k + " already exists!");}

			Node<Integer> child;
			if(parent.k <  new_node.k) {child = parent.ref[1];}
			else                       {child = parent.ref[0];}
			
			while(child != null) {
				parent = child;
				
				if     (child.k == new_node.k) {throw new IllegalArgumentException("This key already exists!");}
				else if(child.k <  new_node.k) {child = child.ref[1];}
				else if(child.k >  new_node.k) {child = child.ref[0];}
			}
				
			new_node.ref = new Node[2];
			
			if(parent.k <  new_node.k) {parent.ref[1] = new_node;}
			if(parent.k >  new_node.k) {parent.ref[0] = new_node;}
			
			
		}
		
	}
	
	@Override
	public void delete(Integer key) throws IllegalArgumentException {
		this.head = deleteRec(key, this.head);
		if(deleteRec(key, this.head) == null) 
		{throw new IllegalArgumentException("Sorry but: Value " + key + " can't be removed, because it doesn't exist!");}
	}
	
	private Node<Integer> deleteRec(Integer key, Node<Integer> root) {
		
		// Base case 1: root = null
		if(root == null) return root;
		
		// Recursion
		if     (root.k < key) {root.ref[1] = deleteRec(key, root.ref[1]);}
		else if(root.k > key) {root.ref[0] = deleteRec(key, root.ref[0]);}
		
		// Element found
		else {
			if      (root.ref[0] == null)  return root.ref[1];
            else if (root.ref[1] == null)  return root.ref[0];

            root.k      = leastgreatestchild(root.ref[1]);
            root.ref[1] = deleteRec(root.k,  root.ref[1]);
		}
		return root;
	}
	
	
	public int leastgreatestchild(Node<Integer> node) {
		int minValue = node.k;
        while (node.ref[0] != null) {
            minValue = node.ref[0].k;
            node = node.ref[0];
        }
        return minValue;
	}

	@Override
	public boolean search(Integer key) {
		Node<Integer> parent = this.head;
		Node<Integer> child;
		
		if(parent.k == key) {return true;}
		
		else {
			if(parent.k <  key) {child = parent.ref[1];}
			else                {child = parent.ref[0];}
			
			while(child != null) {
				parent = child;
				
				if     (child.k == key) {return true;}
				else if(child.k <  key) {child = child.ref[1];}
				else if(child.k >  key) {child = child.ref[0];}
			}
		}
		
		return false;
	}
	
}
