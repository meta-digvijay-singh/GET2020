package Assignment1;

import org.junit.Test;

public class MathProblemsTestForHCFNegativeCases {

	@Test(expected = AssertionError.class)
    public void testForFirstInputToBeZero() {
        MathProblems.findHCF(0, 0);
    }
	
}
