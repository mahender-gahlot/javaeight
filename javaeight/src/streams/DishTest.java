package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DishTest {
	
	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		System.out.println(IntStream.rangeClosed(1, 100).boxed().collect(partitioningBy(n->{ if(n%2==0)return true;else return false;})));
		
		//grouping
		
		System.out.println(menu.stream().collect(groupingBy(Dish::getType)));
		
		System.out.println(menu.stream().collect(groupingBy(d->{if(d.getCalories()>500) return "high"; else return "low";})));
		
		System.out.println(menu.stream().collect(groupingBy(Dish::getType,counting())));
		
		System.out.println(menu.stream().collect(groupingBy(Dish::getType,toList())));
		
		
		System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian)));
		
		System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,maxBy(Comparator.comparingInt(Dish::getCalories)))));
		
		System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
groupingBy(Dish::getType))));
		
		System.out.println(menu.stream().collect(partitioningBy(Dish::isVegetarian,
				counting())));
		
		
		//collectors
		System.out.println(menu.stream().count());
		
		System.out.println("count"+menu.stream().collect(Collectors.counting()));
		 
		System.out.println("highest calorie" + menu.stream().collect(maxBy(Comparator.comparingInt(Dish::getCalories))));
		
		System.out.println("total cals "+menu.stream().collect(Collectors.summingInt(Dish::getCalories)));
		
		System.out.println("avg cals "+menu.stream().collect(Collectors.averagingDouble(Dish::getCalories)));
		
		
		System.out.println("summerizing int "+menu.stream().collect(Collectors.summarizingInt((Dish::getCalories))));
		
		System.out.println("joined  "+menu.stream().map(Dish::getName).collect(joining(",")));
		
	//	System.out.println("joined  "+menu.stream().collect(joining(",")));
		
		
		//find number of dishes
		System.out.println(menu.stream().map(d->1).reduce(0,Integer::sum));
		//find number of dishes using count
		System.out.println(menu.stream().count());
		
		
		System.out.println(menu.stream().filter(d->Dish.Type.MEAT==d.getType()).limit(2).collect(toList()));
		
		System.out.println(menu.stream().map(d->d.getName().length()).skip(2).limit(2).collect(toList()));
		
		System.out.println(menu.stream().map(d->d.getName().length()).collect(toList()));
		
		System.out.println(menu.stream().map(d->d.getName().length()).distinct().collect(toList()));
		
		List<Dish> vegDishes=menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(vegDishes);
		
		//first two meet dishes
		System.out.println(menu.stream().filter(d ->Dish.Type.MEAT==d.getType()).limit(2).collect(toList()));
		
		//length of each word - using map
		List<String> stringList=Arrays.asList("apple","ball","cat","dog","elephant","fish","goat");
		System.out.println(stringList.stream().collect(toList()));
		System.out.println(stringList.stream().map(l->l.length()).collect(toList()));
		
		//map 
		System.out.println(menu.stream().map(d ->d.getName().length()).collect(toList()));
		//distinct
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		System.out.println(numbers.stream().distinct().collect(toList()));
		
		//limit
		System.out.println(numbers.stream().distinct().limit(2).collect(toList()));
		
		//skip and limit
		System.out.println(numbers.stream().distinct().skip(2).limit(2).collect(toList()));
		
		
		//collections
		
		System.out.println(""+menu.stream().collect(Collectors.counting()));
		
		
		
		List<String> helloList=Arrays.asList("Hello","World");
		List<String[]> s=helloList.stream().map(l->l.split("")).distinct().collect(toList());
		for (String[] strings : s) {
			for (String string : strings) {
				System.out.println(string);
			}
			
		}
		String[] arrays= {"hello","world"};
		Stream<String> as=Arrays.stream(arrays);
		System.out.println(as.map(l->l.split("")).flatMap(Arrays::stream).distinct().collect(toList()));
	
	
		List<Integer> is=Arrays.asList(2,5,6,8,9);
		System.out.println(is.stream().map(i->i*i).collect(toList()));
		
		Integer[][] ia= {{1,3},{2,5,7}};
		Arrays.asList(ia);
		System.out.println(is.stream().map(i->i*i).collect(toList()));
		
		//collections
		
		
	}

}
