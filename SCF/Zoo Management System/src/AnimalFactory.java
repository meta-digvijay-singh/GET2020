import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Creates animal object for the given type of animal
 * Animal type supported :
 * 1. Lion
 * 2. Dog
 * 3. Sparrow
 * 4. Peacock
 * 5. Turtle
 * 6. Python
 */
public class AnimalFactory {
    
    public static Scanner sc = new Scanner(System.in);
    public static List<String> animalNames = new ArrayList<String>(); 
    
    /**
     * Gives name of user entered by user and it should be unique all the time.
     * @param type : type of animal. 
     * @return name of animal.
     */
    public static String getName(String type) {
        String name;
        /* Allow user to enter only unique name. */
        while (true) {
            try {
                System.out.println("Enter name of " + type + " : ");
                name = sc.nextLine();
                name = name.toLowerCase();
                if (animalNames.contains(name)) {
                    throw new Exception("Name already present, It shoud be unique.");
                }
                /* Caching the name. */
                animalNames.add(name);
                return name;
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + " Again ");
            }
        }
    }
    
    /**
     * Gives age of animal entered by user.
     * @param name : name of animal.
     * @return age of animal.
     */
    public static int getAgeInMonths(String name) {
        int age;
        /* allow user to enter only positive age. */
        while (true) {
            try {
                System.out.println("Enter age of " + name + " : ");
                age = Integer.parseInt(sc.nextLine());
                if (age <= 0) {
                    throw new ArithmeticException("Age should be greater than zero.");
                }
                return age;
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage() + " Again ");
            } catch (NumberFormatException ex) {
                System.out.println("Enter positive integer only, Again ");
            }
        }
    }
    
    /**
     * Gives weight of animal entered by user.
     * @param name : name of animal.
     * @return weight of animal.
     */
    public static float getWeight(String name) {
        float weight;
        /* allow user to enter only positive weight. */
        while (true) {
            try {
                System.out.println("Enter weight of " + name + " : ");
                weight = Float.parseFloat(sc.nextLine());
                if (weight <= 0) {
                    throw new ArithmeticException("Weight should be greater than zero.");
                }
                return weight;
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage() + " Again ");
            } catch (NumberFormatException ex) {
                System.out.println("Enter positive value only. Again ");
            }
        }
    }
    
    /**
     * Create animal for given type.
     * @param type : type of animal [lion, dog, sparrow, peacock, turtle, python].
     * @return object of specified type.
     */
    public static Animal createAnimal(String type) {
        type = type.toLowerCase();
        Animal animal;
        String name;
        int ageInMonths;
        float weight;
        
        switch(type) {
            
            case "lion":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Lion(name, ageInMonths, weight);
                break;
            
            case "dog":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Dog(name, ageInMonths, weight);
                break;
            
            case "peacock":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Peacock(name, ageInMonths, weight);
                break;
            
            case "sparrow":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Sparrow(name, ageInMonths, weight);
                break;
            
            case "python":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Python(name, ageInMonths, weight);
                break;
            
            case "turtle":
                name = getName(type);
                ageInMonths = getAgeInMonths(name);
                weight = getWeight(name);
                animal = new Turtle(name, ageInMonths, weight);
                break;
                
            default:
                animal = null;
            
        }
        return animal;
    }
}