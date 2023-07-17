//Paarth Badola
//20012789

public class Orange extends Citrus{
	
	private String type;
	
	public Orange() {
		setColor("orange");
	}
	
	public Orange(String type, String taste, boolean rotten) {
		setColor("orange");
		this.type = type;
		setTaste(taste);
		setRotten(rotten);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return super.toString() +"\n"+ "Orange" +"\n"+ "Type: " + type;
	}
	
	public boolean equals(Object o){
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Orange orange = (Orange) o;
        	return super.equals(o) && type.equals(orange.type);
	}
}

