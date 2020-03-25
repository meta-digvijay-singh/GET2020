package main;

import java.util.ArrayList;
import java.util.List;

import pojo.Term;
import pojo.Variable;
import linkedlist.LinkedList;
import multivariablepolynomial.MultivariablePolynomial;

public class Runner {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.displayList();
        
        list.rotateSubList(2, 5, 2);
        list.displayList();
        
        
        List<Term> termList = new ArrayList<>();
        List<Variable> variable1 = new ArrayList<>();
        variable1.add(new Variable('x', 2));
        variable1.add(new Variable('y', 1));
        variable1.add(new Variable('z', 1));

        List<Variable> variable2 = new ArrayList<>();
        variable2.add(new Variable('x', 3));
        variable2.add(new Variable('y', 2));

        Term term1 = new Term(4, variable1);
        Term term2 = new Term(3, variable2);

        termList.add(term1);
        termList.add(term2);

        MultivariablePolynomial polynomialObject = new MultivariablePolynomial(5, termList);
        String polynomialString = polynomialObject.visualiseMultivariablePolynomial();
        System.out.println("Multivariable Polynomial = " + polynomialString);
        System.out.println("Degree = " + polynomialObject.calculatePolynomialDegree());
    }
}
