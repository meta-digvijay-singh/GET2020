/**
 * Represents Python.
 */
public class Python extends Reptile {
    public Python(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "Hiss";
    }
}