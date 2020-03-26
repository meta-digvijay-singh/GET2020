package main;

import polishnotation.PolishNotation;

public class Runner {

    public static void main(String[] args) {
        PolishNotation solution = new PolishNotation();
        try {
            System.out.println(solution.evaluateExpression("2 > ( 6 > 5 ) >= 0"));
            System.out.println(solution.evaluateExpression("2 && 0 || 0"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
