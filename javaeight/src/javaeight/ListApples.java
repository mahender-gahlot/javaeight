package javaeight;

import java.util.ArrayList;
import java.util.List;

public class ListApples {
	
	public static  void main(String[] args) {
		List<Apple> apples=new ArrayList<>();
		
		Apple apple1=new Apple("red",155);
		Apple apple2=new Apple("green",50);
		Apple apple3=new Apple("golder",75);
		
		apples.add(apple1);
		apples.add(apple2);
		apples.add(apple3);
		 
		
		AppleFormatter formatter=new AppleFancyFormatter();
		prettyPrintApple(apples,formatter);
		
		AppleFormatter simpleFormatter=new AppleSimpleFormatter();
		prettyPrintApple(apples, simpleFormatter);
		
		prettyPrintApple(apples, new AppleFormatter() {
			
			@Override
			public void formatApple(Apple apple) {
				System.out.println(apple.color+":"+apple.weight);
				
			}
		});
		
		prettyPrintApple(apples, (Apple apple)-> System.out.println(apple.color+apple.weight));
		System.out.println(apples);
		
		apples.sort((Apple a1,Apple a2)-> a1.weight.compareTo(a2.weight));
		System.out.println(apples);
	}	
	public static void prettyPrintApple(List<Apple> apples,AppleFormatter formatter){
		for (Apple apple : apples) {
			formatter.formatApple(apple);
		}
		
	}

}
