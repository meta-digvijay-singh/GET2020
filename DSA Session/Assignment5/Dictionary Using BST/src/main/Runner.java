package main;

import java.util.Map;

import org.json.simple.JSONObject;

import utility.InputUtility;
import dictionary.Dictionary;
import dictionary.DictionaryImpl;

public class Runner {
    
    /**
     * Shows instructions to the user.
     */
    private static void showInstructions() {
        System.out.println("Press below keys for operations :-"); 
        System.out.println("1. Help");
        System.out.println("2. add key value to the dictionary");
        System.out.println("3. remove key from the dictionary");
        System.out.println("4. get value for the specified key");
        System.out.println("5. get sorted key values");
        System.out.println("6. get sorted key values within the specified key range [key1, key2]");
        System.out.println("7. Exit");
    }
    
    /**
     * Add key value to the dictionary.
     * @param dictionary : dictionary to be used.
     */
    private static void addKeyValue(Dictionary dictionary) {
        System.out.println("Enter key : ");
        int key = InputUtility.getPositiveIntegerOnly();
        System.out.println("Enter value : ");
        String value = InputUtility.getString();
        dictionary.put(key, value);
    }
    
    /**
     * Deleted the value from the dictionary.
     * @param dictionary : dictionary to be used.
     */
    private static void deleteValue(Dictionary dictionary) {
        System.out.println("Enter key : ");
        int key = InputUtility.getPositiveIntegerOnly();
        try {
            String deletedValue = dictionary.delete(key);
            System.out.println("Value at key : " + key + " is " + deletedValue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Get value at the specified key in the dictionary.
     * @param dictionary : dictionary to be used.
     */
    private static void getValue(Dictionary dictionary) {
        System.out.println("Enter key : ");
        int key = InputUtility.getPositiveIntegerOnly();
        try {
            String value = dictionary.getValue(key);
            System.out.println("value at key : " + key + " is " + value);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Get sorted order of dictionary based on keys.
     * @param dictionary : dictionary to be used.
     */
    private static void getSortedDictionary(Dictionary dictionary) {
        Map<Integer, String> sortedDictionary = dictionary.sort();
        for (int key : sortedDictionary.keySet()) {
            System.out.println("key : " + key + ", value : " + sortedDictionary.get(key));
        }
    }
    
    /**
     * Get sorted order of dictionary based on keys within the given range [key1, key2].
     * @param dictionaryGet sorted order of dictionary based on keys.
     */
    private static void getSortedDictionaryWithinKeyRange(Dictionary dictionary) {
        System.out.println("Enter key key1 : ");
        int key1 = InputUtility.getPositiveIntegerOnly();
        System.out.println("Enter key key2 : ");
        int key2 = InputUtility.getPositiveIntegerOnly();
        Map<Integer, String> sortedDictionary = dictionary.sort(key1, key2);
        for (int key : sortedDictionary.keySet()) {
            System.out.println("key : " + key + ", value : " + sortedDictionary.get(key));
        }
    }
    
    /**
     * Perform various operations.
     */
    private static void performOperations() {
        int option = 1;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(1, "hello");
        jsonObject.put(2, "hello");
        jsonObject.put(3, "hello");
        jsonObject.put(4, "world");
        Dictionary dictionary = new DictionaryImpl(jsonObject);
        while (true) {
            switch(option) {
                case 1:
                    showInstructions();
                    break;
                    
                case 2:
                    addKeyValue(dictionary);
                    break;
                    
                case 3:
                    deleteValue(dictionary);
                    break;
                    
                case 4:
                    getValue(dictionary);
                    break;
                    
                case 5:
                    getSortedDictionary(dictionary);
                    break;
                    
                case 6:
                    getSortedDictionaryWithinKeyRange(dictionary);
                    break;
                    
                case 7:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Enter option : ");
            option = InputUtility.getPositiveIntegerOnly();
        }
    }
    
    public static void main(String[] args) {
        performOperations();
    }
}
