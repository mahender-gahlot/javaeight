package behaviorial;

public class WeightPredicate implements java.util.function.Predicate<Apple> {

	@Override
	public boolean test(Apple t) {
		// TODO Auto-generated method stub
		return t.weight>5;
	}

}
