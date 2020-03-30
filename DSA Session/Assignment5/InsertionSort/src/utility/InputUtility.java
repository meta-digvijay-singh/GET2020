package utility;

import java.util.Scanner;

/**
 * Utility to take inputs from the user.
 * @author Digvijay
 *
 */
public class InputUtility {
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Get integers values only from the user.
     * @return the value provided by user.
     */
    public static int getPositiveIntegerOnly() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value <= 0) {
                    throw new Exception();
                }
                return value;
            } catch (Exception ex) {
                System.out.println("Please enter a positive integer value : ");
            }
        }
    }
    
    /**
     * Get string input from the user.
     * @return string entered by user.
     */
    public static String getString() {
        return sc.nextLine();
    }
}
