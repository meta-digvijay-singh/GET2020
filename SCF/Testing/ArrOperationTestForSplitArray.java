import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrOperationTestForSplitArray {

    private int[] input;
    private int expectedOutput;

    public ArrOperationTestForSplitArray(int[] input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> prepareData() {
        Object[][] data = new Object[][] { { new int[] { 1, 1, 1, 2, 1 }, 3 },
                { new int[] { 2, 1, 1, 2, 1 }, -1 },
                { new int[] { 10, 10 }, 1 } };
        return Arrays.asList(data);
    }

    /* test for normal cases. */
    @Test
    public void testSplitArray() {
        ArrOperation operation = new ArrOperation();
        assertEquals(expectedOutput, operation.splitArray(input));
    }
    
    /* test for assertion error when array is empty. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInSplitArray() {
        ArrOperation operation = new ArrOperation();
        operation.splitArray(new int[0]);
    }

}
