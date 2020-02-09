package view;

import java.util.Scanner;

import services.ValidInputService;

public class DisplayInputView {
    private static Scanner sc = new Scanner(System.in);
    
    public String getItemName() {
        String itemName;
        System.out.println("Enter item name : ");
        itemName = sc.nextLine();
        return itemName;
    }
    
    public String getItemType() {
        String itemType;
        System.out.println("Enter item type : ");
        itemType = sc.nextLine();
        return itemType;
    }

    public int getItemQuantity() {
        int quantity;
        System.out.println("Enter item quantity : ");
        quantity = ValidInputService.getIntegerValueOnly(sc);
        return quantity;
    }
    
    public int getInstructionNumber() {
        int instNumber;
        System.out.println("Enter instruction number : ");
        instNumber = ValidInputService.getIntegerValueOnly(sc);
        return instNumber;
    }
}
