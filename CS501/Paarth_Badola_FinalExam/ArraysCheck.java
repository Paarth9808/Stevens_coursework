//Paarth Badola
//20012789

import java.util.Arrays;

public class ArraysCheck {
	
	public static boolean check(int []a, int []b){
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == b[i] || a[i] + 1 == b[i] ) {
				continue;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		int []A = {};
		int []B = {};
		// 0,0,3,4,4
		//1,2,3,4,5
		ArraysCheck a = new ArraysCheck();
		System.out.println(a.check(A, B));
	}
}
