import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrOperationTestForMaxMirror {

    private int[] input;
    private int expectedOutput;

    public ArrOperationTestForMaxMirror(int[] input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> prepareData() {
        Object[][] data = new Object[][] {
                { new int[] { 1, 2, 3, 8, 9, 3, 2, 1 }, 3 },
                { new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 },
                { new int[] { 1, 2, 1, 4 }, 3 }, 
                { new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 } };
        return Arrays.asList(data);
    }

    /* test for normal inputs */
    @Test
    public void testMaxMirror() {
        ArrOperation operation = new ArrOperation();
        assertEquals(expectedOutput, operation.maxMirror(input));
    }
    
    /* test for assertion error when array is empty. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInMaxMirror() {
        ArrOperation operation = new ArrOperation();
        operation.maxMirror(new int[0]);
    }
}
