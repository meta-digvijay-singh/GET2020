package multivariablepolynomial;

import java.util.ArrayList;
import java.util.List;

import pojo.Term;
import pojo.Variable;

public class MultivariablePolynomial {
    
    List<Term> multivariablePolynomial = new ArrayList<>();
    int constantTerm;
    
    public MultivariablePolynomial(int constantTerm, List<Term> termList) {
        this.constantTerm = constantTerm;
        this.multivariablePolynomial = termList;
    }
    
    /**
     * Method to calculate the degree of the multivariate polynomial
     * @return degree of the multivariate polynomial
     */
    public int calculatePolynomialDegree()
    {
        int variablePowerSum;
        int degreeOfPolynomial = 0;
        for(Term term : multivariablePolynomial)
        {
            variablePowerSum = 0;
            for(Variable variable : term.variableList)
            {
                variablePowerSum += variable.getVariablePower();
            }
            if(degreeOfPolynomial < variablePowerSum)
                degreeOfPolynomial = variablePowerSum;
        }
        return degreeOfPolynomial;
    }
    
    /**
     * This method displays the multivariate polynomial equation.
     * @return Multivariate Polynomial equation.
     */
    public String visualiseMultivariablePolynomial()
    {
        String polynomialString = "";
        for(Term term : multivariablePolynomial)
        {
            polynomialString = polynomialString + term.termCoefficient;
            for(Variable variable : term.variableList)
            {
                polynomialString = polynomialString + "*" + variable.getVaribleName() + "^" + variable.getVariablePower();
            }
            if(term != multivariablePolynomial.get(multivariablePolynomial.size() - 1))
                polynomialString = polynomialString + " + ";
        }
        
        return polynomialString;
    }

}
