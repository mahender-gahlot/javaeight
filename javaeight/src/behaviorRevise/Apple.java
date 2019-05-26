package behaviorRevise;

public class Apple {
	
	int weight;
	String color;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[weight=" + weight + ", color=" + color + "]";
	}
	
	public boolean isRed() {
		return this.getColor().equals("red");
	}
	/**
	 * @param weight
	 * @param color
	 */
	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
