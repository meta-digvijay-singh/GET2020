package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetV2TestForIsSubSet {

	@Test
	public void positiveTestForFirstElementToBeSubset() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{1});
		assertEquals(true, s.isSubSet(subset));
	}
	
	@Test
	public void positiveTestForMiddleElementToBeSubset() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{2});
		assertEquals(true, s.isSubSet(subset));
	}
	
	@Test
	public void positiveTestForLastElementToBeSubset() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{3});
		assertEquals(true, s.isSubSet(subset));
	}
	
	@Test
	public void positiveTestForEmptySetToBeSubset() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{});
		assertEquals(true, s.isSubSet(subset));
	}

	@Test
	public void negativeTestForSubsetHavingGreaterSize() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{1, 2, 3, 4});
		assertEquals(false, s.isSubSet(subset));
	}
	
	@Test
	public void negativeTestForSubsetHavingNotMatchingElement() {
		IntSetV2 s = new IntSetV2(new int[] {1, 2, 3});
		IntSetV2 subset = new IntSetV2(new int[]{1, 2, 4});
		assertEquals(false, s.isSubSet(subset));
	}
}
