package MyProj;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationTest {

	@Test
	public void testFindMax() {
		assertEquals(4, Calculation.findMax(new int[] { 1, 3, 4, 3 }));
		assertEquals(-1, Calculation.findMax(new int[] { -1, -3, -4, -3 }));
	}

}