//Paarth Badola
//20012789

public class Apple extends Fruit {
	private String taste;
	private String texture;

	public Apple() {
	}
	
	public Apple(String taste, String texture, String color, boolean rotten) {
		this.taste = taste;
		this.texture = texture;
		setColor(color);
		setRotten(rotten);
	}
	
	public String getTaste() {
		return taste;
	}
	
	public void setTaste(String taste) {
		this.taste = taste;
	}
	
	public String getTexture() {
		return texture;
	}
	
	public void setTexture(String texture) {
		this.texture = texture;
	}
	
	public String toString() {
		return super.toString() +"\n"+ "Apple" +"\n"+ "Taste: " + taste +"\n"+ "Texture: " + texture;
	}
	
	public boolean equals(Object o){
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Apple apple = (Apple) o;
        	return super.equals(o) && taste.equals(apple.taste) && texture.equals(apple.texture);
	}
}
