package queue;

import pojo.Student;

/**
 * Represents a queue of students.
 * @author Digvijay
 *
 */
public interface Queue {
    /**
     * Insert student to queue.
     */
    void enqueue(Student newStudent);
    
    /**
     * Insert student to queue.
     */
    Student dequeue() throws Exception;
    
    /**
     * Checks whether queue is empty.
     * @return true if queue is empty else false. 
     */
    boolean isEmpty();
    
    /**
     * Gives the number of students in queue.
     * @return length of queue.
     */
    int getLength();
    
    /**
     * Display queue.
     */
    void displayQueue();
    
    /**
     * Gives student who is at the front of queue.
     * @return : student at front.
     * @throws Exception
     */
    Student getFrontStudent() throws Exception;
}
