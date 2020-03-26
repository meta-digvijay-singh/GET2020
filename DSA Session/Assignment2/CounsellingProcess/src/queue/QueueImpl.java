package queue;

import pojo.Node;
import pojo.Student;

/**
 * The implementation of Queue.
 * @author Digvijay
 *
 */
public class QueueImpl implements Queue {

    private Node front;
    private Node rear;
    private int length;
    
    public QueueImpl() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    
    @Override
    public void enqueue(Student newStudent) {
        if (rear == null) {
            front = rear = new Node(newStudent, null);
        } else {
            rear.next = new Node(newStudent, null);
            rear = rear.next;
        }
        length++;
    }

    @Override
    public Student dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        Student deletedStudent = front.student;
        front = front.next;
        length--;
        return deletedStudent;
    }

    @Override
    public boolean isEmpty() {
        return (front == null);
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node currentNode = front;
            while (currentNode != rear.next) {
                System.out.println(currentNode.student);
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public Student getFrontStudent() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }
        return front.student;
    }
}
