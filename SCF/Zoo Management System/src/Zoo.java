import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Represents zoo.
 */
public class Zoo {
    
    /* Initial Zones. */
    private static List<Zone> zones = Arrays.asList(
                new Zone("North-Zone", "mammal", 3, true, false),
                new Zone("South-Zone", "reptile", 3, false, true),
                new Zone("East-Zone", "bird", 3, true, true)
            );
    /* specifies categories that are allowed. */
    private static Map<String, List<String>> categories = new HashMap<String, List<String>>();
    static {
        categories.put("mammal", Arrays.asList("lion", "dog"));
        categories.put("reptile", Arrays.asList("turtle", "python"));
        categories.put("bird", Arrays.asList("sparrow", "peacock"));
    }
    
    /**
     * Gives zone of category.
     * @param type : type of animal.
     * @return category if the type is appropriate, otherwise empty string "".
     */
    private String getZoneCategory(String type) {
        type = type.toLowerCase();
        for (String category : categories.keySet()) {
            if (categories.get(category).contains(type)) {
                return category;
            }
        }
        return "";
    }
    
    /**
     * Search zone for the given category.
     * @param category : category to be searched.
     * @return index of the zone to which category is matched.
     */
    private int searchZone(String category) {
        int numberOfZones = zones.size();
        for (int index = 0; index < numberOfZones; index++) {
            String animalCategory = zones.get(index).getAnimalCategory();
            if (animalCategory.equals(category)) {
                return index;
            }
        }
        return -1;
    }
    
    /**
     * Gives total number of zones.
     * @return
     */
    public int getTotalZones() {
        return zones.size();
    }
    
    /**
     * Adds animal to the zone.
     * @param animalType : type of animal.
     * @throws Exception if zone not found for the given category or zone not available for the given category.
     */
    public void addZoneAnimal(String animalType) throws Exception {
        animalType = animalType.toLowerCase();
        String category = getZoneCategory(animalType);
        if ("".equals(category)) {
            throw new Exception("Invalid animal type " + animalType);
        }
        int zoneNumber = searchZone(category);
        if (zoneNumber == -1) {
            throw new Exception("Zone not available for " + animalType);
        }
        zones.get(zoneNumber).addAnimalToCage(animalType);
    }
    
    /**
     * Remove animal from the zone.
     * @param animalType : type of animal.
     * @param name : name of animal.
     * @throws Exception : if invalid animal type or zone not available for the given category.
     */
    public void removeZoneAnimal(String animalType, String name) throws Exception {
        String category = getZoneCategory(animalType);
        if ("".equals(category)) {
            throw new Exception("Invalid animal type " + animalType);
        }
        int zoneNumber = searchZone(category);
        if (zoneNumber == -1) {
            throw new Exception("Zone not available for " + animalType);
        }
        zones.get(zoneNumber).removeAnimalFromCage(name, animalType);
    }
    
    /**
     * Adds cage to the zone.
     * @param animalType : type of animal.
     * @param totalCapacity : capacity of cage.
     * @throws Exception : if type is invalid.
     */
    public void addCageToZone(String animalType, int totalCapacity) throws Exception {
        animalType = animalType.toLowerCase();
        String zoneCategory = getZoneCategory(animalType);
        if ("".equals(zoneCategory)) {
            throw new Exception("Invalid animal type " + animalType);
        }
        int zonePosition = searchZone(zoneCategory);
        Cage cage = new Cage(animalType, totalCapacity);
        zones.get(zonePosition).addCage(cage);
    }
    
    /**
     * Gives list of zones.
     * @return list of zones.
     */
    public List<Zone> getZones() {
        return new ArrayList<Zone>(zones);
    }
    
}