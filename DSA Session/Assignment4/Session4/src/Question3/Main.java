package Question3;

import java.io.IOException;

public class Main {

    /**
     * Sample input.
     * @throws NumberFormatException
     * @throws IOException
     */
    private void userInput() throws NumberFormatException, IOException {
        MolecularWeight.getMolecularWeight("CH3COOH");
    }
    
    /**
     * To run the application.
     * @param args : cmd-line-args.
     */
    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.userInput();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
