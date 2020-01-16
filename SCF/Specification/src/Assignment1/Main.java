package Assignment1;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    /**
     * Allow user to enter integer only.
     * @return value entered by user.
     */
    private static int getIntegerValueOnly() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Only integer value is allowed.");
                System.out.println("Again enter value : ");
            }
        }
    }
    
    /**
     * Get string from user.
     * @return string entered by user.
     */
    private static String getString() {
        String value = "";
        
        while (true) {
            try {
                value = sc.nextLine();
                if (value.length() == 0) {
                    throw new Exception("Empty string is not allowed.");
                }
                return value;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Again enter string : ");
            }
        }
    }
    
    /**
     * Manual and functionality for user.
     */
    private static void userManual() {
        int choice = 1;
        boolean isExit = false;
        final StringOperation operation = new StringOperation();
        
        while (true) {
            String value1, value2;
            switch (choice) {
                case 1:
                    System.out.println("Press below keys for actions");
                    System.out.println("1. To See Instructions");
                    System.out.println("2. Compare if two strings are equal or not");
                    System.out.println("3. Reverse the given string");
                    System.out.println("4. Swap case of string");
                    System.out.println("5. Find the longest word");
                    System.out.println("6. Exit");
                    break;
                    
                case 2:
                    System.out.println("Enter first string : ");
                    value1 = getString();
                    System.out.println("Enter second string : ");
                    value2 = getString();
                    
                    final int result = operation.isEqual(value1, value2);
                    if (result == 1) {
                        System.out.println("'" + value1 + "' and '" + value2  + "' are equal.");
                    } else {
                        System.out.println("'" + value1 + "' and '" + value2  + "' are not equal.");
                    }
                    
                    break;
                    
                case 3:
                    System.out.println("Enter string : ");
                    value1 = getString();
                    String reversedString = operation.reverseString(value1);
                    
                    if (reversedString.length() != 0) {
                        System.out.println("Reverse of '" + value1 + "' is '" + reversedString + "'");
                    }
                    break;
                
                case 4:
                    System.out.println("Enter string : ");
                    value1 = getString();
                    System.out.println("'" + value1 + "' -> '" + operation.swapCase(value1) + "'");
                    break;
                    
                case 5:
                    System.out.println("Enter sentence : ");
                    value1 = getString();
                    System.out.println("Longest word : " + operation.getWordWithMaximumLength(value1));
                    break;
                            
                case 6:
                    isExit = true;
                    break;
                    
                default:
                    System.out.println("Choice is invalid.");
            }
            if (isExit) {
                System.out.println("Thanks for your time :)");
                break;
            }
            System.out.println("Enter the choice : ");
            choice = getIntegerValueOnly();
        }
    }
    
    public static void main(String[] args) {
        userManual();
    }
}