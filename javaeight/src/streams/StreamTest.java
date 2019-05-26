package streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	
	

public static void main(String[] args) {
	Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
	System.out.println(stream.map(String::toUpperCase).collect(Collectors.joining(",")));
	
}
}
