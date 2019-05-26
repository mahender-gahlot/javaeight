package behaviorRevise;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {
	
	public static void main(String[] args) {
		
		List<Apple> apples=new ArrayList<>();
		
		apples.add(new Apple(10,"red"));
		apples.add(new Apple(20,"green"));
		apples.add(new Apple(30,"red"));
		apples.add(new Apple(40,"green"));
		apples.add(new Apple(50,"red"));
		
		//generic before java8 filter
		System.out.println("green apples::"+getGreenApples(apples));
		
		System.out.println("red apples::"+getColoredApples(apples,"red"));
		
		System.out.println("red & below 40::"+getColoredAndWeight(apples,"red",40));
		
		AppleFilter<Apple> colorFilter=new ColorFilter();
		
		System.out.println("interface red::"+getWithFilter(apples,colorFilter));
		
		
		System.out.println("interface red & below 40::"+getWithFilter(apples,new AppleFilter<Apple>() {
			
			@Override
			public boolean filter(Apple t) {
				// TODO Auto-generated method stub
				return t.color.equals("red") && t.weight<40;
			}
		}));
		
		
		System.out.println("with lambdas only red apples::"+getWithFilter(apples, (Apple a)->a.color.equals("red")));
		
		System.out.println("with lambdas  red & below 40 apples::"+getWithFilter(apples, (Apple a)->a.color.equals("red") && a.weight<40));
		
		System.out.println("with method referene red apples::"+getWithFilter(apples, Apple::isRed));
	}

	private static List<Apple> getWithFilter(List<Apple> apples, AppleFilter<Apple> colorFilter) {

		List<Apple> greenApples=new ArrayList<>();
		
		for (Apple apple : apples) {
			if(colorFilter.filter(apple)) {
				greenApples.add(apple);
			}
		}
		return greenApples;	
	}

	private static List<Apple> getColoredAndWeight(List<Apple> apples, String color, int weight) {
List<Apple> greenApples=new ArrayList<>();
		
		for (Apple apple : apples) {
			if(apple.color.equals(color) && apple.weight<weight) {
				greenApples.add(apple);
			}
		}
		return greenApples;	}

	private static List<Apple> getColoredApples(List<Apple> apples, String color) {
List<Apple> greenApples=new ArrayList<>();
		
		for (Apple apple : apples) {
			if(apple.color.equals(color)) {
				greenApples.add(apple);
			}
		}
		return greenApples;
	}

	private static List<Apple> getGreenApples(List<Apple> apples) {
		List<Apple> greenApples=new ArrayList<>();
		
		for (Apple apple : apples) {
			if(apple.color.equals("green")) {
				greenApples.add(apple);
			}
		}
		return greenApples;
	}

	private static boolean applyFilter(Apple apple,AppleFilter<Apple> colorFilter) {
		return colorFilter.filter(apple);
	}

	private static boolean applyFilter(int weight, String color) {
		if(color.equals("red") && weight<40) {
			return true;
		}
		return false;
	}

}
