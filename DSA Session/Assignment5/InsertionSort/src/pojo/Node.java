package pojo;

/**
 * Represents node of the linked list.
 * @author Digvijay
 *
 */
public class Node {
    public Node previous;
    public Employee employee;
    public Node next;
    
    public Node(Node previous, Employee employee, Node next) {
        this.previous = previous;
        this.employee = employee;
        this.next = next;
    }
}
