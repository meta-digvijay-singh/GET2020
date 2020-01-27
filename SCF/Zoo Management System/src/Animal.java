/**
 * Represents Animal.
 */
public abstract class Animal {
    /* To get unique id for each animal. */
    private static int animalId = 1;
    private int id;
    private String name;
    private int ageInMonths;
    private float weight;
    
    /**
     * Instantiate animal.
     * @param name : name of animal.
     * @param ageInMonths : age of animal in months.
     * @param weight : weight of animal.
     * @throws ArithmeticException : if age of weight is negative or zero.
     */
    public Animal(String name, int ageInMonths, float weight) throws ArithmeticException {
        if ((ageInMonths <= 0) || (weight <= 0)) {
            throw new ArithmeticException("Age and Weight should be greater than 0.");
        }
        this.name = name.toLowerCase();
        this.ageInMonths  = ageInMonths;
        this.weight = weight;
        this.id = animalId;
        animalId++;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return ageInMonths;
    }
    
    public float getWeight() {
        return weight;
    }

    public abstract String getSound();
}
