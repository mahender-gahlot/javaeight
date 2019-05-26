package streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythoTriplets {

	public static void main(String[] args) {
		
		//int a=1;
		IntStream.range(1,100).boxed().flatMap(a->IntStream.range(a,100).filter(b->Math.sqrt(a*a+b*b)%1==0).mapToObj(b->new int[] {a,b,(int)Math.sqrt(a*a+b*b)})).forEach(t->System.out.println(t[0]+","+t[1]+","+t[2]));
		
		
		
		
		
		Stream.iterate(new int[] {0,1}, n-> new int [] {n[1],n[0]+n[1]}).limit(10).forEach(n->System.out.println(n[0]+","+n[1]));
		
		
		
		
		
		
		
		
		
		
		
		
		/*Stream<double[]> arr= IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a->IntStream.rangeClosed(a,100).mapToObj(b->new double[] {a,b,Math.sqrt(a*a+b*b)})
				.filter(t->t[2]%1==0));
		
		arr.limit(15).forEach(t->System.out.println((int)t[0]+", "+(int)t[1]+", "+(int)t[2]));*/
		
		Stream<String> ss=Stream.of("tes","sdf","sdfs");
		
		ss.map(String::toUpperCase).forEach(System.out::print);
		
	}
}
