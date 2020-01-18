import java.util.List;
import java.util.ArrayList;

public class ArrOperation {

    /**
     * find maximum element in the given 2D array.
     * @param array : array in which maximum value is found.
     * @return maximum value in the given array.
     */
    public int findMax(int[][] array) {
        int maxElement = array[0][0];
        int numOfRows = array.length;
        assert numOfRows != 0 : "Array should not be empty";
        
        for (int rowNumber = 0; rowNumber < numOfRows; rowNumber++) {
            int numOfColumns = array[rowNumber].length;
            assert array[rowNumber] != null : "Internal Arrays should be initialized first.";
            for (int columnNumber = 0; columnNumber < numOfColumns; columnNumber++) {
                int currentNumber = array[rowNumber][columnNumber];
                if (currentNumber > maxElement) {
                    maxElement = currentNumber;
                }
            }
        }
        return maxElement;
    }
    
    /**
     * Computes sum of all the elements in the given array.
     * @param array : array whose sum is computed.
     * @return sum of all the elements.
     */
    public int getSumOfElements(int[] array) {
        final int LENGTH = array.length;
        assert LENGTH != 0 : "Array should not be empty.";

        int sumOfElements = 0;
        for (int index = 0; index < LENGTH; index++) {
            sumOfElements += array[index];
        }
        return sumOfElements;
    }

    /**
     * finds if two elements are adjacent by getting their indices of the array as input.
     * @param list : list of indexes where element appears in the array.
     * @return true if elements are adjacent, else false.
     */
    public boolean isAdjacent(List<Integer> list) {
        assert !list.isEmpty() : "List should not be empty.";
        boolean result = false;
        final int LENGTH = list.size();
        int previousValue = list.get(0);
        int currentValue;
        int difference;

        for (int index = 1; index < LENGTH; index++) {
            currentValue = list.get(index);
            difference = currentValue - previousValue;

            if (difference == 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * swap the elements present at given indices in the array;
     * It mutates the array.
     * @param array : array in which elements needs to be swapped.
     * @param firstIndex : first element.
     * @param secondIndex : second element.
     */
    public void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    /**
     * Finds all the indexes where the given value is present.
     * @param array : array in which element is searched.
     * @param value : value to be found.
     * @return : list consists of all the indexes where the element is present.
     */
    public List<Integer> findAllIndex(int[] array, int value) {
        final int LENGTH = array.length;
        assert LENGTH != 0 : "Array should not be empty.";
        List<Integer> indicesOfValue = new ArrayList<Integer>();

        for (int index = 0; index < LENGTH; index++) {
            if (array[index] == value) {
                indicesOfValue.add(index);
            }
        }
        return indicesOfValue;
    }

    /**
     * Count clumps in given array. Clumps is the group of two or more adjacent
     * elements in the array.
     * @param array : the input array. Assume array is not empty.
     * @return count of clumps in given array.
     */
    public int countClumps(int[] array) {
        final int LENGTH = array.length;
        assert (LENGTH != 0) : "Array should not be empty.";

        int lengthOfCurrentClump = 1;
        int countOfCurrentClump = 0;
        int previousNumber;
        int currentNumber;
        final int MINIMUM_ADJACENT_ELEMENTS_REQUIRED = 2;

        for (int index = 1; index < LENGTH; index++) {
            previousNumber = array[index - 1];
            currentNumber = array[index];

            if (currentNumber == previousNumber) {

                lengthOfCurrentClump++;

            } else {

                if (lengthOfCurrentClump >= MINIMUM_ADJACENT_ELEMENTS_REQUIRED) {
                    countOfCurrentClump++;
                }
                lengthOfCurrentClump = 1;
            }
        }

        /* for termination condition. */
        if (lengthOfCurrentClump >= MINIMUM_ADJACENT_ELEMENTS_REQUIRED) {
            countOfCurrentClump++;
        }

        return countOfCurrentClump;
    }

    /**
     * Makes an array such that each X followed by Y in the array.
     * @param array : array consists of X, Y and any other element.
     * @param X : value of X.
     * @param Y : value of Y.
     * @return : a new array such that every X is followed by Y. 
     */
    public int[] fixXY(int[] array, final int X, final int Y) {
        final int LENGTH = array.length;
        assert (LENGTH != 0) : "Array should not be empty.";

        int[] defensiveCopy = new int[LENGTH];

        /* Copy elements of given array to protect it from mutation. */
        System.arraycopy(array, 0, defensiveCopy, 0, LENGTH);

        assert defensiveCopy[LENGTH - 1] != X : "Last element should not be "
                + X;

        List<Integer> allIndexOfX = findAllIndex(defensiveCopy, X); 
        List<Integer> allIndexOfY = findAllIndex(defensiveCopy, Y);
        final int COUNT_OF_X = allIndexOfX.size();
        final int COUNT_OF_Y = allIndexOfY.size();
        int indexOfX;
        int indexOfY;

        assert COUNT_OF_X == COUNT_OF_Y : "Count of " + X
                + " must be equals to " + Y;
        assert !isAdjacent(allIndexOfX) : "two " + X + " can't be adjacent.";

        for (int index = 0; index < COUNT_OF_X; index++) {
            indexOfX = allIndexOfX.get(index);
            indexOfY = allIndexOfY.get(index);

            swap(defensiveCopy, indexOfX + 1, indexOfY);
        }
        return defensiveCopy;
    }

    /**
     * finds the index from where an array can be split into two equal halves 
     * such that sum(firstHalf) == sum(secondHalf)
     * @param array : array which is checked for split.
     * @return index at which array can be split.
     */
    public int splitArray(int[] array) {
        final int LENGTH = array.length;
        assert LENGTH != 0 : "Array should not be empty.";

        int sumOfElements = getSumOfElements(array);
        int scannedElementsSum = 0;
        int firstHalfSum;
        int secondHalfSum;
        int currentElement;
        int splittingIndex = -1;

        for (int index = 0; index < LENGTH; index++) {
            currentElement = array[index];
            firstHalfSum = scannedElementsSum + currentElement;
            secondHalfSum = sumOfElements - currentElement;

            if (firstHalfSum == secondHalfSum) {
                splittingIndex = index + 1;
                break;
            }
            scannedElementsSum = firstHalfSum;
            sumOfElements -= currentElement;
        }
        return splittingIndex;
    }

    /**
     * finds maximum mirror i.e. the count of maximum contiguous elements
     * that appears in the reverse order in the array.
     * @param array : array of which mirror is checked.
     * @return count of maximum mirror.
     */
    public int maxMirror(int[] array) {
        int length = array.length;
        assert length != 0 : "Array should not be empty.";
        
        int size = length + 1;
        final int[][] mirrorLengths = new int[size][size];
        
        for (int rowNumber = 0; rowNumber < size; rowNumber++) {
            mirrorLengths[rowNumber] = new int[size];
        }
        
        int elementOfRow;
        int elementOfColumn;
        int maxMirrorLength;

        for (int rowNumber = 1; rowNumber < size; rowNumber++) {
            elementOfRow = array[rowNumber - 1];
            for (int columnNumber = 1; columnNumber < size; columnNumber++) {
                elementOfColumn = array[length - columnNumber];

                if (elementOfRow == elementOfColumn) {
                    mirrorLengths[rowNumber][columnNumber] = mirrorLengths[rowNumber - 1][columnNumber - 1] + 1;
                } else {
                    mirrorLengths[rowNumber][columnNumber] = 0;
                }
            }
        }
        maxMirrorLength = findMax(mirrorLengths);
        
        return maxMirrorLength;
    }

}

