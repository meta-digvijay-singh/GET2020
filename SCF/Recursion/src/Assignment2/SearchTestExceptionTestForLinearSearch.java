package Assignment2;

import org.junit.Test;


public class SearchTestExceptionTestForLinearSearch {

    @Test(expected = AssertionError.class)
    public void testLinearSearchForException() {
        Search.linearSearch(new int[0], 10);
    }

}
