package quicksort;

import java.util.List;

import pojo.Employee;

public class QuickSort {
    
    /**
     * Swaps the values at the given indexes.
     * @param firstEmployeeIndex : first index.
     * @param secondEmployeeIndex : second index.
     * @param employees : list of employees.
     */
    private void swap(int firstEmployeeIndex, int secondEmployeeIndex, List<Employee> employees) {
        Employee tempEmployee = employees.get(firstEmployeeIndex);
        employees.set(firstEmployeeIndex, employees.get(secondEmployeeIndex));
        employees.set(secondEmployeeIndex, tempEmployee);
    }
    
    /**
     * Partition the list based on the pivot element.
     * @param employees : list of employees.
     * @param start : starting index.
     * @param end : pivot index.
     * @return index at which pivot element will be placed.
     */
    private int partition(List<Employee> employees, int start, int end) {
        Employee pivotEmployee = employees.get(end);
        int index = start - 1;
        for (int secondIndex = start; secondIndex <= (end - 1); secondIndex++) {
            Employee currentEmployee = employees.get(secondIndex);
            if (currentEmployee.salary > pivotEmployee.salary) {
                index++;
                swap(index, secondIndex, employees);
            } else if (currentEmployee.salary == pivotEmployee.salary) {
                if (currentEmployee.age < pivotEmployee.age) {
                    index++;
                    swap(index, secondIndex, employees);
                }
            }
        }
        swap(index + 1, end, employees);
        return (index + 1);
    }
    
    /**
     * Sorts the employees list using the quick sort algorithm based on their salary.
     * @param employees : list of employees.
     * @param start : starting index.
     * @param end : end index.
     */
    private void quickSort(List<Employee> employees, int start, int end) {
        if (start < end) {
            int almostMiddleIndex = partition(employees, start, end);
            quickSort(employees, start, almostMiddleIndex - 1);
            quickSort(employees, almostMiddleIndex + 1, end);
        }
    }
    
    /**
     * Sorts the employees using the quick sort algorithm based on their salary.
     * @param employees : list of employees.
     */
    public void quickSort(List<Employee> employees) {
        quickSort(employees, 0, employees.size() - 1);
    }
}
