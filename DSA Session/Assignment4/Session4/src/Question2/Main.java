package Question2;

public class Main {
    
    /**
     * Sample inputs to the count function.
     * @throws Exception if string in invalid.
     */
    private void userInput() throws Exception {
        UniqueCharacter character1 = new UniqueCharacter();
        System.out.println(character1.countUniqueCharacters("hello"));
        System.out.println(character1.countUniqueCharacters("world"));
        UniqueCharacter character2 = new UniqueCharacter();
        System.out.println(character2.countUniqueCharacters("saregama"));
    }
    
    /**
     * To run the application.
     * @param args
     */
    public static void main(String[] args) {
        Main mainObject = new Main();
        try {
            mainObject.userInput();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
