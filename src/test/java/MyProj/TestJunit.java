package MyProj;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJunit {
	String message = "Testing Junit";
	JunitTest jUnitTest = new JunitTest(message);

	@Test
	public void testPrintMessage() {
		assertEquals(message, jUnitTest.printMessage());
	}

}
