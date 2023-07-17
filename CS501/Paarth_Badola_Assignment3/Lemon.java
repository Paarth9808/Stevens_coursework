//Paarth Badola
//20012789

public class Lemon extends Citrus{
	private int sourness;
	
	public Lemon() {
		setColor("yellow");
	}
	
	public Lemon(int sourness, String taste, boolean rotten) {
		setColor("yellow");
		this.sourness = sourness;
		setTaste(taste);
		setRotten(rotten);
	}
	
	public int getSourness() {
		return sourness;
	}
	
	public void setSourness(int sourness) {
		this.sourness = sourness;
	}
	
	public String toString() {
		return super.toString() +"\n"+ "Lemon" +"\n"+ "Sourness: " + sourness;
	}
	
	public boolean equals(Object o){
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lemon lemon = (Lemon) o;
        	return super.equals(o) && sourness == lemon.sourness;
	}
	
}
