import java.util.List;
import java.util.ArrayList;

/**
 * Represent Cage of Zone.
 */
public class Cage {
    private String animalType;
    private int totalCapacity;
    private List<Animal> animals;
    
    /**
     * Instantiates Cage.
     * @param animalType : type of animal that cage will hold.
     * @param totalCapacity : capacity of cage.
     * @throws ArithmeticException : if  totalCapacity is negative or zero.
     */
    public Cage(String animalType, int totalCapacity) throws ArithmeticException {
        if(totalCapacity <= 0) {
            throw new ArithmeticException("Animal Capacity should be greater than zero.");
        }
        this.animalType = animalType.toLowerCase();
        this.totalCapacity = totalCapacity;
        animals = new ArrayList<Animal>();
    }
    
    /**
     * Gives type of animal cage can hold.
     * @return animal type that cage can hold.
     */
    public String getAnimalType() {
        return animalType;
    }
    
    /**
     * Gives number total number of animals cage can hold.
     * @return total number of animals cage can contain.
     */
    public int getTotalCapacity() {
        return totalCapacity;
    }
    
    /**
     * Gives the number of available space.
     * @return the number of available space.
     */
    public int getRemainingCapacity() {
        int animalsPresent = animals.size();
        return totalCapacity - animalsPresent;
    }
    
    /**
     * Adds animal to the cage.
     * @param animal : animal to be added.
     * @throws Exception : if cage is full.
     */
    public void addAnimal(Animal animal) throws Exception {
        int remainingCapacity = getRemainingCapacity();
        if (remainingCapacity == 0) {
            throw new Exception("Cage is full.");
        }
        animals.add(animal);
    }
    
    /**
     * Gives animal position in the cage.
     * @param name : name of animal.
     * @return position of animal.
     */
    private int searchAnimal(String name) {
        int index = -1;
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                index = animals.indexOf(animal);
                break;
            }
        }
        return index;
    }
    
    /**
     * Removes animal from the cage.
     * @param name : name of animal.
     * @throws Exception : if Cage is empty or Animal is not present for the given name.
     */
    public void removeAnimal(String name) throws Exception {
        int numberOfAnimals = animals.size();
        name = name.toLowerCase();
        if (numberOfAnimals == 0) {
            throw new Exception("Cage is empty.");
        }
        int animalPosition = searchAnimal(name);
        if (animalPosition == -1) {
            throw new Exception("Animal named " + name + " is not present.");
        }
        animals.remove(animalPosition);
    }

    /**
     * Gives a copy of animals present in the cage.
     * @return list of animals.
     */
    public List<Animal> getAnimals() {
        return new ArrayList<Animal>(animals);
    }
}

