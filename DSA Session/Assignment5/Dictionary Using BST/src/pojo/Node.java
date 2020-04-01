package pojo;

/**
 * Represents a node of a tree.
 * @author Digvijay
 *
 */
public class Node {
    public int key;
    public String value;
    public Node leftChild;
    public Node rightChild;
    
    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}
