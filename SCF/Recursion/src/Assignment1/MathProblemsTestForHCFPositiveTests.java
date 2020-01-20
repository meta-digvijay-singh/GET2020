package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MathProblemsTestForHCFPositiveTests {

	private int input1, input2;
    long expectedOutput;
    
    public MathProblemsTestForHCFPositiveTests(int input1, int input2, long expectedOutput) {
        this.input1 = input1;
        this.input2 = input2;
        this.expectedOutput = expectedOutput;
    }
    
    @Parameters
    public static Collection<Object[]> buildTestCases() {
        Object[][] data = new Object[][] {
                { 2, 3, 1 },
                { 2, 4, 2 },
                { 4, 2, 2 },
                { 1, 1, 1 },
                { 4, 6, 2 },
                { 2, 0, 2 },
                { 0, 2, 2 }
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void testCasesPositive() {
        assertEquals(expectedOutput, MathProblems.findHCF(input1, input2));
    }

}
