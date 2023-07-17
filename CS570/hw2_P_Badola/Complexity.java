// Paarth Badola
// 20012789

public class Complexity {
	
	// function has the time complexity Θ(n)
	public static void method0(int n){
		int counter=1;
		for (int i=0; i<n; i++) { 
		 System.out.println("Operation 0: "+counter);
		 counter++;
		 } 
	} 
	
	// a method that has time complexity Θ (n^2)
	public static void method1(int n) {
		int counter=1;
		// complexity achieved by looping twice simultaneously so the loop will be executed n*n times (2d Matrix)
		for (int i=0; i<n; i++) { 
			for (int j=0; j<n; j++) {
				System.out.println("Operation 1: "+counter);
				 counter++;
			}
		 }
	} 
	
	// a method that has time complexity Θ (n^3).
	public static void method2(int n) {
		int counter=1;
		// complexity achieved by looping thrice simultaneously so the loop will be executed n*n*n times
		for (int i=0; i<n; i++) { 
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					System.out.println("Operation 2: "+counter);
					counter++;
			    }
		    }
	    }
	}
	
	// a method that has time complexity Θ (logn).
	public static void method3(int n) {
		int counter=1;
		// complexity achieved by step value of 2^x <= n, so it will be executed x times
		for (int i=1; i<=n; i*=2) { 
			System.out.println("Operation 3: "+counter);
			counter++;
		 }		
	}
	
	//a method that has time complexity Θ (nlogn).
	public static void method4(int n) {
		int counter=1;
		// complexity achieved by looping method3 n times
		for (int i=0; i<n; i++) { 
			for (int j=1; j<=n; j *= 2) {
				System.out.println("Operation 4: "+counter);
				counter++;
			}
		 }
		
	}
	
	//a method that has time complexity Θ (loglogn). 
	public static void method5(int n) {
		int counter=1;
		// complexity achieved by squaring at each step
		for (int i=2; i<=n; i*=i) { 
			System.out.println("Operation 5: "+counter);
			counter++;
		 }	
	}

	//a method that has time complexity Θ(2^n).
	// using recursion for fibonacci series
	public static int method6(int n) {
		if (n<2)
			return n;
		return method6(n-1)+method6(n-2);
	}
	
	public static void main(String [] args) {
		Complexity.method0(4);
		System.out.println("***************");
		Complexity.method1(3);
		System.out.println("***************");
		Complexity.method2(2);
		System.out.println("***************");
		Complexity.method3(31);
		System.out.println("***************");
		Complexity.method4(4);
		System.out.println("***************");
		Complexity.method5(16);
		System.out.println("***************");
		int n = 8;
		for (int i=0; i<n; i++) {
			  
            System.out.print(Complexity.method6(i) + " ");
        }
		
	}
}
