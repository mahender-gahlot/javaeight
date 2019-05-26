package behaviorial;

public class ColorPredicate implements Predicate<Apple>{

	@Override
	public boolean test(Apple t) {
		
		return t.color.equals("green");
	}

}
