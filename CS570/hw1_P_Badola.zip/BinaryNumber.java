
public class BinaryNumber {
	// initializing binary array
	private int data[];
	// initializing to check overflow value
	private boolean overflow;
	
	// constructor for creating binary number
	public BinaryNumber(int length) {
		if (length > 0)
			// by default 0 value 
			data = new int[length];
		else
			System.out.println("Error. Enter valid length");
	}
	
	// constructor for creating binary number given a string
	public BinaryNumber(String str) {
		
		// length of string = length of binary number
		int l = str.length();
		data = new int[l];
		// traversing through the string and passing value to array
		for (int i = 0; i< l; i++) {
			// char	value at index i
			char c = str.charAt(i);
			// Converts the numeric Unicode character to a double-precision floating point number
			data[i] = Character.getNumericValue(c);
		}		
	}
	
	// determine length of binary number
	public int getLength() {
		return data.length;
	}
	
	// return digit at given index
	public int getDigit(int index) {
		if (index > data.length || index < 0) {
			System.out.println("Error. Index out of bounds.");
			System.exit(0);
			return 0;
		}
		else
			return data[index];
	}
	
	// convert from binary to decimal
	public int toDecimal() {
		
		int d = 0;
		for (int i = 0; i<data.length; i++)
			// convert to int after calculating the decimal value
			d += (int) (data[i] * Math.pow(2, i));
		
		return d;
	}
	
	// shifting	all	digits in binary number by amount places to the right	
	public void shiftR(int amount) {
		if (amount < 0)
			System.out.println("Error. Positive value needed");
		
		BinaryNumber reallocate = new BinaryNumber(data.length + amount);
		for (int i = amount; i<reallocate.getLength(); i++)
			reallocate.data[i] = data[i-amount];
		
		// assigning value to data from reallocate 
		this.data = reallocate.data;
		System.out.println("Number after shift right is: " + this.toString());
	}
	
	// shifting	all	digits in binary number by amount places to the left
	public void shiftL(int amount) {
		if (amount < 0)
			System.out.println("Error. Positive value needed");
		
		BinaryNumber reallocate = new BinaryNumber(data.length + amount);
		for (int i = 0; i< data.length; i++)
			reallocate.data[i] = data[i];
		
		this.data = reallocate.data;
		System.out.println("Number after shift left is: " + this.toString());
	}
	
	// addition of binary numbers
	public void add(BinaryNumber aBinaryNumber) {
		if (aBinaryNumber.getLength() != data.length)
			System.out.println("Error. Both binary numbers should be same length.");
		else {
			System.out.println("Addition of " + toString() + " and " + aBinaryNumber + "= " );
			
			int carry = 0;
			int sum[] = new int[data.length];
			for (int i = 0; i < data.length; i++) {
				int s = carry + data[i] + aBinaryNumber.getDigit(i);
				if (s == 0) {
					sum[i] = 0;
					carry = 0;
				}
				if (s == 1) {
					sum[i] = 1;
					carry = 0;
				}
				if (s == 2) {
					sum[i] = 0;
					carry = 1;
				}
				if (s == 3) {
					sum[i] = 1;
					carry = 1;
				}
			}
			data = sum;
			if (carry == 1) {
				overflow = true;
			}
			System.out.println(toString());
		}	
	}
	
	// clearing overflow value
	public void clearOverflow() {
		overflow = false;
	}
	
	// transforming	a	binary	number	to	a	String
	public String toString() {
		if(overflow == true)
			return "Overflow";
		else {
			String str = "";
			for (int i = 0; i < data.length; i++)
				str += data[i];
			return str;
		}
	}
	
	public static void main(String[] args) {
		BinaryNumber num1 = new BinaryNumber("10110");
		BinaryNumber num2 = new BinaryNumber("11100");
		BinaryNumber num3 = new BinaryNumber("11101");

		System.out.println(num1 + " length is = " + num1.getLength());
		System.out.println("Digit at given index is = " + num3.getDigit(3));
		System.out.println(num3 + " decimal value is = " + num3.toDecimal());
		// num1.add(num2);
		num1.clearOverflow();
		num1.add(num2);
		System.out.println(num3.toString());
		System.out.println(num1.getLength());
		
		num1.clearOverflow();
		System.out.println(num1.toDecimal());
		num1.shiftR(3);
		num2.shiftL(3);
		
		
	}
	

}
