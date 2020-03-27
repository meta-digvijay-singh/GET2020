package main;

import queue.Queue;
import queue.QueueImpl;

/**
 * Runner to start the application.
 * @author Digvijay
 *
 */
public class Runner {
    public static void main(String[] args) {
        Queue queue = new QueueImpl(10);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);
        queue.insert(90);
        queue.insert(100);
        try {
            queue.delete();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        queue.display();
        System.out.println();
        queue.insert(99);
        queue.display();
        queue.insert(100);
    }
}
