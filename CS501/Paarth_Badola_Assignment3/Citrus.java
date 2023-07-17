//Paarth Badola
//20012789

public class Citrus extends Fruit {
	private String taste;
		
	public Citrus() {
			
	}
		
	public Citrus(String taste, String color, boolean rotten) {
		this.taste = taste;
		setColor(color);
		setRotten(rotten);
	}
		
	public String getTaste() {
		return taste;
	}
	
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public String toString() {
		return super.toString() +"\n"+ "Citrus" +"\n"+ "Taste: " + taste;
	}
	
	public boolean equals(Object o){
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Citrus citrus = (Citrus) o;
        	return super.equals(o) && taste.equals(citrus.taste);
	}
	
}

