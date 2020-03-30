package main;

import pojo.Element;
import queueimpl.PriorityQueue;
import utility.InputUtility;

public class Runner {
    
    /**
     * Show instructions to the user.
     */
    private void showInstructions() {
        System.out.println("Press 1 for help.");
        System.out.println("Press 2 for enqueue.");
        System.out.println("Press 3 for dequeue.");
        System.out.println("Press 4 to get all the elements of queue.");
        System.out.println("Press 5 to get the length of the queue.");
        System.out.println("Press 6 for exit.");
    }
    
    /**
     * Adds new element to the queue.
     * @param priorityQueue : priority queue.
     */
    private void addElement(PriorityQueue priorityQueue) {
        int value;
        int priority;
        System.out.println("Enter element value : ");
        value = InputUtility.getIntegerOnly();
        System.out.println("Enter element priority : ");
        priority = InputUtility.getIntegerOnly();
        priorityQueue.enqueue(new Element(value, priority));
    }
    
    /**
     * Removes element from the queue.
     * @param priorityQueue : priority queue.
     */
    private void removeElement(PriorityQueue priorityQueue) {
        try {
            Element elementDeleted = priorityQueue.dequeue();
            System.out.println("Element value : " + elementDeleted.value
                             + " Element priority : " + elementDeleted.priority 
                             + ", deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Show elements of the queue.
     * @param priorityQueue : priority queue.
     */
    private void showElements(PriorityQueue priorityQueue) {
        Element[] elements = priorityQueue.getElements();
        int queueLength = priorityQueue.getLength();
        for (int index = 0; index < queueLength; index++) {
            System.out.println("Element value : " + elements[index].value
                             + " Element priority : " + elements[index].priority);
        }
    }
     
    /**
     * Perform operations on queue.
     * @param length : length of the queue.
     */
    private void performOperations(int length) {
        PriorityQueue priorityQueue = new PriorityQueue(length);
        int option = 1;
        while (true) {
            switch(option) {
                case 1:
                    showInstructions();
                    break;
                
                case 2:
                    addElement(priorityQueue);
                    break;
                
                case 3:
                    removeElement(priorityQueue);
                    break;
                
                case 4:
                    showElements(priorityQueue);
                    break;
                
                case 5:
                    System.out.println("Queue Length : " + priorityQueue.getLength());
                    break;
                
                case 6:
                    System.out.println("Thanks for using our application :)");
                    break;
                
                default:
                    System.out.println("Option in invalid.");
            }
            System.out.println("Enter option : ");
            option = InputUtility.getIntegerOnly();
        }
    }
    
    /**
     * Main to run the application.
     * @param args : cmd-line-arguments.
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the priority queue application :)");
        System.out.println("Enter queue length : ");
        int queueLength = InputUtility.getIntegerOnly();
        Runner runner = new Runner();
        runner.performOperations(queueLength);
    }
}
