package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetV2TestForGetComplement {

	private static final int MAX_SIZE = 1000;
	@Test
	public void PositiveTestForSomeValues() {
		int[] array = new int[]{1, 10};
		int sizeOfComplementedSet = MAX_SIZE - array.length;
		int[] complementedSet = new int[sizeOfComplementedSet];
		int index = 0;
		for (int value = 1; value <= MAX_SIZE; value++) {
			if (value == 1 || value == 10) {
				continue;
			}
			complementedSet[index] = value;
			index++;
		}
		IntSetV2 s = new IntSetV2(array);
		assertArrayEquals(complementedSet, s.getComplement().getElements());
	}
	
	@Test
	public void PositiveTestForEmptySetValues() {
		int[] array = new int[]{1, 10};
		int sizeOfComplementedSet = MAX_SIZE - array.length;
		int[] complementedSet = new int[sizeOfComplementedSet];
		int index = 0;
		for (int value = 1; value <= MAX_SIZE; value++) {
			if (value == 1 || value == 10) {
				continue;
			}
			complementedSet[index] = value;
			index++;
		}
		IntSetV2 s = new IntSetV2(array);
		assertArrayEquals(complementedSet, s.getComplement().getElements());
	}

	@Test
	public void PositiveTestForSetConsistsAllValues() {
		int[] array = new int[1000];
		for (int value = 1; value <= MAX_SIZE; value++) {
			array[value - 1] = value;	
		}
		int[] complementedSet = new int[0];
		IntSetV2 s = new IntSetV2(array);
		assertArrayEquals(complementedSet, s.getComplement().getElements());
	}
}
