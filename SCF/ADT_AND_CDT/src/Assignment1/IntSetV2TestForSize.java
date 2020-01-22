package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetV2TestForSize {

	@Test
	public void testForSomeSize() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		assertEquals(3, s.size());
	}
	
	@Test
	public void testForZeroSize() {
		IntSetV2 s = new IntSetV2(new int[] {});
		assertEquals(0, s.size());
	}
	
}
