package MyProj;

interface sayable {
	void say(String message);
}

public class FunctionalInterfaceExample implements sayable{
	public void say(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		FunctionalInterfaceExample file = new FunctionalInterfaceExample();
		file.say("Hello there");
	}
}
