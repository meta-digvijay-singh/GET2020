/**
 * Represents Dog.
 */
public class Dog extends Mammal {
    public Dog(String name, int ageInMonths, float weight) throws ArithmeticException {
        super(name, ageInMonths, weight);
    }
    
    public String getSound() {
        return "woof";
    }
}