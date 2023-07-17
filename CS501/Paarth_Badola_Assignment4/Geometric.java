// Paarth Badola
// 20012789

abstract public class Geometric{
	private String color;
	
	Geometric(){
	}
	
	Geometric(String color){
		this.color = color;
	}
	
	
	void setColor(String color) {
		this.color = color;
	}
	
	String getColor() {
		return color;
	}
	
	abstract double getArea();
	
	abstract double getPerimeter();
}
