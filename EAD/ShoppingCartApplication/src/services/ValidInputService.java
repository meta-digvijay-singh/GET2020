package services;

import java.util.Scanner;

public class ValidInputService {

    public static int getIntegerValueOnly(Scanner sc) {
        int quantity;
        while (true) {
            try {
                quantity = Integer.parseInt(sc.nextLine());
                if (quantity <= 0) {
                    throw new ArithmeticException();
                }
                return quantity;
            } catch (Exception ex) {
                System.out.println("Only positive integer values are allowed.");
                System.out.println("Enter value again : ");
            }
        }
    }

}
