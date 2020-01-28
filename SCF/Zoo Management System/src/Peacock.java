/**
 * Represents Peacock.
 */
public class Peacock extends Bird {
    public Peacock(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "tee-hee";
    }
}