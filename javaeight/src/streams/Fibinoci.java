package streams;

import java.util.stream.Stream;

public class Fibinoci {

	public static void main(String[] args) {
		
		Stream.iterate(0, n->n+2).limit(10).forEach(System.out::print);
		
		System.out.println();
		Stream.iterate(1, n->n+(n-1)).limit(10).forEach(System.out::print);
		
		Stream.iterate(new int[]{0,1}, a->new int[] {a[1],a[0]+a[1]}).limit(10).forEach(t->System.out.println(t[0]+","+t[1]));
	}
}
