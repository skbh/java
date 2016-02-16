package _Java8;

interface GreetingService {
	void sayMessage(String message);
}

public class _ExamplesJava8 {

	final static String salutation = "Hello! ";

	public static void main(String[] args) {
		GreetingService greetService1 = message -> System.out.println(salutation + message);
		greetService1.sayMessage("Mahesh");
	}

}
