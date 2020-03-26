package polishnotation;

import java.util.HashMap;
import java.util.Map;

import stack.Stack;
import stackimpl.StackImpl;

/**
 * Performs polish notation related operations.
 * @author Digvijay
 *
 */
public class PolishNotation {
    private Map<String, Integer> operators;
    private final int TRUE = 1;
    private final int FALSE = 0;
    
    public PolishNotation() {
        operators = new HashMap<String, Integer>();
        
        // Setting operators and their precedence.
        operators.put("*", 1);
        operators.put("/", 1);
        operators.put("%", 1);
        operators.put("+", 2);
        operators.put("-", 2);
        operators.put("<", 3);
        operators.put(">", 3);
        operators.put("<=", 3);
        operators.put(">=", 3);
        operators.put("==", 4);
        operators.put("!=", 4);
        operators.put("&&", 5);
        operators.put("||", 6);
    }
    
    /**
     * Converts given infix expression into post-fix expression.
     * @param expression : infix expression.
     * @return post-fix expression.
     * @throws Exception
     */
    public int convertInfixToPostfix(String expression) throws Exception {
        Stack stack = new StackImpl();
        expression += " )";
        String[] tokens = expression.split(" ");
        String result = "";
        stack.push("(");
        
        for (int index = 0; index < tokens.length; index++) {
            String currentChar = tokens[index];
            if (currentChar.equals("(")) {
                stack.push(currentChar);
            } else if (currentChar.equals(")")) {
                while (!stack.peek().equals("(")) {
                    result += " " + stack.pop();
                }
                stack.pop();
            } else if (!operators.containsKey(currentChar)) {
                result += " " + currentChar;
            } else if (operators.containsKey(currentChar)) {
                while((!stack.peek().equals("(")) && (operators.get(stack.peek()) <= operators.get(currentChar))) {
                    result += " " + stack.pop();
                }
                stack.push(currentChar);
            } else {
                throw new Exception("Invalid operator found...");
            }
            
            if (stack.isEmpty()) {
                break;
            }
        }
        return evaluateExpression(result.trim());
    }
    
    /**
     * Evaluate the given post-fix expression.
     * @param postfixExpression : post-fix expression.
     * @return result after evaluating the expression.
     */
    public int evaluateExpression(String postfixExpression) {
        postfixExpression += " )";
        String[] tokens = postfixExpression.split(" ");
        Stack stack = new StackImpl();
        
        for (int index = 0; !tokens[index].equals(")"); index++) {
            String currentChar = tokens[index];
            if (!operators.containsKey(currentChar)) {
                stack.push(currentChar);
            } else {
                int firstElement = Integer.parseInt(stack.pop());
                int secondElement = Integer.parseInt(stack.pop());
                String currentResult = evaluate(secondElement, firstElement, currentChar);
                stack.push(currentResult);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * Evaluate the given operands for the given operator.
     * @param firstElement : first operand.
     * @param secondElement : second operand.
     * @param currentChar : operator.
     * @return result after evaluating the expression.
     */
    private String evaluate(int firstElement, int secondElement,
            String currentChar) {
        String result = "";
        int value;
        
        switch (currentChar) {
            case "+":
                result = String.valueOf(firstElement + secondElement);
                break;
            case "-":
                result = String.valueOf(firstElement - secondElement);
                break;
                
            case "/":
                result = String.valueOf(firstElement / secondElement);
                break;
                
            case "*":
                result = String.valueOf(firstElement * secondElement);
                break;
                
            case "%":
                result = String.valueOf(firstElement % secondElement);
                break;
                
            case ">":
                value = (firstElement > secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case "<":
                value = (firstElement < secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case "<=":
                value = (firstElement <= secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case ">=":
                value = (firstElement >= secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case "==":
                value = (firstElement == secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case "!=":
                value = (firstElement != secondElement) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;    
            case "&&":
                value = ((firstElement != 0) && (secondElement != 0)) ? TRUE : FALSE;
                result = String.valueOf(value);
                break;
                
            case "||":
                value = ((firstElement == 0) && (secondElement == 0)) ? FALSE : TRUE;
                result = String.valueOf(value);
                break;
                
            default:
                System.out.println("Operator is invalid.");
        }
        return result;
    }
}
