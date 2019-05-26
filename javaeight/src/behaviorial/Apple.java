package behaviorial;

public class Apple {
	
	public Apple(String color, Integer weight) {
		this.color=color;
		this.weight=weight;
	}

	String color;
	
	Integer weight;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color+":"+weight;
	}
	
	public boolean isRed() {
		return this.color.equals("red");
	}
}