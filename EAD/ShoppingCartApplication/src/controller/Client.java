package controller;

import view.DisplayInputView;
import view.DisplayOutputView;

public class Client {

    public static void main(String[] args) {
        DisplayOutputView output = new DisplayOutputView();
        DisplayInputView input = new DisplayInputView();
        
        output.welcomeMessage();
        output.showAllProducts();
        output.showInstructions();
        
        while (true) {
            int instructionNumber = input.getInstructionNumber();
            InstructionsController.executeInstruction(instructionNumber, output);
        }
    }
}
