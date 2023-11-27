package AdventOfCode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1{
	static final String path = "src/AdventOfCode/input2022_1";
	
	public static void main(String[] args) throws FileNotFoundException{
		File input = new File(path);
		Scanner sc = new Scanner(input);
		solution(sc);
		
		
	}
	
	private static int solution(Scanner sc) {
		Scanner line;
		int max = 0;
		int rel = 0;
		while(sc.hasNextLine()) {
			line = new Scanner(sc.nextLine());
			if(line.hasNextInt()) {
				rel += line.nextInt();
			} else {
				max = (max < rel) ? rel : max;
				rel = 0;
			}
		}
		System.out.println(max);
		
		return max;
	}
}
