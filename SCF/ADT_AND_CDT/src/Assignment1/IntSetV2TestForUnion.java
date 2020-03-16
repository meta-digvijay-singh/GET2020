package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetV2TestForUnion {

	@Test
	public void testForUnionOfEmptySets() {
		IntSetV2 input1 = new IntSetV2(new int[]{});
		IntSetV2 input2 = new IntSetV2(new int[]{});
		int[] expectedOutput = new int[]{};
		assertArrayEquals(expectedOutput, IntSetV2.union(input1, input2).getElements());
	}
	
	@Test
	public void testForUnionOfNonEmptySets() {
		IntSetV2 input1 = new IntSetV2(new int[]{1, 2, 3});
		IntSetV2 input2 = new IntSetV2(new int[]{2, 3, 4});
		int[] expectedOutput = new int[]{1, 2, 3, 4};
		assertArrayEquals(expectedOutput, IntSetV2.union(input1, input2).getElements());
	}

}
