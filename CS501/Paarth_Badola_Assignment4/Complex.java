// Paarth Badola
// 20012789

public class Complex implements Cloneable, Comparable<Object>{
	private double real = 0;
	private double imaginary = 0;
	
	Complex(){
	}
	
	Complex (double real){
		this.real = real;
	}
	
	Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}
	
	double getRealPart() {
		return real;
	}
	
	double getImaginaryPart() {
		return imaginary;
	}
	
	public Complex add(Complex c) {
		double real1 = real + c.real;
		double imaginary1 = imaginary + c.imaginary;
		return new Complex(real1, imaginary1);
	}
	
	public Complex subtract(Complex c) {
		double real1 = real - c.real;
		double imaginary1 = imaginary - c.imaginary;
		return new Complex(real1, imaginary1);	
		}
	
	public Complex multiply(Complex c) {
		double real1 = (real*c.real) - (imaginary*c.imaginary);
		double imaginary1 = (imaginary*c.real) + (real*c.imaginary);
		return new Complex(real1, imaginary1);
	}
	
	public Complex divide(Complex c) {
		double real1 = ((real*c.real) + (imaginary*c.imaginary)) / ((c.real*c.real) + (c.imaginary*c.imaginary));
		double imaginary1 = ((imaginary*c.real) - (real*c.imaginary)) / ((c.real*c.real) + (c.imaginary*c.imaginary));
		return new Complex(real1, imaginary1);
	}
	
	public double abs() {
		double absolute = Math.hypot(real, imaginary);
		return absolute;
	}
	
	public static double abs(Complex c11) {
		double abs1 = Math.hypot(c11.getRealPart(), c11.getImaginaryPart());
		return abs1;
	}
	
	public String toString() {
		if (imaginary == 0) {
			return "(" + real + ")";
		}
		
		return "(" + real + " + " + imaginary + "i" + ")";
	}
	
	// return a new object by given the attributes of the object passed
	public Complex clone() {
		
		double a = getRealPart();
		double b = getImaginaryPart();
		
		return new Complex(a,b);
	}
						
	public int compareTo(Object c) {
		if (this.abs() == abs((Complex)c)) {
			return 0;
		}
		
		return (int)(this.abs() - abs((Complex)c)); 
	}
	
}
