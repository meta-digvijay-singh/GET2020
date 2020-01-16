package Assignment3;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    
    /**
     * Get positive integer value from user.
     * @return value entered by user.
     */
    public static int getIntegerValue() {
        
        int value = -1;
        
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    throw new ArithmeticException("Value can't be negative.");
                }
                return value;
            } catch (ArithmeticException ex) {
                
                System.out.println(ex.getMessage());
                System.out.println("Again enter value : ");
            
            } catch (NumberFormatException ex) {
                
                System.out.println("Value can't be negative.");
                System.out.println("Again enter value : ");
  
            }
        }
    }
    
    /**
     * Get positive real number from user.
     * @return value entered by user.
     */
    public static double getRealValue() {
        
        double value = -1.0;
        
        while (true) {
            try {
                value = Double.parseDouble(sc.nextLine());
                if (value < 0) {
                    throw new ArithmeticException("Value can't be negative.");
                }
                return value;
            } catch (ArithmeticException ex) {
                
                System.out.println(ex.getMessage());
                System.out.println("Again enter value : ");
            
            } catch (NumberFormatException ex) {
                
                System.out.println("Value can't be negative.");
                System.out.println("Again enter value : ");
  
            }
        }
    }
    
    /**
     * Gives instructions to user to perform operations.
     */
    public static void userManual() {
        
        int choice = 1;
        boolean isExit = false;
        Area query = new Area();
        
        while (true) {
            try {
                
                double width;
                double height;
                double radius;
                
                switch (choice) {
                
                    case 1:
                        System.out.println("***************Welcome to Area Calculator***************");
                        System.out.println("Press below keys to perform operation");
                        System.out.println("1. See instuctions again");
                        System.out.println("2. Calculate area of right angle triangle");
                        System.out.println("3. Calculate area of rectangle");
                        System.out.println("4. Calculate area of square");
                        System.out.println("5. Calculate area of circle");
                        System.out.println("6. Exit");
                        break;
                        
                    case 2:
                        System.out.println("Enter width of triangle : ");
                        width = getRealValue();
                        System.out.println("Enter height of triangle : ");
                        height = getRealValue();
                        System.out.println("Area of triangle : " + query.areaOfTriangle(width, height));
                        break;
                       
                    case 3:
                        System.out.println("Enter width of rectangle : ");
                        width = getRealValue();
                        System.out.println("Enter height of rectangle : ");
                        height = getRealValue();
                        System.out.println("Area of rectangle : " + query.areaOfRectangle(width, height));
                        break;
                    
                    case 4:
                        System.out.println("Enter width of square : ");
                        width = getRealValue();
                        System.out.println("Area of square : " + query.areaOfSquare(width));
                        break;
                    
                    case 5:
                        System.out.println("Enter radius of circle : ");
                        radius = getRealValue();
                        System.out.println("Area of triangle : " + query.areaOfCircle(radius));
                        break;
                        
                    case 6:
                        isExit = true;
                        break;
                    
                    default:
                        System.out.println("Choice is invalid.");
                }
                if (isExit) {
                    System.out.println("Thanks for using our tool :)");
                    break;
                }
                System.out.println("Enter the choice : ");
                choice = getIntegerValue();
                
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Combines helper methods to provide the complete functionality.
     * @param args : command line arguments.
     */
    public static void main(String args[]) {
        userManual();
    }
}
