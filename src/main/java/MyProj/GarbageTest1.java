package MyProj;

public class GarbageTest1 {
	public void finalize() {
		System.out.println("Garbage Collected");
	}

	public static void main(String[] args) {
		GarbageTest1 s1 = new GarbageTest1();
		GarbageTest1 s2 = new GarbageTest1();
		s1 = null;
		s2 = null;
		System.gc();
	}
}
