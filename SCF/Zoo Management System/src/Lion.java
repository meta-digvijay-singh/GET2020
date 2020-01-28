/**
 * Represents Lion.
 */
public class Lion extends Mammal {
    public Lion(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "roars";
    }
}