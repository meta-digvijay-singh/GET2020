package bowlingorder;

import java.util.ArrayList;
import java.util.List;

import pojo.Bowler;
import pojo.Heap;

/**
 * Perform bowling order related operations.
 * @author Digvijay
 *
 */
public class BowlingOrder {
    // Bowling order of team.
    private List<String> bowlingOrder;
    
    /**
     * Constructs Bowling order.
     */
    public BowlingOrder() {
        this.bowlingOrder = new ArrayList<String>();
    }
    
    /**
     * Perform the max heapify operation on the given heap.
     * @param bowlersHeap : given heap.
     * @param nonLeafNodeNumber : index of the non-leaf node.
     */
    private void maxHeapify(Heap bowlersHeap, int nonLeafNodeNumber) {
        int leftChild = (2 * nonLeafNodeNumber) + 1;
        int rightChild = (2 * nonLeafNodeNumber) + 2;
        
        int largest;
        
        if ((leftChild < bowlersHeap.heapSize) && 
            (bowlersHeap.bowlers[leftChild].ballsLeft > bowlersHeap.bowlers[nonLeafNodeNumber].ballsLeft)) {
            largest = leftChild;
        } else {
            largest = nonLeafNodeNumber;
        }
        
        if ((rightChild < bowlersHeap.heapSize) && 
            (bowlersHeap.bowlers[rightChild].ballsLeft > bowlersHeap.bowlers[largest].ballsLeft)) {
                largest = rightChild;
        }
        
        if (largest != nonLeafNodeNumber) {
            Bowler tempValue = bowlersHeap.bowlers[nonLeafNodeNumber];
            bowlersHeap.bowlers[nonLeafNodeNumber] = bowlersHeap.bowlers[largest];
            bowlersHeap.bowlers[largest] = tempValue;
            maxHeapify(bowlersHeap, largest);
        }
    }
    
    /**
     * Builds heap.
     * @param bowlersHeap : its heap is build.
     */
    private void buildMaxHeap(Heap bowlersHeap) {
        int lastNonLeafNodeNumber = (bowlersHeap.bowlers.length / 2) - 1;
        for (int nonLeafLeafNodeNumber = lastNonLeafNodeNumber; nonLeafLeafNodeNumber >= 0; nonLeafLeafNodeNumber--) {
            maxHeapify(bowlersHeap, nonLeafLeafNodeNumber);
        }
    }
    
    /**
     * Finds the order of bowling.
     * @param bowlers : list of bowlers.
     * @param maxBalls : maximum balls virat is going to play.
     * @return list containing the bowlers name in which they should bowl.
     */
    public List<String> findBowlingOrder(Bowler[] bowlers, int maxBalls) {
        Heap bowlersHeap = new Heap(bowlers.clone(), bowlers.length);
        while (maxBalls != 0) {
            buildMaxHeap(bowlersHeap);
            bowlingOrder.add(bowlersHeap.bowlers[0].name);
            bowlersHeap.bowlers[0].ballsLeft = bowlersHeap.bowlers[0].ballsLeft - 1;
            maxBalls--;
        }
        return bowlingOrder;
    }
}
