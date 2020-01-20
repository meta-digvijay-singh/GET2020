package Assignment1;

import org.junit.Test;

/**
 * Contains Negative test cases for LCM.
 */
public class MathProblemsTestForLCMNegativeTestCases {

    @Test(expected = AssertionError.class)
    public void testForFirstInputToBeZero() {
        MathProblems.findLCM(0, 10);
    }
    
    @Test(expected = AssertionError.class)
    public void testForSecondInputToBeZero() {
        MathProblems.findLCM(10, 0);
    }
    
    @Test(expected = AssertionError.class)
    public void testForBothInputsToBeZero() {
        MathProblems.findLCM(0, 0);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testForOverflow() {
        MathProblems.findLCM(Integer.MAX_VALUE, 2);
    }

}
