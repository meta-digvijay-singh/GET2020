package pojo;

/**
 * Represents a single element of queue.
 * @author Digvijay
 *
 */
public class Element {
    public int value;
    public int priority;
    
    /**
     * Constructs the element with the given value and its priority.
     * @param value : value of the element.
     * @param priority : priority of the element.
     */
    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}
