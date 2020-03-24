package pojo;

/**
 * Variable represents the variable with power of a term in polynomial equation.
 * @author Digvijay
 *
 */
public class Variable {

    private char varibleName;
    private int variablePower;

    /**
     * Creates Variable with it's power.
     * @param variableName is the variable name(a or b or c etc.)
     * @param variablePower is the variable power
     */
    public Variable(char variableName, int variablePower)
    {
        this.variablePower  = variablePower;
        this.varibleName = variableName;
    }

    /**
     * This method returns the name of the variable
     * @return name of the variable
     */
    public char getVaribleName() {
        return varibleName;
    }
    /**
     * This method returns the power of the variable
     * @return power of the variable
     */
    public int getVariablePower() {
        return variablePower;
    }

} 
