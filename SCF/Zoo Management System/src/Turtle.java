/**
 * Represents turtle.
 */
public class Turtle extends Reptile {
    public Turtle(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "Chirp";
    }
}