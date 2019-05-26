package javaeight;

public class AppleFancyFormatter implements AppleFormatter{

	@Override
	public void formatApple(Apple apple) {
		String characterstic="Light";
		if(apple.weight>150) {
			characterstic="Heavy";
		}
		
		System.out.println("A "+characterstic+" "+apple.color+" apple.");
		
	}

}
