package behaviorial;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		Apple a1=new Apple("green",5);
		Apple a2=new Apple("red",3);
		Apple a3=new Apple("green",2);
		Apple a4=new Apple("green",1);
		Apple a5=new Apple("red",5);
		
		
		List<Apple> apples=new ArrayList<>();
		
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);
		apples.add(a4);
		apples.add(a5);
		
		//hard coded color
		List<Apple> greenApples=getGreenApples(apples);
		System.out.println(greenApples);
		
		//dynamic color
		String color="red";
		List<Apple> coloredApples=getColoredApples(apples,color);
		System.out.println(coloredApples);
		
		//dynamic and attribute color or weight
		String color1="green";
		int weight=2;
		List<Apple> filteredApples=getFilteredApples(apples,color1,weight);
		System.out.println(filteredApples);
		
		Predicate<Apple> colorP=new ColorPredicate();
		
		List<Apple> Apples1=getPredicateApples(apples,colorP);
		System.out.println(Apples1);
		
		
		//fifth attempt anonymous class
		List<Apple> Apples2=getPredicateApples(apples,new Predicate<Apple>() {
			
			@Override
			public boolean test(Apple t) {
				return t.color.equals("red");
			}
		});
		System.out.println(Apples2);
		
		
		//sixth attemp lambdas
		List<Apple> Apples3=getPredicateApples(apples,(Apple a)->a.weight>2 && a.color.equals("red"));
		System.out.println(Apples3);
		
		//seventh attempt method reference
		List<Apple> Apples4=getPredicateApples(apples,Apple::isRed);
		System.out.println(Apples4);
		
		//eighth attempt abstract list iteration
		List<Apple> Apples5=filter(apples,(Apple a)->a.weight>2);
		System.out.println(Apples5);
		
	}

	private static  <T> List<T> filter(List<T> t,Predicate<T> p) {
		List<T> result =new ArrayList<>();
		
		for (T e : t) {
			if(p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	//fourth attempt with predicate
	private static List<Apple> getPredicateApples(List<Apple> apples, Predicate<Apple> colorP) {

List<Apple> sample=new ArrayList<>();
		
		for (Apple apple : apples) {
		
			if(colorP.test(apple)) {
				sample.add(apple);
			}
		}
		return sample;
	
	}

	//third attempt all parameters
	private static List<Apple> getFilteredApples(List<Apple> apples, String color1, int weight) {

List<Apple> sample=new ArrayList<>();
		
		for (Apple apple : apples) {
		
			if(apple.color.equals(color1) && weight<=apple.weight) {
				sample.add(apple);
			}
		}
		return sample;
	
	}

	//second attempt pass color 
	private static List<Apple> getColoredApples(List<Apple> apples, String color) {
List<Apple> sample=new ArrayList<>();
		
		for (Apple apple : apples) {
		
			if(apple.color.equals(color)) {
				sample.add(apple);
			}
		}
		return sample;
	}

	//first attempt hard coded
	private static List<Apple> getGreenApples(List<Apple> apples) {
		
		List<Apple> sample=new ArrayList<>();
		
		for (Apple apple : apples) {
		
			if(apple.color.equals("green")) {
				sample.add(apple);
			}
		}
		return sample;
	}
}
