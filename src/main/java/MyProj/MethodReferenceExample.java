package MyProj;

interface Sayable {
	void say();
}

public class MethodReferenceExample {
	public static void saySomething() {
		System.out.println("Hello, this is a static method");
	}

	public static void main(String[] args) {
		// Referring static method
		Sayable sayable = MethodReferenceExample::saySomething;
		// calling interface method
		sayable.say();
	}
}
