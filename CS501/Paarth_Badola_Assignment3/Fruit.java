//Paarth Badola
//20012789

public class Fruit {
	
	// Defining data fields
	private String color;
	private boolean rotten;
	private static int next_id;
	private int id;
	
	// default constructor
	public Fruit() {
		this.id = Fruit.next_id;
		Fruit.next_id++;
	}
	
	public Fruit(String color, boolean rotten) {
		this.id = Fruit.next_id;
		this.color = color;
		this.rotten = rotten;
		
		// incrementing next_id giving value to id
		Fruit.next_id++;
	}
	
	// getter and setter methods for private data fields
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isRotten() {
		return rotten;
	}
	
	public void setRotten(boolean rotten) {
		this.rotten = rotten;
	}
	
	public int getId() {
		return id;
	}
	
	// to string method to show class name and data fields
	public String toString() {
		return "Fruit" +"\n"+ "Color: " + color + "\n"+ "Rotten: " + rotten +"\n"+ "ID: " + id;
	}
	
	// equals method for checking of objects equal
	public boolean equals(Object o){
		// checking if same object
		if (this == o) {
            return true;
        }
		// checking if object null or if typed as a different class
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // type cast o to Fruit so that we can compare data members
        Fruit fruit = (Fruit) o;
        return color.equals(fruit.color) && rotten == fruit.rotten;
	}
}

