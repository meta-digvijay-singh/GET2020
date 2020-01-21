package Assignment2;

/**
 * It contains linear search and binary search algorithm.
 */
public class Search {
    
    /**
     * Recursive solution for binary search.
     * @param array : array in which element is searched.
     * @param minIndex : minimum index of array.
     * @param maxIndex : maximum index of array.
     * @param value : value to be searched.
     * @return index of array where array[index] == value. And -1 if value is not found.
     */
    private static int findIndexUsingBinarySearch(int[] array, int minIndex, int maxIndex, int value) {
        if (minIndex >= maxIndex) {
            if (array[minIndex] == value) {
                return minIndex;
            }
            return -1;
        }
        int midIndex = (minIndex + maxIndex) / 2;
        if (array[midIndex] == value) {
            return midIndex;
        } else if (array[midIndex] < value) {
            return findIndexUsingBinarySearch(array, midIndex + 1, maxIndex, value);
        } else {
            return findIndexUsingBinarySearch(array, minIndex, midIndex - 1, value);
        }
    }
    
    /**
     * Recursive solution for linear search.
     * @param array : array in which element is searched.
     * @param startIndex : starting index of array.
     * @param endIndex : last index of array.
     * @param value : value to be searched.
     * @return index of array where array[index] == value. And -1 if value is not found.
     */
    private static int findIndexUsingLinearSearch(int[] array, int startIndex, int endIndex, int value) {
        if (startIndex == endIndex) {
            if (array[startIndex] == value) {
                return startIndex;
            } 
            return -1;
        }
        if (array[startIndex] == value) {
            return startIndex;
        }
        return findIndexUsingLinearSearch(array, startIndex + 1, endIndex, value);
    }
    
    /**
     * linear search to find element.
     * @param array : array in which element is searched.
     * @param value : value to be searched.
     * @return index such that array[index] ==  value. -1 if element is not found.
     * @throws AssertionError if given array is empty.
     */
    public static int linearSearch(int[] array, int value) throws AssertionError {
        int length = array.length;
        assert length != 0 : "Array should not be empty.";
        int startIndex = 0;
        int endIndex = length - 1;
        int result = findIndexUsingLinearSearch(array, startIndex, endIndex, value);
        return result;
    }
    
    /**
     * binary search to find element.
     * @param array : array in which element is searched.
     * 				  It requires array to be sorted.
     * @param value : value to be searched.
     * @return index such that array[index] ==  value. -1 if element is not found.
     * @throws AssertionError if array is empty.
     */
    public static int binarySearch(int[] array, int value) throws AssertionError {
        int length = array.length;
        assert length != 0 : "Array should not be empty";
        int minIndex = 0;
        int maxIndex = length - 1;
        int result = findIndexUsingBinarySearch(array, minIndex, maxIndex, value);
        return result;
        
    }
}