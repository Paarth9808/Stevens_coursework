//Paarth Badola
//20012789

import java.util.Arrays;  

public class Assignment_1 {
	public static double[] quadraticEquation(double a, double b, double c) {
//		complete this method
		
		// calculating for b^2-4ac
		double inside = Math.pow(b, 2) - (4*a*c);
		// calculating both the roots
		double root1 = (-b + Math.sqrt(inside))/(2*a); 
		double root2 = (-b - Math.sqrt(inside))/(2*a); 
		// rounding the values to 3 decimal places
		root1 = Math.round(root1 * Math.pow(10, 3))/Math.pow(10, 3);
		root2 = Math.round(root2 * Math.pow(10, 3))/Math.pow(10, 3);
		// initializing array
		double[] answer = new double[2];
		// putting value into array
		answer[0] = root1;
		answer[1] = root2;
        
        return answer;
	}
	
	
	public static double euclidianDistance(double x1, double y1, double x2, double y2) {
//		complete this method

		// calculating distance by the formula
		double dist = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		// rounding off the answer to 3 decimal places
		dist = Math.round(dist * Math.pow(10, 3))/Math.pow(10, 3);
		
		return dist;
	}
	
	public static double[] arrayOperations(double[] a) {
//		complete this method
		
		//initializing values for minimum, maximum and sum of array 
		double min = a[0];
		double max = a[0];
		double sum = 0;
		// initializing answer array that we will return 
		double [] answer = new double[4]; 
		
		// finding max and min value while traversing through the array
		// also calculating sum of all the values in the array
		for(int i = 0; i<a.length; i++) {
			if (min < a[i])
				min = a[i];
			if (max > a[i])
				max = a[i];
			else
				sum += a[i];
		}
		// initializing and calculating average
		double avg = sum/a.length;
		// input all calculated values into the answer array 
		answer[0] = max;
		answer[1] = min;
		answer[2] = avg;
		answer[3] = sum;
		
		return answer;
	}
	
	public static String strReverse(String a) {
//		complete this method
		
		// convert string to sequence of characters 
		char ch[]= a.toCharArray(); 
		String rev="";
		// looping through the characters in reverse order and adding to rev string
	    for(int i=ch.length-1;i>=0;i--) 
	        rev += ch[i];   
	    
	    return rev;  
	}
	
	public static boolean checkPalindrome(String a) {
//		complete this method
		
		// convert string to sequence of characters
		char ch[]= a.toCharArray();  
	    String rev="";  
	    // looping through the characters in reverse order and adding to rev string
	    for(int i=ch.length-1; i>=0; i--){  
	        rev +=ch [i];  
	    }  
	    // checking if the returned string is equal to the initial string
		 
	    return (rev.toString()).equals(a);
	}
	
	public static int[] strCounter(String a) {
//		complete this method
		
		// Declare and create an array of length 26 for 26 alphabets
        int[] count = new int[26];
     // convert string to sequence of characters
        char ch[]= a.toCharArray();
        // For each lower case letter in the array we will count it and add to array counts
        // here we minus the ASCII value of a = 97 from the ch[i] ASCII value and add it to the array count
        
        for (int i = 0; i < ch.length; i++)
        	count[ch[i] - 'a'] += 1;
        
        return count;
	}
	
	public static int[][] transpose(int[][] a) {
//		complete this method
		
		// initializing rows and columns and a transpose matrix  
		int rows = a.length;
		int cols = a[0].length;
        int transofA[][] = new int[rows][cols];
		
        // looping through the 2d matrix and assigning values to transpose matrix
	    for ( int r = 0; r < rows; r++ ){
	        for ( int c = 0 ; c < cols ; c++)               
	            transofA[c][r] = a[r][c];         
	      }
	    
	    return transofA;
	}
	
	public static int[][] matMul(int[][] a, int[][] b) {
//		complete this method
		
		// initializing the rows and columns and product matrix
		int a_rows=a.length;
	    int a_columns=a[0].length;
	    int b_rows=b.length;
	    int b_columns=b[0].length;
	    int[][] productab = new int[a_rows][b_columns];
	    
	    //checking if the input matrices have the dimensions M x N and N x K, so that the output array dimension will be M x K 
	    if ((a_columns != b_rows)) {
	      System.out.println("Wrong. Number of columns of matrix a is not equal to number of rows of matrix b.");
	    } else {
	    // calculating the value for productab matrix by traversing through the matrices and adding them
	      for (int i = 0; i < a_rows; i++) {
	         for (int j = 0; j < b_columns; j++) {
	           for(int k=0;k < a_columns;k++){
	             productab[i][j]+=a[i][k]*b[k][j];
	           }
	        }
	      }
	    }
	    return productab;
	}

	public static void main(String[] args) {
//		All the sample test cases are given below
		double[] ans1 = quadraticEquation(5, 6, 1);
		double[] ans1Real = {-0.2, -1};
		assert Arrays.equals(ans1, ans1Real) == true : "Wrong Answer. Please check your implementation for quadraticEquation.";
		for (int i=0; i < ans1.length; i++)
			System.out.println("root " + (i+1) + " is: " + ans1[i]);
		
		double ans2 = euclidianDistance(1, 1, 0, 0);
		double ans2Real = 1.414;
		assert Double.compare(ans2, ans2Real) == 0 : "Wrong Answer. Please check your implementation for euclidianDistance.";
		System.out.println("Distance is: " + ans2);
		
		double[] q3 = new double[]{1, 2, 3, 4};
		double[] ans3 = arrayOperations(q3);
		double[] ans3Real = {1, 4, 2.5, 10};
		assert Arrays.equals(ans3, ans3Real) == true : "Wrong Answer. Please check your implementation for arrayOperations.";
		for (int i=0; i < ans3.length; i++)
			System.out.println("values are: " + ans3[i]);
		
		String q4 = "Suhas";
		String ans4 = strReverse(q4);
		String ans4Real = "sahuS";
		assert ans4.equals(ans4Real) == true : "Wrong Answer. Please check your implementation for strReverse.";
		System.out.println("Reversed string is: " + ans4);
		
		String q5 = "HiH";
		boolean ans5 = checkPalindrome(q5);
		boolean ans5Real = true;
		assert ans5 == ans5Real : "Wrong Answer. Please check your implementation for checkPalindrome.";
		System.out.println(ans5);
		
		String q6 = "suhasisthebestintheworld";
		int[] ans6 = strCounter(q6);
		int[] ans6Real = {1, 1, 0, 1, 3, 0, 0, 3, 2, 0, 0, 1, 0, 1, 1, 0, 0, 1, 4, 3, 1, 0, 1, 0, 0, 0};
		assert Arrays.equals(ans6, ans6Real) == true : "Wrong Answer. Please check your implementation for strCounter.";
		for (int i=0; i < ans6.length; i++) 
			System.out.println(ans6[i]);
		
		int[][] q7 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] ans7 = transpose(q7);
		int[][] ans7Real = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
		assert Arrays.deepEquals(ans7, ans7Real) == true : "Wrong Answer. Please check your implementation for transpose.";
		for (int i=0; i < ans7.length; i++) {
			for (int j=0; j < ans7[0].length; j++) {
				System.out.println(ans7[i][j] + " ");
			}
			System.out.print("\n");
		}
		
		int[][] q8p1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] q8p2 = {{7, 8}, {9, 10}, {11, 12}};
		int[][] ans8 = matMul(q8p1, q8p2);
		int[][] ans8Real = {{58, 64}, {139, 154}};
		assert Arrays.deepEquals(ans8, ans8Real) == true : "Wrong Answer. Please check your implementation for matMul.";
		for (int i=0; i < ans8.length; i++) {
			for (int j=0; j < ans8[0].length; j++) {
				System.out.println(ans8[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
