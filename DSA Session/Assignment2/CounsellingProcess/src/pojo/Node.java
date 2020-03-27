package pojo;

/**
 * Node represents a single node in a queue.
 * @author Digvijay
 *
 */
public class Node {
    public Student student;
    public Node next;
    
    public Node(Student student, Node next) {
        this.student = student;
        this.next = next;
    }
}
