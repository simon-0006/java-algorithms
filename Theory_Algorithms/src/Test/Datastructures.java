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
			
		}
}
