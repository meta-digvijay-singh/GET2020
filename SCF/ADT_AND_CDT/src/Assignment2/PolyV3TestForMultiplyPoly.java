package Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyV3TestForMultiplyPoly {

	private PolyV3 p1 = new PolyV3(new int[][] {
			new int[] {2, 2},
			new int[] {1, 0},
	});
	
	private PolyV3 p2 = new PolyV3(new int[][] {
			new int[] {2, 1},
			new int[] {-1, 0},
	});
	
	@Test
	public void test() {
		assertEquals("4x^3 + -2x^2 + 2x^1 + -1x^0", PolyV3.multiplyPolyV3(p1, p2).getEquation());
	}

}
