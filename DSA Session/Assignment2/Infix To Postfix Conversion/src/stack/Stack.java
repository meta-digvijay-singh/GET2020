package stack;

/**
 * Represents stack.
 * @author Digvijay
 *
 */
public interface Stack {
    
    /**
     * Push the value on top of stack.
     * @param value : value to be pushed.
     */
    void push(String value);
    
    /**
     * Pop the element from top of the stack.
     * @return popped element.
     */
    String pop();
    
    /**
     * Gives the element present at top of the stack.
     * @return value at top of stack.
     */
    String peek();
    
    /**
     * Checks whether stack is empty.
     * @return true if stack is empty else false.
     */
    boolean isEmpty();
    
    /**
     * Gives the number of elements of stack.
     * @return length of stack.s
     */
    int getLength();
}
