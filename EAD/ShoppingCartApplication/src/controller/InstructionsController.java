package controller;

import view.DisplayOutputView;

public class InstructionsController {

    public static void executeInstruction(int instructionNumber,
            DisplayOutputView output) {

        switch (instructionNumber) {
        case 1:
            output.addItem();
            break;

        case 2:
            output.deleteItem();
            break;

        case 3:
            output.showCartItems();
            break;

        case 4:
            output.updateQuantity();
            break;

        case 5:
            System.exit(0);
            break;

        case 6:
            output.showInstructions();
            break;
            
        case 7:
            output.showAllProducts();
            break;
            
        default:
            output.invalidInstruction();
            output.showInstructions();
        }
    }
}
