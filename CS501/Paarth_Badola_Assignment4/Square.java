// Paarth Badola
// 20012789

public class Square extends Geometric implements Colorable{
	private double side;
	
	Square(){
		this.side = 0;
	}
	
	Square(double side){
		this.side = side;
	}
	
	Square(double side, String color){
		this.side = side;
		setColor(color);
	}
	
	@Override
	public String howToColor() {
		return "Color all four sides";
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return this.side;
	}
	
	double getArea() {
		double area = this.side*this.side;
		return area;
	}
	
	double getPerimeter() {
		double perimeter = 4*this.side;
		return perimeter;
	}
	
}
