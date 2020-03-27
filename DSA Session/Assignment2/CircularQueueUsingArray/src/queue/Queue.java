package queue;

/**
 * Represent queue.
 * @author Digvijay
 *
 */
public interface Queue {
    
    /**
     * Insert element at rear in queue.
     * @param value : value to be inserted.
     */
    void insert(int value);
    
    /**
     * Delete element from the front of queue.
     * @return the deleted element.
     * @throws Exception
     */
    int delete() throws Exception;
    
    /**
     * Checks if queue is empty.
     * @return true if queue is empty else false.
     */
    boolean isEmpty();
    
    /**
     * Checks if queue is full.
     * @return true if queue is full else false.
     */
    boolean isFull();
    
    /**
     * Display all the elements of queue.
     */
    void display();
}
