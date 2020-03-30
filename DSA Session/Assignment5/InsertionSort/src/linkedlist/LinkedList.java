package linkedlist;

import pojo.Employee;
import pojo.List;
import pojo.Node;

/**
 * Represents doubly linked list.
 * @author Digvijay
 *
 */
public class LinkedList implements List {
    private Node head;
    private int length;
    
    /**
     * Creates the linked list with head as null and length as 0.
     */
    public LinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    @Override
    public void add(Employee employee) throws Exception {
        if (head == null) {
            head = new Node(null, employee, null);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                if (currentNode.employee.id == employee.id) {
                    throw new Exception(DUPLICATE_ID_EXCEPTION);
                }
                currentNode = currentNode.next;
            }
            if (currentNode.employee.id == employee.id) {
                throw new Exception(DUPLICATE_ID_EXCEPTION);
            }
            currentNode.next = new Node(currentNode, employee, null);
        }
        length++;
    }

    @Override
    public Employee remove(int id) throws Exception {
        if (head == null) {
            throw new Exception(LIST_EMPTY_EXCEPTION);
        } 
        Node currentNode = head;
        Node previousNode = null;
        Employee deletedEmployee = null;
        while (currentNode != null) {
            if (currentNode.employee.id == id) {
                if (previousNode == null) {
                    head = null;
                } else {
                    previousNode.next = currentNode.next;
                    if (currentNode.next != null) {
                        currentNode.next.previous = previousNode;
                    }
                }
                deletedEmployee = currentNode.employee;
                length--;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (deletedEmployee == null) {
            throw new Exception(ID_NOT_FOUND_EXCEPTION);
        }
        return deletedEmployee;
    }
    
    /**
     * Swap the employees present in the given nodes.
     * @param previousNode : previousNode
     * @param currentNode : currentNode.
     */
    private void swap(Node previousNode, Node currentNode) {
        Employee tempEmployee = currentNode.employee;
        currentNode.employee = previousNode.employee;
        previousNode.employee = tempEmployee;
    }

    @Override
    public void sort() {
        Node markerNode = head;
        while (markerNode != null) {
            Node currentNode = markerNode;
            Node previousNode = currentNode.previous;
            while (currentNode != head) {
                if (currentNode.employee.salary > previousNode.employee.salary) {
                    swap(previousNode, currentNode);
                } else if (currentNode.employee.salary == previousNode.employee.salary) {
                    if (currentNode.employee.age < previousNode.employee.age) {
                        swap(previousNode, currentNode);
                    }
                }
                currentNode = previousNode;
                previousNode = currentNode.previous;
            }
            markerNode = markerNode.next;
        }
    }

    @Override
    public void traverse() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.employee);
            currentNode = currentNode.next;
        }
    }

    @Override
    public int getLength() {
        return length;
    }

}
