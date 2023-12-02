package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem23_2 {
	final static String PATH = "src/AdventOfCode/input23_2";
	
	protected class Kugel {
		int red;
		int blue;
		int green;
		
		public void setRed(int red) {
			this.red = red;
		}

		public void setBlue(int blue) {
			this.blue =  blue;
		}

		public void setGreen(int green) {
			this.green = green;
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		File file = new File(PATH);
		Scanner scanner = new Scanner(file);
		System.out.println(solution(scanner));
		
		
	}
	
	private static int solution(Scanner fs) {
		int sum = 0;
		int gameID = 0;
		
		while (fs.hasNextLine()) {
			Scanner line = new Scanner(fs.nextLine());
			line.next();
			
			// Get game ID
			String temp = line.next();
			gameID = Integer.valueOf(temp.substring(0, temp.length()-1));
			
			// Get different sets
			boolean gameGood = true;
			int number = 0;
			problem23_2.Kugel set = new problem23_2().new Kugel();
			while (line.hasNext()) {
				if (line.hasNextInt()) number = line.nextInt();
				else {
					String kugel = line.next();
					// in set
					if (kugel.endsWith(",")) {
						update(kugel.substring(0, kugel.length()-1), number, set);
						
					} else if (kugel.endsWith(";")) {
						update(kugel.substring(0, kugel.length()-1), number, set);
//						gameGood = check(set);
						
//						if (!gameGood) break;
//						set = new problem23_2().new Kugel();
					} else {
						update(kugel, number, set);
//						gameGood = check(set);
					}
				}
			}
			
//			if (gameGood) sum += gameID;
			sum += (set.red * set.blue * set.green);
		}
		
		return sum;
	}
	
	private static void update(String kugel, int number, Kugel set) {
		switch (kugel) {
		case "red": 
//			set.setRed(number);
			if (set.red   < number) set.setRed(number);
			break;
		case "green": 
//			set.setGreen(number);
			if (set.green < number) set.setGreen(number);
			break;
		case "blue": 
//			set.setBlue(number);
			if (set.blue  < number) set.setBlue(number);
			break;
		}
	}
	private static boolean check(Kugel set) {
		if (set.red > 12) return false;
		if (set.blue > 14) return false;
		if (set.green > 13) return false;
		return true;
	}
}

