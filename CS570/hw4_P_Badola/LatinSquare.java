// Paarth Badola
// 20012789

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Utility class to return a pair of values from a function
 * 
 */
class Pair<K, V> {
	K k;
	V v;

	Pair(K key, V val) {
		k = key;
		v = val;
	}
}

/*
 * Note: an entry of 0 at a certain location (i, j) in the underlying matrix
 * means that the location is empty
 */
public class LatinSquare {
	int dim;
	int[][] content;

	public LatinSquare(int n) {
		dim = n;
		content = new int[n][n];
	}

	
	boolean rowViolation(int e, int r, int c) {
		for (int i = 0; i < dim; i++) {
			if (content[r][i] == e) {
				return true;
			}
		}
		return false;
	}

	boolean colViolation(int e, int r, int c) {
		for (int i = 0; i < dim; i++) {
			if (content[i][c] == e) {
				return true;
			}
		}
		return false;
	}


	// Return true when placing e >= 1 in the location (r,c) causes violation either in the column or in the row
	boolean violation(int e, int r, int c) {
		return rowViolation(e, r, c) || colViolation(e, r, c);
	}

	public String toString() {
		String out = "";
		
		for(int i = 0; i < content.length; i++){
  	      for(int j =0; j < content.length; j++){
  	    	out += content[i][j];
  	        out += " ";
  	      }
  	      out += "\n";	
  		}
		
		return out;
	}

	/*
	 * Search row-wise from the given coordinates (r, c) rightward and downward for
	 * the next 0 (excluding the entry (r,c). To search the whole matrix use (r, c)
	 * = (-1, -1)
	 */
	public Pair<Integer, Integer> nextZero(int r, int c) {
		// TODO: implement
		for (int i = c; i<dim; i++) {
			if(content[r][i] == 0) {
				return new Pair<Integer, Integer>(r, i);
			}
		}
		
		for (int i = r+1; i < dim; i++) {
			for(int j = 0; j< dim ; j++) {
				if(content[i][j] == 0) {
					return new Pair<Integer, Integer>(i, j);
				}
			}
		}
		
		return null;
	}

	/*
	 * Use recursion to solve the puzzle and print the solution
	 */
	public boolean solve(LatinSquare ls1, int row, int col) {
		if(row == dim) {
			return true;
		}
		Pair <Integer, Integer> nextZ = nextZero(row, col);
		
		//base case
		if(nextZ == null) {
			return true;
		}
		if(ls1.content[nextZ.k][nextZ.v] != 0) {
			if (solve(ls1, nextZ.k, nextZ.v)) {
				return true;
			}
		}else {
			for (int val = 1; val <= dim; val++) {
				if (!violation(val, nextZ.k, nextZ.v)) {

					ls1.content[nextZ.k][nextZ.v] = val;
					if (solve(ls1, nextZ.k, nextZ.v)) {
						return true;
					} else {
						ls1.content[nextZ.k][nextZ.v] = 0;
					}
				}
			}
		}
		return false;
	}
	

	// Red the initial unfilled square from a file
	public static LatinSquare readInputFromFile(String file) throws Exception { // Throws exception when the file is not found
		File inFile = new File(file);
		
		// checking for file
		if(!inFile.exists()) {
			System.out.println("File does not exist.");
			System.exit(0);
			return null; 
		}
		
		ArrayList <Integer> list1 = new ArrayList<>();
		
		try (Scanner sc = new Scanner(inFile)) {
		    while (sc.hasNext()) {
		        int n = sc.nextInt();
		    	list1.add(n);
		    }
		}
		
		int dimVal = (int)Math.sqrt(list1.size());

		int[][] arr1 = new int[dimVal][dimVal];
	    
		for(int i = 0; i < dimVal; i++){
	      for(int j =0; j < dimVal; j++){
	        arr1[i][j]= list1.get((i*dimVal) + j);
	      }
		}
		
		
		LatinSquare ls1 =  new LatinSquare(arr1.length);
		ls1.content = new int[ls1.dim][ls1.dim];
		
		for (int i = 0; i< ls1.dim ; i++) {
			for (int j = 0; j< ls1.dim; j++) {
				ls1.content[i][j] = arr1[i][j];
			}
		}
		
		return ls1; 
}
	
	public static void main(String[] args) {
		
		//TODO: test other stuff
		try {
			
			LatinSquare ls = LatinSquare.readInputFromFile("src//input02.txt");
			System.out.println(ls.toString());
			
			if(ls.solve(ls, 0, 0)) { 
				System.out.println(ls.toString());
			}
			else {
				
				System.out.println("No solution");
			}
	
		
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
