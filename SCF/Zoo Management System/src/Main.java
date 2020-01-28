import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Gives entire info of the zoo.
     * @param animalPark : zoo object.
     */
    private static void showZooDetails(Zoo animalPark) {
        List<Zone> zones = animalPark.getZones();
        int numberOfZones = zones.size();
        for (int zoneNumber = 0; zoneNumber < numberOfZones; zoneNumber++) {
            System.out.println("\n---------------------------------------Zone[INFO] " + (zoneNumber + 1) + " Started---------------------------------------");
            System.out.println("Zone Number : " + (zoneNumber + 1));
            System.out.println("Zone Name : " + zones.get(zoneNumber).getZoneName());
            System.out.println("Category : " + zones.get(zoneNumber).getAnimalCategory());
            System.out.println("Total Cage Limit : " + zones.get(zoneNumber).getCageLimit());
            System.out.println("Remaining Cage Limit : " + zones.get(zoneNumber).getZoneLimit());
            List<Cage> cages = zones.get(zoneNumber).getCages();
            int numberOfCages = cages.size();
            if (numberOfCages == 0) {
                System.out.println("No Cage Available");
            }
            for (int cageNumber = 0; cageNumber < numberOfCages; cageNumber++) {
                System.out.println("\n=======================================Cage[INFO] " + (cageNumber + 1) + " Started=======================================");
                System.out.println("Cage Number : " + (cageNumber + 1));
                System.out.println("Animal Type Supported : " + cages.get(cageNumber).getAnimalType());
                System.out.println("Total Animal Capacity : " + cages.get(cageNumber).getTotalCapacity());
                System.out.println("Remaining Animal Capacity : " + cages.get(cageNumber).getRemainingCapacity());
                List<Animal> animals = cages.get(cageNumber).getAnimals();
                int numberOfAnimals = animals.size();
                if (numberOfAnimals == 0) {
                    System.out.println("No Animal Available.");
                }
                for (int animalNumber = 0; animalNumber < numberOfAnimals; animalNumber++) {
                    System.out.println("\n***************************************Animal[INFO] " + (animalNumber + 1) + " Started*************************************");
                    System.out.println("Animal Id : " + animals.get(animalNumber).getId());
                    System.out.println("Animal Name : " + animals.get(animalNumber).getName());
                    System.out.println("Animal Age : " + animals.get(animalNumber).getAge());
                    System.out.println("Animal Weight : " + animals.get(animalNumber).getWeight());
                    System.out.println("***************************************Animal[INFO] " + (animalNumber + 1) + " Ended***************************************\n");
                }
                System.out.println("=======================================Cage[INFO] " + (cageNumber + 1) + " Ended=========================================\n");
            }
            System.out.println("---------------------------------------Zone[INFO] " + (zoneNumber + 1) + " Ended-----------------------------------------\n");
        }
        
    }
    
    /**
     * Adds animal to the zoo.
     * @param animalType : type of animal.
     * @param animalPark : zoo object.
     */
    public static void addZooAnimal(String animalType, Zoo animalPark) {
        try {
            animalPark.addZoneAnimal(animalType);
            System.out.println("Animal Added");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Removes animal from the zoo.
     * @param animalType : type of animal.
     * @param name : name of animal.
     * @param animalPark : zoo object.
     */
    public static void removeZooAnimal(String animalType, String name, Zoo animalPark) {
        try {
            animalPark.removeZoneAnimal(animalType, name);
            System.out.println("Animal Removed");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Adds cage to the zone.
     * @param animalType : type of animal.
     * @param capacity : capacity of zone i.e. the number of cages that can be added to the zone.
     * @param animalPark : zoo object.
     */
    public static void addZoneCage(String animalType, int capacity, Zoo animalPark) {
        try {
            animalPark.addCageToZone(animalType, capacity);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Takes user from the string.
     * @return string entered by user.
     */
    private static String getString() {
        return String.valueOf(sc.nextLine());
    }
    
    /**
     * Takes positive value from the user.
     * @return value entered by user.
     */
    private static int getPositiveValueOnly() {
        int value;
        while(true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value <= 0) {
                    throw new ArithmeticException("Enter positive value only");
                }
                return value;
            } catch (ArithmeticException ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            } System.out.println("Enter value again : ");
            
        }
    }
    
    /**
     * Gives manual to the user.
     */
    private static void userManual() {
        Zoo animalPark = new Zoo();
        int choice = 1;
        String animalType;
        int capacity;
        boolean isExit = false;
        String animalName;
        while(true) {
            switch(choice) {
                case 1:
                    System.out.println("Instructions : Press below keys for operations");
                    System.out.println("Animal types you can add : [lion, dog, sparrow, peacock, turtle, python]");
                    System.out.println("1. See Instructions.");
                    System.out.println("2. Zoo Information");
                    System.out.println("3. Add animal");
                    System.out.println("4. Remove Animal");
                    System.out.println("5. Add Cage");
                    System.out.println("6. Exit");
                    break;
                    
                case 2:
                    showZooDetails(animalPark);
                    break;
                
                case 3:
                    System.out.println("Enter animal type : ");
                    animalType = getString();
                    addZooAnimal(animalType, animalPark);
                    break;
                    
                case 4:
                    System.out.println("Enter animal name : ");
                    animalName = getString();
                    System.out.println("Enter animal type : ");
                    animalType = getString();
                    removeZooAnimal(animalType, animalName, animalPark);
                    break;
                    
                case 5:
                    System.out.println("Enter animal type : ");
                    animalType = getString();
                    System.out.println("Enter capacity : ");
                    capacity = getPositiveValueOnly();
                    addZoneCage(animalType, capacity, animalPark);
                    break;
                
                case 6:
                    isExit = true;
                    break;
                    
                default:
                    System.out.println("Choice is invalid.");
            }
            
            if (isExit) {
                break;
            }
            System.out.println("Enter your choice : ");
            choice = getPositiveValueOnly();
        }
    }
    
    public static void main(String[] args) {
        userManual();
    }
}