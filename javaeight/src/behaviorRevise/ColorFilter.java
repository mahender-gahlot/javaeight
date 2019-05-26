package behaviorRevise;

public class ColorFilter implements AppleFilter<Apple>{

	@Override
	public boolean filter(Apple t) {
		// TODO Auto-generated method stub
		return t.getColor().equals("red");
	}

}
