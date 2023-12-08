package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class problem23_8 {
	final static String PATH = "src/AdventOfCode/input23_8";
	
	
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File(PATH);
		Scanner scanner = new Scanner(file);
		System.out.println(solution(scanner));
		
		
	}
	
	public static class Node{
		String left;
		String right;
		String value;
		
		public Node(String val, String l, String r) {
			left = l;
			right = r;
			value = val;
		}
	}
	
	private static int solution(Scanner scanner) {
		String rl = scanner.nextLine();
		scanner.nextLine();
		
		HashMap<String, Node> Adj = graph(scanner);
		
		String current = "AAA";
		int count = 0;
		while (!current.equals("ZZZ")) {
			switch (rl.charAt(count % rl.length()))	{		
				case 'L': 
					current = Adj.get(current).left;
					break;
				case 'R':
					current = Adj.get(current).right;
					break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + rl.charAt(count % rl.length()));
			}
			
			count++;
		}
		
		
		return count;
	}
	
	private static HashMap<String, Node> graph(Scanner scanner) {
		HashMap<String, Node> Adj = new HashMap<>();
		
		while (scanner.hasNextLine()) {
			Scanner line = new Scanner(scanner.nextLine());
			
			String val = line.next();
			String left = line.next();
			String right = line.next();
			
			Node newNode = new Node(val, left, right);
			Adj.put(val, newNode);
		}
		
		return  Adj;
		
		
	}

}
