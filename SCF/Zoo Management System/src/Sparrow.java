/**
 * Represents sparrow of the zoo.
 */
public class Sparrow extends Bird {
    public Sparrow(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "tweet";
    }
}