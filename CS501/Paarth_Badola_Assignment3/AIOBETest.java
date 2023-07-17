import java.util.Random;
import java.util.Scanner;

// Paarth Badola
// 20012789

public class AIOBETest {
	public static void main(String[] args) {
		// operations
		// initializing and declaring an array of length 100 
		int[] array = new int[100];
		
		// declaring random object
		Random r = new Random();
		// filling the array with 100 random numbers
		for(int i = 0; i<array.length; i++) {
			array[i] = r.nextInt();
		}
		
		// input scanner for index
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the index: ");
		int index = sc.nextInt();
		
		try {
			System.out.println("The element at given index is: "+ array[index]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index Out of Bounds");
		}
	} 
}
