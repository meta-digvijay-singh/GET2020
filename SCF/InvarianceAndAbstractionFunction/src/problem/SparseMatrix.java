package Assignment7;

import java.util.Arrays;

interface ImmutableMatrix {
    public int[][] transpose();
    public boolean symmetric();
}

public final class SparseMatrix implements ImmutableMatrix {

    private final int row[];
    private final int column[];
    private final int value[];
    //matrix dimension
    private final int matrixRowLength;
    private final int matrixColumnLength;
    //number of element in row, column and value array
    private final int countElements;

    /**
     * constructor to reduce the matrix space and and convert matrix to row, column, value array   
     * @param matrix the first {@code int[][]} to convert matrix to row, column, value array      
     * @param sparseMatrixRow the second {@code int} convert matrix to row, column, value array      
     * @param sparseMatrixColumn the third {@code int} convert matrix to row, column, value array   
     */
    public SparseMatrix(int matrix[][], int sparseMatrixRow, int sparseMatrixColumn) {
        int count = 0;
        this.matrixRowLength = sparseMatrixRow;
        this.matrixColumnLength = sparseMatrixColumn;

        this.row = new int[matrixRowLength * matrixColumnLength];
        this.column = new int[matrixRowLength * matrixColumnLength];
        this.value = new int[matrixRowLength * matrixColumnLength];
        for (int i = 0; i < matrixRowLength; i++) {
            for (int j = 0; j < matrixColumnLength; j++) {
                if (matrix[i][j] != 0) {
                    this.row[count] = i;
                    this.column[count] = j;
                    this.value[count] = matrix[i][j];
                    count++;
                }
            }
        }
        this.countElements = count;
    }

    /**
     * transpose of two-dimensional sparse matrixes
     * 
     * @param no parameter            
     * 
     * @return matrix(int[][]) value 
     */
    public int[][] transpose() {
        int matrix[][] = new int[this.matrixColumnLength][this.matrixRowLength];
        for (int[] a : matrix)
            Arrays.fill(a, 0);

        for (int i = 0; i < countElements; i++) {
            matrix[this.column[i]][this.row[i]] = this.value[i];
        }
        return matrix;
    }
    
    /**
     * check symmetric of two-dimensional sparse matrixes
     * 
     * @param no parameter            
     * 
     * @return boolean value 
     */
    public boolean symmetric() {
        int matrix[][] = new int[this.matrixColumnLength][this.matrixRowLength];
        matrix = transpose();

        for (int i = 0; i < countElements; i++) {
            if(matrix[this.row[i]][this.column[i]] != this.value[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * addition of two-dimensional sparse matrixes
     * 
     * @param sparseMarticParameter the first {@code SparseMartic} to perform matrix addition              
     * 
     * @return matrix(int[][]) value 
     */
    public int[][] add(SparseMatrix sparseMarticParameter) {

        assert(this.matrixRowLength == sparseMarticParameter.matrixRowLength ):"Row are not equal";
        assert(this.matrixColumnLength == sparseMarticParameter.matrixColumnLength):
                    "Column are not equal";
        int matrix[][] = new int[this.matrixRowLength][this.matrixColumnLength];
        for (int[] a : matrix)
            Arrays.fill(a, 0);
        int i = 0, j = 0;

        while (i < this.countElements && j < sparseMarticParameter.countElements) {
            if (this.row[i] == sparseMarticParameter.row[j]) {
                if (this.column[i] == sparseMarticParameter.column[j]) {
                    matrix[this.row[i]][this.column[i]] = this.value[i]
                            + sparseMarticParameter.value[j];
                    i++;
                    j++;
                } else if (this.column[i] < sparseMarticParameter.column[j]) {
                    matrix[this.row[i]][this.column[i]] = this.value[i];
                    i++;
                } else {
                    matrix[sparseMarticParameter.row[j]][sparseMarticParameter.column[j]] = sparseMarticParameter.value[j];
                    j++;
                }
            } else if (this.row[i] < sparseMarticParameter.row[j]) {
                matrix[this.row[i]][this.column[i]] = this.value[i];
                i++;
            } else {
                matrix[sparseMarticParameter.row[j]][sparseMarticParameter.column[j]] = sparseMarticParameter.value[j];
                j++;
            }
        }
        return matrix;
    }
    
    /**
     * multiplication of two-dimensional sparse matrixes
     * 
     * @param sparseMarticParameter the first {@code SparseMartic} to perform matrix multiplication              
     * 
     * @return matrix(int[][]) value 
     */
    public int[][] multiply(SparseMatrix sparseMarticParameter){
        int matrix[][] = new int[this.matrixRowLength][sparseMarticParameter.matrixColumnLength];
        for (int[] a : matrix)
            Arrays.fill(a, 0);
        for (int i = 0; i < this.countElements; i++)
            for (int j = 0; j < sparseMarticParameter.countElements; j++)
                if (this.column[i] == sparseMarticParameter.row[j])
                    matrix[this.row[i]][sparseMarticParameter.column[j]] += (this.value[i] * sparseMarticParameter.value[j]);
        return matrix;
    }
}
