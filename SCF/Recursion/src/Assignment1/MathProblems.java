package Assignment1;

/**
 * This class solves LCM and HCF problems.
 */
public class MathProblems {
    
    /**
     * Checks for integer overflow on multiplication.
     * @param value1 : first value.
     * @param value2 : second value.
     * @return true if overflow occurs, else false.
     */
    private static boolean isMultiplicationOverflow(int value1, int value2) {
        if ((value1 == 0) || (value2 == 0)) {
            return false;
        }
        int result = value1 * value2;
        if (value1 == (result / value2)) {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Calculates Highest Common Factor(HCF or GCD) of two values.
     * @param firstValue : a positive integer.
     * @param secondValue : a positive integer.
     * @return Highest common factor of given values.
     * @throws AssertionError if both parameters are zero.
     */
    public static int findHCF(int firstValue, int secondValue) throws AssertionError {
        assert (firstValue != 0) || (secondValue != 0) : "both values should not be zero."; 
        if (firstValue == 0) {
            return secondValue;
        }
        if (secondValue == 0) {
            return firstValue;
        }
        if (firstValue > secondValue) {
            return findHCF(secondValue, firstValue % secondValue);
        }
        return findHCF(firstValue, secondValue % firstValue);
    }
    
    /**
     * Calculates Least Common Factor of given two values.
     * @param firstValue : a positive integer.
     * @param secondValue : a positive integer.
     * @return Least Common Multiple of given values.
     * @throws AssertionError if any one parameter is zero.
     * @throws ArithmeticException if overflow occurs while calculation.
     */
    public static int findLCM(int firstValue, int secondValue) throws AssertionError, ArithmeticException {
        assert ((firstValue != 0) && (secondValue != 0)) : "any value can't be zero.";
        if (isMultiplicationOverflow(firstValue, secondValue)) {
            throw new ArithmeticException("Value is not supported.");
        }
        int highestCommonFactor = findHCF(firstValue, secondValue);
        int leastCommonMultiple = (firstValue * secondValue) / highestCommonFactor;
        return leastCommonMultiple;
    }
}