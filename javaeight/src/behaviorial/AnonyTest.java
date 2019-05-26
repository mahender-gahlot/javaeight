package behaviorial;

import java.util.function.Consumer;
import java.util.function.Function;

public class AnonyTest {

	
	public static void main(String[] args) {
		
		 int x=10;
		//x=11;
		Runnable x1=()->System.out.println(x);
		x1.run();
		/*printSqaure(new TestAnony() {
			
			@Override
			public int sqaureIt() {
				// TODO Auto-generated method stub
				return x*x;
			}
		});*/
	}

	private static void printSqaure(TestAnony testAnony) {
		System.out.println(testAnony.sqaureIt());
		
	}
}

interface TestAnony{
	int sqaureIt();
}