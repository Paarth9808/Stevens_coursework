//Paarth Badola
//20012789

//m = 1 + 1 / 2 + 1 / 3 + ... + 1 /i 
public class Exercise18_01 {
	public static void main(String [] args) {
	    
		System.out.println("i    m(i)");
		System.out.println("-----------");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i+ "    " + m(i) + "\n");
		}
	    
	}
	
	private static double m(double i) {
		
		if (i == 0) {
			return 0;
		}
		
		return  (1 / i) + m(i-1);
	}
}
