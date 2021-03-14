package MyProj;

public class VarargsExample1 {
	public static void display(String... values) {
		System.out.println("Samle varargs method");
	}

	public static void main(String[] args) {
		display();
		display("I", "AM", "varargs", "method");
	}
}
