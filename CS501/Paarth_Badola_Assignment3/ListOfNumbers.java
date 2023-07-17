//Paarth Badola
//20012789

import java.io.*;
import java.util.*;

public class ListOfNumbers {
	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers() {
		list = new ArrayList<Integer>(SIZE);
		
        for (int i = 0; i < SIZE; i++)
            list.add(Integer.valueOf(i));
	}

	public void writeList() {
		PrintWriter out = null;
		try {
			System.out.println("Entering try statement");
			out = new PrintWriter(new FileWriter("src//outFile.txt"));
			
			for (int i = 0; i < SIZE; i++)
				out.println("Value at: " + i + " = " + list.get(i));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
		
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		
		} finally {
			if (out != null) {
				System.out.println("Closing PrintWriter");
				out.close();
			} else {
				System.out.println("PrintWriter not open");
			}
		}
	}
	
	public void readList(String ourFile) {
		try {
			
			// scanner object
			Scanner sc = new Scanner(new File(ourFile));	
			
			// while file has int item
			while(sc.hasNextInt()) {
				// passing int value 
				int value = sc.nextInt();
				// printing in list
				
				// appending values to list
				list.add(value);
			}
			// printing the read values from the file
			System.out.println(list);
		
		} catch (FileNotFoundException e) {
			System.err.println("No file found");
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		ListOfNumbers l = new ListOfNumbers(); 
		l.writeList();
		l.readList("src//outFile.txt");
	}
}