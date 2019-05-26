package javaeight;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public void formatApple(Apple apple) {
		System.out.println("A "+apple.color+" of weight "+apple.weight);
	}

}
