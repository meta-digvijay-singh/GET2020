package linkedlist;

import pojo.Node;

public class LinkedList {
    private Node head;
    private int length;
    
    /**
     * Created an empty linked list.
     * initially head is null and length is 0.
     */
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    /**
     * Add Node to the linked list.
     * @param value : value to be added.
     */
    public void addNode(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(value, null);
        }
        length++;
    }
    
    /**
     * Display linked list in readable format.
     */
    public void displayList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.item);
            currentNode = currentNode.next;
            if (currentNode != null) {
                System.out.print(" --> ");
            }
        }
        System.out.println();
    }
    
    /**
     * Gives length of the list.
     * @return
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Gives the node present at specific location.
     * @param count : location or count of the node.
     * @return node present at given count.
     */
    private Node getNode(int count) {
        Node currentNode = null;
        if ((count >= 1) && (count <= length)) {
            currentNode = head;
            int currentCount = 1;
            while (currentCount != count) {
                currentNode = currentNode.next;
                currentCount++;
            }
        }
        return currentNode;
    }
    
    /**
     * Rotate sub linked list by the given steps.
     * @param leftPosition : left position of linked list.
     * @param rightPosition : right position of linked list.
     * @param steps : steps by which linked list should be rotated.
     * @throws ArithmeticException : if leftPosition is greater than rightPosition.
     */
    public void rotateSubList(int leftPosition, int rightPosition, int steps) throws ArithmeticException {
        if (leftPosition > rightPosition) {
            throw new ArithmeticException("left position should be less than right position");
        }
        
        if ((leftPosition >= 1) && (leftPosition < length) && (rightPosition <= length)) {
            int nodesInSubList = rightPosition - (leftPosition - 1);
            if (steps > nodesInSubList) {
                steps = steps % nodesInSubList;
            }
            
            // This converts the problem into left shifting of list.
            steps = nodesInSubList - steps;
            
            Node previousOfLeft = (leftPosition == 1) ? null : getNode(leftPosition - 1);
            Node leftNode = (previousOfLeft == null) ? head : previousOfLeft.next;
            Node rightNode = getNode(rightPosition);
            Node kthNode = getNode((leftPosition - 1) + steps);
            Node nextOfKthNode = kthNode.next;
            
            kthNode.next = rightNode.next;
            rightNode.next = leftNode;
            if ( previousOfLeft == null ) {
                head = nextOfKthNode;
            } else {
                previousOfLeft.next = nextOfKthNode;
            }
        }
    }
    
    /**
     * Detects loop in a linked list.
     * @return true if loop found else false.
     */
    public boolean detectLoop() {
        Node fastPointer = head;
        Node slowPointer = head;
        while ((slowPointer != null) && (fastPointer != null) &&  (fastPointer.next != null)) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * create loop in a linked list.
     * @param nodeNumber : node to which last node will point to create loop.
     */
    public void createLoop(int nodeNumber) {
        if ((nodeNumber >= 1) && (nodeNumber <= length)) {
            Node lastNode = getNode(length);
            Node pointingNode = getNode(nodeNumber);
            lastNode.next = pointingNode;
        }
    }
}
