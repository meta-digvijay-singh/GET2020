import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrOperationTestForFixXY {

    private int[] input;
    private int X;
    private int Y;
    private int[] expectedOutput;

    public ArrOperationTestForFixXY(int[] input, int X, int Y,
            int[] expectedOutput) {
        this.input = input;
        this.X = X;
        this.Y = Y;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> prepareData() {
        Object[][] data = new Object[][] {
                { new int[] { 5, 4, 9, 4, 9, 5 }, 4, 5, new int[] { 9, 4, 5, 4, 5, 9 } },
                { new int[] { 1, 4, 1, 5 }, 4, 5, new int[] { 1, 4, 5, 1 } },
                { new int[] { 1, 4, 1, 5, 5, 4, 1 }, 4, 5, new int[] { 1, 4, 5, 1, 1, 4, 5 } } };
        return Arrays.asList(data);
    }

    @Test
    public void testFixXY() {
        ArrOperation operation = new ArrOperation();
        assertArrayEquals(expectedOutput, operation.fixXY(input, X, Y));
    }
    
    /* test for assertion error for when array is empty. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInFixXYForEmptyArray() {
        ArrOperation operation = new ArrOperation();
        operation.fixXY(new int[0], 4, 5);
    }
    
    /* test for assertion error when we have two adjacent X. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInFixXYForAdjacentX() {
        ArrOperation operation = new ArrOperation();
        operation.fixXY(new int[] { 1, 2, 4, 4, 5, 5 }, 4, 5);
    }
    
    /* test for assertion error when we X at the end. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInFixXYForXAtEnd() {
        ArrOperation operation = new ArrOperation();
        operation.fixXY(new int[] { 1, 2, 3, 4, 5, 5, 4 }, 4, 5);
    }
    
    /* test for assertion error when we have unequal number of X and Y. */
    @Test(expected = AssertionError.class)
    public void testForExceptionInFixXYForUnequalXAndY() {
        ArrOperation operation = new ArrOperation();
        operation.fixXY(new int[] { 4, 2, 3, 4, 5, 5, 5}, 4, 5);
    }
    
}
