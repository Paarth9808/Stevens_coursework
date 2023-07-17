// Paarth Badola
// 20012789

public class MyRectangle2D {
	// initializing data fields
		// centre of rectangle
		double x;
		double y;

		double width;
		double height;

		// getter functions
		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getWidth() {
			return width;
		}

		public double getHeight() {
			return height;
		}

		// setter functions
		public void setX(double newX) {
			x = newX;
			System.out.println("x value updated");
		}

		public void setY(double newY) {
			y = newY;
			System.out.println("y value updated");
		}

		public void setWidth(double w) {
			if (w < 0)
				throw new ArithmeticException("Invalid width");
			width = w;
			System.out.println("width value updated");
		}

		public void setHeight(double h) {
			if (h < 0)
				throw new ArithmeticException("Invalid height");
			height = h;
			System.out.println("height value updated");
		}

		// constructor for default rectangle
		public MyRectangle2D() {
			x = 0;
			y = 0;
			width = 1;
			height = 1;
			System.out.println("Default rectangle is created.");
		}

		// constructor for creating rectangle with given arguments
		public MyRectangle2D(double x, double y, double width, double height) {
			this.x = x;
			this.y = y;
			if (width <= 0 || height <= 0)
				throw new ArithmeticException("Invalid width or height");

			this.width = width;
			this.height = height;
			System.out.println("Rectangle with provided values is created.");
		}

		// method for calculating and returning area
		public double getArea() {
			double area = height * width;
			System.out.println("The area of the rectangle is: ");
			return area;
		}

		// method for calculating and returning perimeter
		public double getPerimeter() {
			double perimeter = 2 * (height + width);
			System.out.println("The perimeter of the rectangle is: ");
			return perimeter;
		}

		// method for checking if given points lie inside the rectangle
		public boolean contains(double x, double y) {
			// since being a parallel to the axis we find the limits of the rectangle and then check the argument points for them  
			return x <= this.x + width/2 && x >= this.x-width/2 && y <= this.y + height/2 && y >= this.y-height/2 ;
		}

		// method for checking if given rectangle lies inside the other rectangle
		public boolean contains(MyRectangle2D r) {
			// checking and comparing x limit and y limit of both rectangles
			return r.x + r.width/2 <= x + width/2 && r.x - r.width/2 >= x - width/2 && r.y + r.height/2 <= y + height/2 && r.y - r.height/2 >= y - height/2;
		}

		// method for checking if given rectangle overlaps the other rectangle
		public boolean overlaps(MyRectangle2D r) {
			// comparing limit for both x and y limit of rectangles, any of the following satisfy, the rectangles don't intersect/overlap  
			if (x + width/2 < r.x - r.width/2 || x - width/2 > r.x + r.width/2 || y + height/2 < r.y - r.height/2 || y - height/2 > r.y + r.height/2) {
				return false;
				}
			else
				return true;
		}

		public static void main(String[] args) {
			MyRectangle2D r1=new MyRectangle2D(2,4,7,3);
			
	        System.out.println(r1.getArea());
	    	System.out.println("***********");
	        System.out.println(r1.getPerimeter());
	    	System.out.println("***********");
	        System.out.println(r1.contains(3.2,3.2));
	    	System.out.println("***********");
	        System.out.println(r1.contains(new MyRectangle2D(4,5,7,3)));
	    	System.out.println("***********");
	    	//System.out.println(new MyRectangle2D(-1,-1,-9,2));
	    	System.out.println("***********");
	        System.out.println(r1.overlaps(new MyRectangle2D(1,6,3,4)));
				
			
		}
			
}

