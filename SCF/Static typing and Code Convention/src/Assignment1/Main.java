package Assignment1;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    
    private static String getString() {
        return sc.nextLine();
    }
    
    private static int getIntegerOnly() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                System.out.print("Enter integer value only : ");
            }
        }
        
    }
    
    private static void userManual() {
        
        final HexCalc cal = new HexCalc();
        int choice = 1;
        boolean isExit = false;
        String hexValue1, hexValue2;
        int decimalValue;
        
        while (true) {
            try {
                switch (choice) {
                    case 1:
                        System.out.println("\n**********Welcome to Hex Calc**********");
                        System.out.println("Press below keys for actions :");
                        System.out.println("1. Again see the instructions");
                        System.out.println("2. To add two hexadecimal numbers");
                        System.out.println("3. To subtract two hexadecimal numbers");
                        System.out.println("4. To multiply two hexadecimal numbers");
                        System.out.println("5. To divide two hexadecimal numbers");
                        System.out.println("6. To convert decimal value to hexadecimal");
                        System.out.println("7. To convert hexadecimal value to decimal");
                        System.out.println("8. To check if two hexadecimal values are equal");
                        System.out.println("9. To compare if one hexadecimal value is less than second");
                        System.out.println("10. To compare if one hexadecimal value is greater than second");
                        System.out.println("11. To Exit\n");
                        break;
                        
                    case 2:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        System.out.println("Addition is : " + cal.add(hexValue1, hexValue2));
                        break;
                        
                    case 3:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        System.out.println("Subtraction is : " + cal.subtract(hexValue1, hexValue2));
                        break;
                        
                    case 4:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        System.out.println("Multiplication is : " + cal.multiply(hexValue1, hexValue2));
                        break;
                        
                    case 5:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        System.out.println("Division is : " + cal.divide(hexValue1, hexValue2));
                        break;
                        
                    case 6:
                        System.out.println("Enter value : ");
                        decimalValue = getIntegerOnly();
                        System.out.println("Hexadecimal Value : " + cal.decimalToHex(decimalValue));
                        break;
                        
                    case 7:
                        System.out.println("Enter value : ");
                        hexValue1 = getString();
                        System.out.println("Decimal Value : " + cal.hexToDecimal(hexValue1));
                        break;
                    
                    case 8:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        if (cal.isEqual(hexValue1, hexValue2)) {
                            System.out.println(hexValue1 + " is equals to " + hexValue2);
                        } else {
                            System.out.println(hexValue1 + " is not equals to " + hexValue2);
                        }
                        break;
                    
                    case 9:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        if (cal.isGreaterThan(hexValue1, hexValue2)) {
                            System.out.println(hexValue1 + " is greater than " + hexValue2);
                        } else {
                            System.out.println(hexValue1 + " is not greater than " + hexValue2);
                        }
                        break;
                        
                    case 10:
                        System.out.println("Enter first value : ");
                        hexValue1 = getString();
                        System.out.println("Enter second value : ");
                        hexValue2 = getString();
                        if (cal.isLessThan(hexValue1, hexValue2)) {
                            System.out.println(hexValue1 + " is less than " + hexValue2);
                        } else {
                            System.out.println(hexValue1 + " is not less than " + hexValue2);
                        }
                        break;
                    
                    case 11:
                        isExit = true;
                        break;
                        
                    default:
                        System.out.println("Enter correct choice...");
                }
                
                if (isExit) {
                    System.out.println("Hope you enjoyed :)");
                    break;
                }
                
                System.out.println("Enter your choice : ");
                choice = getIntegerOnly();
                
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Again");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Again");
            }
        }
    }
    
    public static void main(String args[]) {
        
        userManual();
        
    }
}
