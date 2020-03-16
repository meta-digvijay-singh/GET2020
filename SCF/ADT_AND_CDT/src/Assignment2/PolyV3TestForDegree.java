package Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyV3TestForDegree {

	private PolyV3 polynomial = new PolyV3(new int[][] {
			new int[] {2, 2},
			new int[] {1, 0},
	});
	
	@Test
	public void test() {
		assertEquals(2, polynomial.degree());
	}

}
