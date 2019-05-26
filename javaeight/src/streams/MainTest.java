package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;;


public class MainTest {
	
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList( new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950) );

		
		//find all transactions in 2011, sort by min to max
		
		transactions.stream().
				filter((t)->t.getYear()==2011).
				sorted(comparing(Transaction::getValue))
				.forEach(System.out::println);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		//unique cities
		transactions.stream().map(t->t.getTrader().getCity())
		.distinct().forEach(System.out::println);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		//find all traders in cambridge and sort by name
		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
				.distinct()
				.map(Transaction::getTrader)
				.sorted(comparing(Trader::getName))
				.forEach(System.out::println);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		// names of traders sorted
		System.out.println(transactions.stream().map(t->t.getTrader().getName()).distinct().
				sorted().reduce("",(n1,n2)-> n1+","+n2));
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		System.out.println(transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan")));
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
		.map(Transaction::getValue).forEach(System.out::println);
		
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		int maxvalue=transactions.stream().map(Transaction::getValue).reduce(0,Integer::max);
		
		//transaction having min value
		System.out.println(transactions.stream().min(comparing(Transaction::getValue)));
		
		
		
		
	}

	
	

}
