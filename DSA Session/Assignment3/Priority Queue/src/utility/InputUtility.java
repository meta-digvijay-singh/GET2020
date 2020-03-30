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
    public static int getIntegerOnly() {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (Exception ex) {
                System.out.println("Please enter an integer value : ");
            }
        }
    }
}
