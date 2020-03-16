package Assignment2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SearchTestPositiveCasesForLinearSearch {

    private int[] array;
    private int value;
    private int expectedOutput;
    
    public SearchTestPositiveCasesForLinearSearch(int[] array, int value,  int expectedOutput) {
        this.array = array;
        this.value = value;
        this.expectedOutput = expectedOutput;
    }
    
    @Parameters
    public static Collection<Object[]> buildPositiveTests() {
        Object[][] data = new Object[][] {
                { new int[]{1, 2, 3}, 1, 0},
                { new int[]{1, 2, 3}, 2, 1},
                { new int[]{1, 2, 3}, 3, 2},
                { new int[]{1, 2, 3}, 4, -1}
                
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void testLinearSearchForPositiveCases() {
        assertEquals(expectedOutput, Search.linearSearch(array, value));
    }

}
