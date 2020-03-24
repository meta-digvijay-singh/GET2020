package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Term represents the term of polynomial equation.
 * @author Digvijay
 *
 */
public class Term {

    public int termCoefficient;
    public List<Variable> variableList = new ArrayList<>();

    /**
     * Creates new term of polynomial.
     * @param termCoefficient is the term's coefficient
     * @param variableList is list of variables in the term
     */
    public Term(int termCoefficient, List<Variable> variableList)
    {
        this.termCoefficient = termCoefficient;
        this.variableList = variableList;
    }
} 
