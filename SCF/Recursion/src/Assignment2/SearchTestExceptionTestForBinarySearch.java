package Assignment2;

import org.junit.Test;


public class SearchTestExceptionTestForBinarySearch {

    @Test(expected = AssertionError.class)
    public void testBinarySearchForException() {
        Search.binarySearch(new int[0], 10);
    }

}
