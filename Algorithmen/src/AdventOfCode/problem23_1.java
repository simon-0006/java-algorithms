package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem23_1 {
	static final String PATH = "src/AdventOfCode/input23_1";
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(PATH);
		Scanner sc = new Scanner(file);
		
		System.out.println(solution(sc));
		
		
	}
	
	private static int solution(Scanner scanner) {
		int addition = 0;
		
		while (scanner.hasNextLine()) {
			String next = scanner.nextLine();
			String num = "";
			
			for (int i = 0; i < next.length(); i++) {
				if(Character.isDigit(next.charAt(i))) num = num + next.charAt(i);
				else num = num + strToInt(next, i);
			}
			int ten = Character.getNumericValue(num.charAt(0))*10;
			int one = Character.getNumericValue(num.charAt(num.length()-1));
			System.out.println(num + " | addition: " + addition + " += " + ten + " + " + one);
			
			addition += ten + one;
			
			
		}
		
		
		return addition;
	}
	
	private static String strToInt(String next, int idx) {
		next = next + "!!!!!!";
		// 3 digit one, two, six, ten
		switch(next.substring(idx, idx+3)) {
			case "one":
				return "1";
			case "two":
				return "2";
			case "six":
				return "6";
			case "ten":
				return "4";
			default:
				break;
		}
		
		// 4 digit four, five, nine
		switch(next.substring(idx, idx+4)) {
		case "four":
			return "4";
		case "five":
			return "5";
		case "nine":
			return "9";
		default:
			break;
	}
		
		// 5 digit three, seven, eight
		switch(next.substring(idx, idx+5)) {
		case "three":
			return "3";
		case "seven":
			return "7";
		case "eight":
			return "8";
		default:
			break;
	}
		
		return "";
	}

}
