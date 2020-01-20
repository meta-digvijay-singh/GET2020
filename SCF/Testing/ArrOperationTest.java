import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrOperationTest {

    private int[] input;
    private int expectedOutput;

    public ArrOperationTest(int[] input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> prepareData() {
        Object[][] data = new Object[][] {
                { new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
                { new int[] { 1, 1, 2, 1, 1 }, 2 },
                { new int[] { 1, 1, 2, 1, 1 }, 2 }, { new int[] { 1 }, 0 } };
        return Arrays.asList(data);
    }

    /* test for normal inputs */
    @Test
    public void testCountClumps() {
        ArrOperation operation = new ArrOperation();
        assertEquals(expectedOutput, operation.countClumps(input));
    }

    /* test for assertion error when array is empty. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInCountClumps() {
        ArrOperation operation = new ArrOperation();
        operation.countClumps(new int[0]);
    }
}
