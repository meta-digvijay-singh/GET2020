package queue;

import pojo.Element;

/**
 * Represents the queue of elements.
 * @author Digvijay
 *
 */
public interface Queue {
    
    /**
     * Adds element to the queue. 
     * @param element : element to be added.
     */
    void enqueue(Element element);
    
    /**
     * Removes element from the queue.
     * @return removed element.
     * @throws Exception if element is not present in the queue.
     */
    Element dequeue() throws Exception;
    
    /**
     * Gives the number of elements present in the queue.
     * @return length of the queue.
     */
    int getLength();
    
    /**
     * Gives all the elements of the queue.
     * @return elements of the queue.
     */
    Element[] getElements();
}
