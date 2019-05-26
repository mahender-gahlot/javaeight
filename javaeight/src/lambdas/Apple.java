package lambdas;

public class Apple {
	
	String color;

	int weight;
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}

	/**
	 * @param color
	 * @param weight
	 */
	public Apple(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
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
