package pojo;

/**
 * Represents a node.
 * @author Digvijay
 *
 */
public class Node {
    public String item;
    public Node next;
    
    public Node(String item, Node next) {
        this.item = item;
        this.next = next;
    }
}
