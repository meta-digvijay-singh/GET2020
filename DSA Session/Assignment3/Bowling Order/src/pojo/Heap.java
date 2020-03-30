package pojo;

/**
 * Represents heap consists of bowlers and heap size.
 */
public class Heap {
    public Bowler[] bowlers;
    public int heapSize;
    
    public Heap(Bowler[] bowlers, int heapSize) {
        this.bowlers = bowlers;
        this.heapSize = heapSize;
    }
}
