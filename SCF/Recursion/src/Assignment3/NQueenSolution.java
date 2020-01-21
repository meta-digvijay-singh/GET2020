package Assignment3;

public class NQueenSolution {
    
    /**
     * This holds the position where queen can be placed on board.
     */
    class Position {
        int row, column;
        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    
    /**
     * Checks whether given input is valid or not.
     * @param board : board on which queen is placed.
     * @param startRow : starting row from where we have to start.
     * @param dimensionOfMatrix : dimension of board.
     * @return true, if inputs are valid. else, false.
     */
    private boolean isValidInput(int[][] board, int startRow, int dimensionOfMatrix) {
        if ((startRow != 0) || (dimensionOfMatrix <= 3)) {
            return false;
        }
        int sizeOfBoard = board.length;
        if (dimensionOfMatrix == sizeOfBoard) {
            for (int[] row : board) {
                if (row.length != sizeOfBoard) {
                    return false;
                }
            }
            return true;
         }
         return false;
    }
    
    /**
     * Recursive method to find the position on board where queen can be placed.
     * @param dimensionOfMatrix : dimension of board.
     * @param row : starting row from where we have to start.
     * @param positions : positions where queen can be placed.
     * @return true : if solution exist. otherwise, false.
     */
    private boolean findQueenPosition(int dimensionOfMatrix, int row, Position[] positions) {
        if (row == dimensionOfMatrix) {
            return true;
        }
        
        /* computes solution for each column. */
        for (int column = 0; column < dimensionOfMatrix; column++) {
            boolean isSafe = true;
            
            /* checks if the place chosen is not under attack by any other previous queen. */
            for (int queen = 0; queen < row; queen++) {
                if ((positions[queen].column == column) 
                     || (positions[queen].row - positions[queen].column == row - column) 
                     || (positions[queen].row + positions[queen].column == row + column)) {
                    
                    isSafe = false;
                    break;
                }
            }
            
            /* search a place for next queen, if we found a secure place for current queen. */
            if (isSafe) {
                positions[row] = new Position(row, column);
                if (findQueenPosition(dimensionOfMatrix, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Finds solution of nQueen problem.
     * @param board : n x n board with all entries set to 0.
     * @param startRow : starting row from where we have to find the solution.
     *                   requires startRow = 0.
     * @param dimensionOfMatrix : dimension of board. it should be n if board is n x n.
     * @return true if solution exist,
     *         And place 1 where queen can be placed. otherwise false.
     */
    public boolean nQueen(int[][] board, int startRow, int dimensionOfMatrix) {
        if (!isValidInput(board, startRow, dimensionOfMatrix)) {
            return false;
        }
        Position[] positions = new Position[dimensionOfMatrix];
        boolean hasSolution = findQueenPosition(dimensionOfMatrix, startRow, positions);
        /* update board with positions. */
        if (hasSolution) {
            for (Position p : positions) {
                board[p.row][p.column] = 1;
            }
            return true;
        }
        return false;
        
    }
}