package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Contains positive test cases for LCM.
 */
@RunWith(Parameterized.class)
public class MathProblemsTestForLCMForNormalCases {

    private int input1, input2;
    long expectedOutput;
    
    public MathProblemsTestForLCMForNormalCases(int input1, int input2, long expectedOutput) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedOutput = expectedOutput;
    }
    
    @Parameters
    public static Collection<Object[]> buildTestCases() {
        Object[][] data = new Object[][] {
                { 2, 3, 6 },
                { 2, 4, 4 },
                { 4, 2, 4 },
                { 1, 1, 1 }
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void test() {
        assertEquals(expectedOutput, MathProblems.findLCM(input1, input2));
    }

}
