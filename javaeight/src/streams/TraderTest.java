package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TraderTest {

	public static void main(String[] args) {
		
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		
		List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000),
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710),
		new Transaction(mario, 2012, 700),
		new Transaction(alan, 2012, 950)
		);
		
		//1. Find all transactions in the year 2011 and sort them by value (small to high).t
		System.out.println(transactions.stream().filter(t->t.year==2011).sorted((t1,t2)->{if(t1.value>=t2.value)return 1;else return -1;}).collect(Collectors.toList()));
		System.out.println(transactions.stream().filter(t->t.year==2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));
		
		//2.What are all the unique cities where the traders work?
		System.out.println(transactions.stream().map(t->t.trader.city).distinct().collect(Collectors.toList()));
		System.out.println(transactions.stream().map(t->t.trader.city).collect(Collectors.toSet()));
		
		//3. Find all traders from Cambridge and sort them by name.
		System.out.println(transactions.stream().filter(t->t.trader.city.equals("Cambridge")).map(t->t.trader.name).distinct().sorted().collect(Collectors.toList()));
		
		//4. Return a string of all traders’ names sorted alphabetically.
		System.out.println(transactions.stream().map(t->t.trader.name).distinct().sorted().reduce("",(n1,n2)->n1+n2));
		
		System.out.println(transactions.stream().map(t1->t1.getTrader().getName()).distinct().sorted().collect(Collectors.joining()));
		//5. Are any traders based in Milan?
		System.out.println(transactions.stream().map(t->t.trader.city.equals("Milan")).findAny().isPresent());
		
		
		//		6. Print all transactions’ values from the traders living in Cambridge.
		System.out.println(transactions.stream().filter(t->t.trader.city.equals("Cambridge")).map(t->t.value).collect(Collectors.toList()));
		
		
			//	7. What’s the highest value of all the transactions?
		System.out.println(transactions.stream().map(t->t.value).reduce(0,Integer::max));
		
				//8. Find the transaction with the smallest value.
		System.out.println(transactions.stream().map(t->t.value).reduce(Integer::min).get());
		
	}
}
