package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class DetectLoopTest {

    /**
     * Test case for loop exist in list.
     */
    @Test
    public void loopExist() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.displayList();
        list.createLoop(2);
        assertTrue(list.detectLoop());
    }
    
    /**
     * test case for loop does not exist in list.
     */
    @Test
    public void loopDoesNotExist() {
        LinkedList list = new LinkedList();
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.displayList();
        assertFalse(list.detectLoop());
    }

}
