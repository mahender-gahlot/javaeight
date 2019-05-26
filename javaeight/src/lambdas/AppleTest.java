package lambdas;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {
	
	public static void main(String[] args) {
		
		List<Apple> apples=new ArrayList<>();
		Apple a1=new Apple("green",2); 
		Apple a2=new Apple("red",5); 
		Apple a3=new Apple("green",7); 
		Apple a4=new Apple("red",3); 
		Apple a5=new Apple("green",4); 
		
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);
		apples.add(a4);
		apples.add(a5);
		
		
		AppleFormatter gf=new AppleFormatter();
		
		preetyPrint(apples, gf);
		
		
		preetyPrint(apples,new AppleFormatter() {;
		
		
		@Override
		public void filter(Apple a) {
			// TODO Auto-generated method stub
			System.out.println(a.color);
		}
		});
		
		preetyPrint(apples, new AppleFormatter());
		
		preetyPrint(apples, (Apple a)->System.out.println(a.getWeight()));
		
		preetyPrint(apples, (a)->System.out.println(a.color));
		
		preetyPrint(apples, Apple::getWeight);
		
		
		
	}

	private static void preetyPrint(List<Apple> apples, AppFormatter gf) {
		for (Apple apple : apples) {
			gf.filter(apple);
		}
		
		
	}
	
	

}
