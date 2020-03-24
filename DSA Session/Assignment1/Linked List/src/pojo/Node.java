package pojo;

/**
 * Node represents the node of list.
 * @author Digvijay
 *
 */
public class Node {
    public int item;
    public Node next;
    
    public Node(int item, Node next) {
        this.item = item;
        this.next = next;
    }
}
