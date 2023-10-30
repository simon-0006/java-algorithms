package Test;

import Datastructures.*;

public class Datastructures {

		public static void main(String[] args) {
			DataStack<Integer> ml = new DataStack<>();
			ml.push(3);
			ml.push(6);
			ml.push(8);
			
			ml.top();
			ml.pop();
			ml.isEmpty();
			ml.emptyStack();
			
			singleLinkedList<Integer> sll = new singleLinkedList<>();
			System.out.println(sll.toString());
			
			sll.insert(78);
			sll.insert(5);
			sll.insert(90);
			sll.insert(11);
			
			System.out.println(sll.toString());
			
			DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
			System.out.println(dll.toString());
			
			dll.push(89);
			dll.push(12);
			
			System.out.println(dll.toString());
			
			int tmp = dll.pop();
			System.out.println(tmp);
			
			tmp = dll.pop();
			System.out.println(tmp);
			
			
			System.out.println(dll.toString());
			
			System.out.println("Top element: " + dll.top());
			
			System.out.println("Stack is empty: " + dll.isEmpty());
//			dll.emptyStack();
//			
//			System.out.println("Stack is empty: " + dll.isEmpty());
			
			dll.enQueue(33);
			dll.enQueue(21);
			
			System.out.println(dll.toString());
			
			dll.multiPop(5);
			System.out.println(dll.toString() + "\n");
			
			SearchTree mB = new SearchTree();
			mB.insert(25);
			mB.insert(12);
			mB.insert(50);
			mB.insert(11);
			mB.insert(8);
			mB.insert(2);
			mB.insert(1);
			mB.insert(27);
			
			System.out.println(mB.toString());
			
			System.out.println(mB.search(25));
			System.out.println(mB.search(1));
			System.out.println(mB.search(27));
			System.out.println(mB.search(28));
			
			
			
		}
}
