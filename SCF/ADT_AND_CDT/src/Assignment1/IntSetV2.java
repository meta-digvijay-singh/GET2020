package Assignment1;

/**
 * This class represents an immutable set.
 */
public class IntSetV2 {
	/* Contains information about set element, it contains set[value] = AVAILABLE 
	 * if element is present in the set, else it contains set[value] = UNAVAILABLE.
	 */
	private int set[] = new int[1001]; 
	private int size = 0;
	private final int AVAILABLE = 1;
	private final int UNAVAILABLE = 0;
	private static final int MIN_RANGE = 1; //Minimum value allowed to be put in set.
	private static final int MAX_RANGE = 1000; // Maximum value allowed to be put in set.
	
	/**
	 * provided elements available in set.
	 * @return array containing elements of set.
	 */
	public int[] getElements() {
		if (size == 0) {
			return new int[0];
		}
		int[] elements = new int[size];
		int index = 0;
		for (int value = 1; value <= MAX_RANGE; value++) {
			if (set[value] == AVAILABLE) {
				elements[index] = value;
				index++;
			}
		}
		return elements;
	}
	
	/**
	 * Constructs set.
	 * @param array : array consisting of elements.
	 * @throws ArithmeticException if given array contains any element 
	 * 							   which is not in set range.
	 */
	public IntSetV2(int[] array) throws ArithmeticException {
		int length = array.length;
		for (int index = 0; index < length; index++) {
			int element = array[index];
			if (element < MIN_RANGE || element > MAX_RANGE) {
				throw new ArithmeticException("Set can contain element ranging from " + MIN_RANGE + " - " + MAX_RANGE);
			}
			if (set[element] == UNAVAILABLE) {
				set[element] = AVAILABLE;
				size++;
			}
		}
	}
	
	/**
	 * Checks whether given element is present in set.
	 * @param x : element to be checked.
	 * @return true element is present in set, otherwise false.
	 */
	public boolean isMember(int x) {
		if ((size == 0) || ((x < MIN_RANGE) || (x > MAX_RANGE))) {
			return false;
		}
		return set[x] == AVAILABLE;
	}
	
	/**
	 * Computes size of the set.
	 * @return number of elements present in the set.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Checks whether given set s is a subset of "this" set.
	 * @param s : set which is to be checked for subset.
	 * @return true if s is subset of "this" set, else false.
	 */
	public boolean isSubSet(IntSetV2 s) {
		int sizeOfS = s.size();
		int sizeOfCurrentSet = this.size();
		if (sizeOfS == 0) {
			return true;
		}
		if (sizeOfCurrentSet < sizeOfS) {
			return false;
		}
		int[] elements = s.getElements();
		for (int element : elements) {
			if (!isMember(element)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Computes complement of "this" set.
	 * Universal set = {1, 2, 3, 4, ..., 1000}.
	 * @return complemented set.
	 */
	public IntSetV2 getComplement() {
		int sizeOfComplementedSet = MAX_RANGE - size;
		int[] elements = new int[sizeOfComplementedSet];
		int index = 0;
		for (int value = 1; value <= MAX_RANGE; value++) {
			if (!isMember(value)) {
				elements[index] = value;
				index++;
			}
		}
		return new IntSetV2(elements);
	}
	
	/**
	 * Computes union of the given sets.
	 * @param s1 : first set.
	 * @param s2 : second set.
	 * @return union of s1 and s2.
	 * 		   for. e.g. s1 = {1, 2, 3}
	 * 					 s2 = {2, 3, 4}
	 * 				then s1 U s2 = {1, 2, 3, 4}.
	 */
	public static IntSetV2 union(IntSetV2 s1, IntSetV2 s2) {
		int[] elementsOfS1 = s1.getElements();
		int[] elementsOfS2 = s2.getElements();
		int lengthOfS1 = elementsOfS1.length;
		int lengthOfS2 = elementsOfS2.length;
		int lengthOfUnion = lengthOfS1 + lengthOfS2;
		int[] elementsOfUnion = new int[lengthOfUnion];
		for (int index = 0; index < lengthOfS1; index++) {
			elementsOfUnion[index] = elementsOfS1[index];
		}
		for (int index = lengthOfS1; index < lengthOfUnion; index++) {
			elementsOfUnion[index] = elementsOfS2[index - lengthOfS1];
		}
		return new IntSetV2(elementsOfUnion);
	}
}