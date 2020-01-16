package Assignment1;

import java.util.Arrays;
import java.util.List;

interface SpecialCalc {
    String add(String value1, String value2) throws Exception;
    String subtract(String value1, String value2) throws Exception;
    String multiply(String value1, String value2) throws Exception;
    String divide(String value1, String value2) throws Exception;
    boolean isEqual(String value1, String value2) throws Exception;
    boolean isGreaterThan(String value1, String value2) throws Exception;
    boolean isLessThan(String value1, String value2) throws Exception;
}

public class HexCalc implements SpecialCalc {
    /*
     * Represents valid hexadecimal digits.
     */
    private final static List<Character> HEX_DIGITS;
    /*
     * Initializing valid digits of hexadecimal format.
     */
    static {
        HEX_DIGITS = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7',
                                   '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');
    }
    
    /**
     * Removes leading 0s in given string.
     * @param s : string to be handled.
     * @return string without leading zeros. 
     *         And if s is (empty or null) or (all are 0s) then return empty string "".
     *         for e.g. (1) input s = "00a" then output = "a".
     *                  (2) input s = "000" then output = "".
     */
    public String removeLeadingZeros(String s) {
        if (isNull(s)) {
            return "";
        }
        
        String result = "";
        int substringIndex = 0; // It is the index where leading zero ends.
        final int length = s.length();
        
        /* find the index where consecutive leading zero ends. */
        while ((substringIndex < length) && (s.charAt(substringIndex) == '0')) {
            substringIndex++;
        }
        
        /* fetch substring without leading zeros. */
        for (int index = substringIndex; index < length; index++) {
            result += s.charAt(index);
        }
        return result;
    }

    /**
     * Checks if given string is null.
     * @param s : string to be checked.
     * @return true if s is null or empty, else false.
     */
    public boolean isNull(final String s) {
        return ((s == null) || (s.isEmpty()));
    }

    /**
     * Checks whether entered hexValue is valid or not.
     * @param hexValue : value to be validated.
     * @return true if valid, else false.
     */
    public boolean isHexaDecimal(String hexValue) {
        if (isNull(hexValue)) {
            return false;
        }
        
        hexValue = hexValue.toLowerCase();
        int length = hexValue.length();
        boolean valid = true;
        char ch;

        /* checks if character is not in our HEX_DIGITS values */
        for (int index = 0; index < length; index++) {
            ch = hexValue.charAt(index);
            
            if (HEX_DIGITS.indexOf(ch) == -1) {
                valid = false;
                break;
            }
        }

        return valid;
    }

    /**
     * Converts given hexadecimal value to decimal.
     * @param hexValue : value to be converted.
     * @return decimal equivalent of given hexValue.
     * @throw if given hexValue is invalid or empty.
     */
    public int hexToDecimal(String hexValue) throws Exception {

        if (isNull(hexValue)) {
            throw new Exception("Null or empty string is not allowed.");
        }
        
        if (!isHexaDecimal(hexValue)) {
            throw new Exception("Only positive hexadecimal value is allowed.");
        }
        
        hexValue = hexValue.toLowerCase();
        hexValue = removeLeadingZeros(hexValue); // e.g. converts "00a" to "a".
        
        int length = hexValue.length();
        int power = length - 1;
        int result = 0;
        int base = 16;
        char ch;

        for (int index = 0; index < length; index++) {
            ch = hexValue.charAt(index);
            /* gets decimal representation of hexadecimal digits from 0 - 9 and a - z */
            int decimalValue = HEX_DIGITS.indexOf(ch); 
            
            int computePower = (int) Math.pow(base, power);
            result += computePower * decimalValue;
            power--;
        }

        return result;
    }

    /**
     * Converts given decimal value to hexadecimal.
     * @param decimalValue : value to be converted.
     * @return hexadecimal equivalent of given decimalValue.
     * @throw if value is negative.
     */
    public String decimalToHex(int decimalValue) throws ArithmeticException {

        if (decimalValue < 0) {
            throw new ArithmeticException("Value must be non-negative.");
        } else if (decimalValue == 0) {
            return "0";
        }
        
        char hexadecimalEquivalent;
        int decimalEquivalent;
        String hexValue = "";
        
        while (decimalValue != 0) {
            decimalEquivalent = decimalValue % 16;
            hexadecimalEquivalent = HEX_DIGITS.get(decimalEquivalent); 
            hexValue = hexadecimalEquivalent + hexValue;
            decimalValue = decimalValue / 16;
        }
        
        return hexValue;
    }
    
    /**
     * Computes addition of given hexadecimal values.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return Addition equivalent of hexValue1 and hexValue2 i.e. hexValue1 + hexValue2.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public String add(String hexValue1, String hexValue2) throws Exception {
        final int decimalValue1 = hexToDecimal(hexValue1);
        final int decimalValue2 = hexToDecimal(hexValue2);

        final int sum = decimalValue1 + decimalValue2;
        final String hexEquivalentSum = decimalToHex(sum);
        return hexEquivalentSum;
    }

    /**
     * Computes subtraction of given hexadecimal values.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return Subtraction equivalent of hexValue1 and hexValue2 i.e. hexValue1 - hexValue2.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public String subtract(String hexValue1, String hexValue2) throws Exception {
        final int decimalValue1 = hexToDecimal(hexValue1);
        final int decimalValue2 = hexToDecimal(hexValue2);
        
        final int sub = decimalValue1 - decimalValue2;
        
        /* converting into absolute value because 
           decimalToHex does not take negative values. */
        final int difference = Math.abs(sub);
        String hexEquivalentSub = decimalToHex(difference);
        
        /* if sub is negative then append negative sign "-" before result. */
        if (sub < 0) {
            hexEquivalentSub = '-' + hexEquivalentSub;
        }
        
        return hexEquivalentSub;
    }
    
    /**
     * Computes multiplication of given hexadecimal values.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return Multiplication equivalent of hexValue1 and hexValue2 i.e. hexValue1 * hexValue2.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public String multiply(String hexValue1, String hexValue2) throws Exception {
        final int decimalValue1 = hexToDecimal(hexValue1);
        final int decimalValue2 = hexToDecimal(hexValue2);
        
        final int mul = decimalValue1 * decimalValue2;
        final String hexEquivalentMul = decimalToHex(mul);
        return hexEquivalentMul;
    }
    
    /**
     * Performs division on given hexadecimal values.
     * @param hexValue1 : Dividend, which is to be divided.
     * @param hexValue2 : Divisor, by which dividend will be divided.
     * @return Integer value obtained after dividing hexValue1 by hexValue2 
     *         if hexValue1 and hexValue2 is non-zero.
     *         "infinity" if hexValue2 is 0.
     *         "undefined" if hexValue1 and hexValue2 both are 0.  
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public String divide(String hexValue1, String hexValue2) throws Exception {
        final int decimalValue1 = hexToDecimal(hexValue1);
        final int decimalValue2 = hexToDecimal(hexValue2);
        
        if ((decimalValue1 == 0) && (decimalValue2 == 0)) {
            return "undefined";
        }
        if (decimalValue2 == 0) {
            return "infinity";
        }
        final int div = decimalValue1 / decimalValue2;
        final String hexEquivalentDiv = decimalToHex(div);
        return hexEquivalentDiv;
    }
    
    /**
     * Compares whether given hexadecimal values are equal or not.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return true if hexValue1 and hexValue2 are same, else false.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public boolean isEqual(String hexValue1, String hexValue2) throws Exception {
        
        if ((!isHexaDecimal(hexValue1)) || (!isHexaDecimal(hexValue2))) {
            throw new Exception("Only positive hexadecimal values are allowed.");
        }
        
        hexValue1 = removeLeadingZeros(hexValue1);
        hexValue2 = removeLeadingZeros(hexValue2);
        
        int lengthOfValue1 = hexValue1.length();
        int lengthOfValue2 = hexValue2.length();
        boolean result = true;
        
        if (lengthOfValue1 == lengthOfValue2) { 
            
            for (int index = 0; index < lengthOfValue1; index++) {
                if (hexValue1.charAt(index) != hexValue2.charAt(index)) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        
        return result;
        
    }
    
    /**
     * Compares whether first hexadecimal value is greater than the second one.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return true if hexValue1 is greater than hexValue2, else false.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public boolean isGreaterThan(String hexValue1, String hexValue2) throws Exception {
        if ((!isHexaDecimal(hexValue1)) || (!isHexaDecimal(hexValue2))) {
            throw new Exception("Only positive hexadecimal value is allowed.");
        }
        
        hexValue1 = removeLeadingZeros(hexValue1);
        hexValue2 = removeLeadingZeros(hexValue2);
        
        final int lengthOfValue1 = hexValue1.length();
        final int lengthOfValue2 = hexValue2.length();
        boolean result = false;
        
        if (lengthOfValue1 > lengthOfValue2) {
            
            result = true;
            
        } else if (lengthOfValue1 == lengthOfValue2) {
            
            for (int index = 0; index < lengthOfValue1; index++) {
                if (hexValue1.charAt(index) > hexValue2.charAt(index)) {
                    result = true;
                    break;
                }
            }
        } 
        
        return result;
    }
    
    /**
     * Compares if first hexadecimal value is less than the second one.
     * @param hexValue1 : First hexadecimal value.
     * @param hexValue2 : Second hexadecimal value.
     * @return true if hexValue1 is less than hexValue2, else false.
     * @throw if hexValue1 or hexValue2 is invalid.
     */
    public boolean isLessThan(String hexValue1, String hexValue2) throws Exception {
        if ((!isHexaDecimal(hexValue1)) || (!isHexaDecimal(hexValue2))) {
            throw new Exception("Only positive hexadecimal value is allowed.");
        }
        
        hexValue1 = removeLeadingZeros(hexValue1);
        hexValue2 = removeLeadingZeros(hexValue2);
        
        final int lengthOfValue1 = hexValue1.length();
        final int lengthOfValue2 = hexValue2.length();
        boolean result = false;
        
        if (lengthOfValue1 < lengthOfValue2) {
            
            result = true;
            
        } else if (lengthOfValue1 == lengthOfValue2) {
            
            for (int index = 0; index < lengthOfValue1; index++) {
                if (hexValue1.charAt(index) < hexValue2.charAt(index)) {
                    result = true;
                    break;
                }
            }
        } 
        
        return result;
    }
}
