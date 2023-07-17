import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

//Paarth Badola
//20012789


public class WRData {
	public static void main(String [] args) {
		// file object 
		File newFile = new File("src\\Java_Program.txt");
		
		try {
			// checking for file
			if (!newFile.exists()) {
				newFile.createNewFile();
				// for writing into file
				PrintStream writer = new PrintStream(newFile);
				// object for random
				Random r = new Random();
				int n = 100;
				
				for(int i = 0; i<n; i++) {
					writer.println(r.nextInt());
				}
				
				writer.close();
				
			} else {
				System.out.println("File already exists");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> listOfNum = new ArrayList<>();
		
		try {
			// scanner object to read from a file
			Scanner sc = new Scanner(newFile);
			// appending values to list from file
			while (sc.hasNext()) {
				listOfNum.add(sc.nextInt());
			}
			sc.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		// sort in ascending order
		Collections.sort(listOfNum);
		// printing list
		System.out.println(listOfNum);
		
	}
}

