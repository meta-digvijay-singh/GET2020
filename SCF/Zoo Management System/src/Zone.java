import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * Represents Zone of Zoo.
 */
public class Zone {
    private String zoneName;
    private String animalCategory;
    private int cageLimit;
    private List<Cage> cages;
    private boolean hasPark;
    private boolean hasCanteen;
    
    /**
     * Instantiate zone of zoo.
     * @param zoneName : name of zone.
     * @param animalCategory : category of zone.
     * @param cageLimit : total number of cages that can be added to the zone.
     * @param hasPark : Specifies whether zone has park or not.
     * @param hasCanteen : Specifies whether zone has canteen or not.
     * @throws ArithmeticException : if cage limit is negative or zero.
     */
    public Zone(String zoneName, String animalCategory, int cageLimit, boolean hasPark, boolean hasCanteen) 
    throws ArithmeticException {
        if (cageLimit <= 0) {
            throw new ArithmeticException("Cage limit should be greater than zero.");
        }
        this.zoneName = zoneName.toLowerCase();
        this.animalCategory = animalCategory.toLowerCase();
        this.cageLimit = cageLimit;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        cages = new ArrayList<Cage>();
    }
    
    /**
     * Gives zone name.
     * @return zone of name.
     */
    public String getZoneName() {
        return zoneName;
    }
    
    /**
     * Gives category supported by zone.
     * @return category of animal.
     */
    public String getAnimalCategory() {
        return animalCategory;
    }
    
    /**
     * Gives total limit of cages that can be added to the zone.
     * @return limit of cages that can be added to the zone.
     */
    public int getCageLimit() {
        return cageLimit;
    }
    
    /**
     * Gives information whether zone has park or not.
     * @return true if zone has park, else false.
     */
    public boolean parkInfo() {
        return hasPark;
    }
    
    /**
     * Gives information whether zone has canteen or not.
     * @return true if zone has canteen, else false.
     */
    public boolean canteenInfo() {
        return hasCanteen;
    }
    
    /**
     * Gives the number of remaining cages that can be added to the zone.
     * @return the limit of cages that can be added to the zone.
     */
    public int getZoneLimit() {
        int numberOfCages = cages.size();
        return cageLimit - numberOfCages;
    }
    
    /**
     * Adds animal to appropriate cage.
     * @param type : type of animal.
     * @throws Exception if zone does not have any cage.
     */
    public void addAnimalToCage(String type) throws Exception {
        if (cages.size() == 0) {
            throw new Exception("Zone does not have any cage. Consider adding cage to the zone.");
        }
        boolean hasAdded = false;
        type = type.toLowerCase();
        
        /* Searches for the appropriate. */
        for (Cage cage : cages) {
            String animalType = cage.getAnimalType();
            int remainingCapacity = cage.getRemainingCapacity();
            if ((Objects.equals(animalType, type)) && (remainingCapacity != 0)) {
                cage.addAnimal(AnimalFactory.createAnimal(type));
                hasAdded = true;
                break;
            }
        }
        if (!hasAdded) {
            throw new Exception("No cage available for " + type);
        }
    }
    
    /**
     * Remove animal from cage.
     * @param name : name of the animal.
     * @param type : type of the animal.
     * @throws Exception : if there is no cage in the zone or if type is mismatched.
     */
    public void removeAnimalFromCage(String name, String type) throws Exception {
        if (cages.size() == 0) {
            throw new Exception("Zone does not have any cage. Consider adding cage to the zone.");
        }
        boolean hasRemoved = false;
        type = type.toLowerCase();
        for (Cage cage : cages) {
            String animalType = cage.getAnimalType();
            if (type.equals(animalType)) {
                cage.removeAnimal(name);
                hasRemoved = true;
                break;
            }
        }
        if (!hasRemoved) {
            throw new Exception("No animal available of type + " + type);
        }
        
    }
    
    /**
     * Adds cage to the zone.
     * @param cage : cage to be added.
     * @throws Exception : if cage is null or cage limit exceeded.
     */
    public void addCage(Cage cage) throws Exception {
        if (cage == null) {
            throw new Exception("Cage cannot be null.");
        }
        if (getZoneLimit() == 0) {
            throw new Exception("Cage limit exceeded.");
        }
        cages.add(cage);
    }
    
    /**
     * Gives list of cages.
     * @return list of cages.
     */
    public List<Cage> getCages() {
        return new ArrayList<Cage>(cages);
    }
    
}