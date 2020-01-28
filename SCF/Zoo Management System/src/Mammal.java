/**
 * Represents mammal of the zoo.
 */
public abstract class Mammal extends Animal {
    public Mammal(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public boolean hasHairs() {
        return true;
    }
}