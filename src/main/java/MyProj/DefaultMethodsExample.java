package MyProj;

interface Sayable2 {
	default void say() {
		System.out.println("Hello, this is a default method");
	}
}

public class DefaultMethodsExample implements Sayable2 {
	public void sayMore(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
		DefaultMethodsExample dm = new DefaultMethodsExample();
		dm.say(); // calling default method
		dm.sayMore("Example"); // calling abstract method
	}
}
