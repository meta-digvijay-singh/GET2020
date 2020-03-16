package Assignment3;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NQueenSolutionPositiveTestCases {

    private int[][] board;
    private int startRow;
    private int dimensionOfMatrix;
    private boolean expectedOutput;
    
    public NQueenSolutionPositiveTestCases(int[][] board, int startRow, 
                                                          int dimensionOfMatrix, 
                                                          boolean expectedOutput) {
        this.board = board;
        this.startRow = startRow;
        this.dimensionOfMatrix = dimensionOfMatrix;
        this.expectedOutput = expectedOutput;
    }
    
    @Parameters
    public static Collection<Object[]> buildPositiveTests() {
        Object[][] data = new Object[][] {
                { new int[][] {{0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0}}, 0, 5, true}
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void testNQueenSolutionForPositiveCases() {
        NQueenSolution _4X4Board = new NQueenSolution();
        assertEquals(expectedOutput, _4X4Board.nQueen(board, startRow, dimensionOfMatrix));
        for (int[] row : board) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

}
