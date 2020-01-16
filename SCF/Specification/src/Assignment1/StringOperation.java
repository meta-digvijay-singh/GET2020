package Assignment1;

public class StringOperation {
    /**
     * Compares if given strings are equal or not.
     * @param string1 : First string.
     * @param string2 : Second string.
     * @return 1 if string1 and string2 are equal and have the same case
     *         And neither string1 nor string2 is empty or null, else 0;
     */
    public int isEqual(final String string1, final String  string2) {
        if ((string1 == null) || (string2 == null)) {
            return 0;
        }
        
        final int lengthOfString1 = string1.length();
        final int lengthOfString2 = string2.length();
        int result = 1;
        
        if (lengthOfString1 == lengthOfString2) {
            
            for (int index = 0; index < lengthOfString1; index++) {
                if (string1.charAt(index) != string2.charAt(index)) {
                    result = 0;
                    break;
                }
            }
            
        } else {
            result = 0;
        }
        return result;
    }
    
    /**
     * Reverses the given string.
     * @param value : string to be reversed.
     * @return reversed string if string is not empty and not null, else empty string "".
     */
    public String reverseString(String value) {
        if (value == null) {
            return "";
        }
        
        final int LENGTH = value.length();
        String reversedString = "";
        
        for (int index = 0; index < LENGTH; index++) {
            reversedString = value.charAt(index) + reversedString;
        }
        
        return reversedString;
    }
    
    /**
     * Converts lower case letters to upper case letters and vice-versa.
     * @param value : string to be converted.
     * @return Converted string if string is neither null nor empty, else empty string.
     */
    public String swapCase(String value) {
        if (value == null) {
            return "";
        }
        
        final int ASCII_DIFFERENCE = 32;
        final int LENGTH = value.length();
        char charWithConvertedCase;
        char originalChar;
        String stringWithSwappedCase = "";
        
        for (int index = 0; index < LENGTH; index++) {
            originalChar = value.charAt(index);
            
            if ((originalChar >= 'a') && (originalChar <= 'z')) {
                
                charWithConvertedCase = (char) (originalChar - ASCII_DIFFERENCE);
                stringWithSwappedCase += charWithConvertedCase;
                
            } else if ((originalChar >= 'A') && (originalChar <= 'Z')) {
                
                charWithConvertedCase = (char) (originalChar + ASCII_DIFFERENCE);
                stringWithSwappedCase += charWithConvertedCase;
                
            } else {
                stringWithSwappedCase += originalChar;
            }
        }
        return stringWithSwappedCase;
    }
    
    /**
     * Finds the word which has maximum length in the given string.
     * @param sentence : sentence consists of words.
     * @return word which has maximum length. If two words have same length 
     *         then return word which appears last in the sentence.
     *         If string is empty or null then return empty string "".
     */
    public String getWordWithMaximumLength(String sentence) {
        if (sentence == null) {
            return "";
        }
        
        String longestWord = "";
        String currentWord = "";
        final int LENGTH_OF_SENTENCE = sentence.length();
        int lengthOfCurrentWord = 0;
        int lengthOfLongestWord = 0;
        
        for (int index = 0; index < LENGTH_OF_SENTENCE; index++) {
            char currentCharacter = sentence.charAt(index);
            
            boolean isAlphabet = (((currentCharacter >= 'a') && (currentCharacter <= 'z')) 
                                    || ((currentCharacter >= 'A') && (currentCharacter <= 'Z')));
            
            
            if ((!isAlphabet)) {
                lengthOfLongestWord = longestWord.length();
                if (lengthOfLongestWord <= lengthOfCurrentWord) {
                    longestWord = currentWord;
                }
                currentWord = "";
                lengthOfCurrentWord = 0;
                continue;
            }
            
            currentWord += currentCharacter;
            lengthOfCurrentWord++;
        }
        
        if (lengthOfLongestWord <= lengthOfCurrentWord) {
            longestWord = currentWord;
        }
        
        return longestWord;
    }
}
