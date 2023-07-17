// Paarth Badola
// 20012789

public class Circle2D {
	// initializing data fields
		// center of circle
		double x;
		double y;
		double radius;
		// double pi = 3.14;

		// getter functions
		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getRadius() {
			return radius;
		}

		// constructor for default circle
		public Circle2D() {
			x = 0;
			y = 0;
			radius = 1;
			System.out.println("Default circle is created.");
		}

		// constructor for creating circle with given arguments
		public Circle2D(double x1, double y1, double radius1) {
			if (radius1 <= 0)
				throw new ArithmeticException("Invalid radius");
			x = x1;
			y = y1;
			radius = radius1;
			System.out.println("Circle with provided values is created.");
		}

		// method for calculating and returning area
		public double getArea() {
			double area = Math.PI * (Math.pow(radius, 2));
			System.out.println("The area of the circle is: ");
			return area;
		}

		// method for calculating and returning perimeter
		public double getPerimeter() {
			double perimeter = 2 * Math.PI * radius;
			System.out.println("The perimeter of the circle is: ");
			return perimeter;
		}

		// method for checking if given points lie inside the circle
		public boolean contains(double x1, double y1) {
			// contains point if distance from center to point is < radius
			return ((Math.hypot(x - x1, y - y1)) < radius);
		}

		// method for checking if given circle lies inside the circle
		public boolean contains(Circle2D circle) {
			// circle contains if distance between centers of circle is <= radius
			return ((Math.hypot(x - circle.x, y - circle.y)) + circle.radius < radius);
		}

		// method for checking if given circle overlaps the circle
		public boolean overlaps(Circle2D circle) {
			//  circles overlap if the distance from the center of both circles is <= to the sum of radius
			return ((Math.hypot(x - circle.x, y - circle.y)) <= radius + circle.radius);
		}

		public static void main(String[] args) {

			Circle2D c1 = new Circle2D(1,1,6.9);
			//Circle2D c2 = new Circle2D(-6,-6,0);
			Circle2D c2 = new Circle2D(-6, -6, 1);
			System.out.println("***********");
			System.out.println(c2.getRadius());
			System.out.println(c1.getArea());
			System.out.println("***********");
			System.out.println(c1.getPerimeter());
			System.out.println("***********");
			System.out.println(c1.contains(2, 1)); 
			System.out.println("***********");
			System.out.println(c1.contains(new Circle2D(3,6,7)));
			System.out.println("***********");
			System.out.println(c1.overlaps(new Circle2D(1,1,5)));

		}
}
