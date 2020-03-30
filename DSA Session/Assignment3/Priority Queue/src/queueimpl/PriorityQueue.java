package queueimpl;

import pojo.Element;
import queue.Queue;

/**
 * Represents priority queue.
 * @author Digvijay
 *
 */
public class PriorityQueue implements Queue {
    private Element[] elements;
    private int length;
    private int front;
    private int rear;
    
    /**
     * Creates the queue with the specified length.
     * @param length : maximum length of the queue.
     */
    public PriorityQueue(int length) {
        this.elements = new Element[length];
        this.length = 0;
        this.front = -1;
        this.rear = -1;
    }
    
    @Override
    public void enqueue(Element element) {
        boolean isAllocatedSpace = false;
        if (rear == -1) {
            front = rear = 0;
            elements[rear] = element; 
            isAllocatedSpace = true;
        } else {
            int higherPriorityIndex = rear;
            while ((higherPriorityIndex >= front) && (element.priority < elements[higherPriorityIndex].priority)) {
                higherPriorityIndex--;
            }
            for (int index = (higherPriorityIndex + 1); index <= rear; index++) {
                Element tempElement = element;
                element = elements[index];
                elements[index] = tempElement;
            }
            if (rear != (elements.length - 1)) {
                elements[++rear] = element;
                isAllocatedSpace = true;
            }
        }
        if (!isAllocatedSpace) {
            System.out.println("Queue is full.");
        } else {
            length++;
        }
    }

    @Override
    public Element dequeue() throws Exception {
        if (front == -1) {
            throw new Exception("Queue is empty.");
        } else {
            Element element = elements[front];
            for (int index = 0; index < rear; index++) {
                elements[index] = elements[index + 1];
            }
            rear--;
            if (rear == -1) {
                front = -1;
            }
            length--;
            return element;
        }
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Element[] getElements() {
        return elements.clone();
    }
    
}
