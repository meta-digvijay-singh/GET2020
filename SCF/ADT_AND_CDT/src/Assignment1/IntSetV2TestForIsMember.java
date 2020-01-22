package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetV2TestForIsMember {

	private IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
	@Test
	public void positiveTestForFirstElement() {
		assertEquals(true, s.isMember(1));
	}
	
	@Test
	public void positiveTestForMiddleElement() {
		assertEquals(true, s.isMember(2));
	}
	
	@Test
	public void positiveTestForLastElement() {
		assertEquals(true, s.isMember(3));
	}
	
	@Test
	public void negativeTestForElemeneLessThanMinRange() {
		assertEquals(false, s.isMember(0));
	}
	
	@Test
	public void negativeTestForElemeneGreaterThanMaxRange() {
		assertEquals(false, s.isMember(1001));
	}

	@Test
	public void negativeTestForElemeneNotPresent() {
		assertEquals(false, s.isMember(500));
	}

}
