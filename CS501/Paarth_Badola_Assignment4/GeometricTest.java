
public class GeometricTest{
	public static void main(String [] args) {
		/*
		 * Write a test program that creates an array of six Geometrics. For each
			Object in the array, display its area & perimeter and invoke its 
			howToColor method if it has color.
		 */
		
		Geometric[] geoArray = new Geometric[5];
		geoArray[0] = new Square();
		geoArray[1] = new Square(5.1);
		geoArray[2] = new Square(8.4, "red");
		geoArray[3] = new Square(9, "green");
		geoArray[4] = new Square(6.2, "blue");
		
		
		for(Geometric geo : geoArray) {
			System.out.println("Area: " + geo.getArea() + "\n" +"Perimeter: " + geo.getPerimeter());
			
			if(geo instanceof Colorable && geo.getColor() != null) {
				System.out.println(((Colorable) geo).howToColor() + " " + geo.getColor());
			}
			
			System.out.println("************");
		}
		
	}
}
