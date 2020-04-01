package main;

import java.util.ArrayList;
import java.util.List;

import pojo.Employee;
import quicksort.QuickSort;

public class Runner {
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "A", 10, 10001));
        employees.add(new Employee(2, "B", 20, 100002));
        employees.add(new Employee(3, "C", 30, 10000004));
        employees.add(new Employee(4, "D", 40, 10000004));
        
        QuickSort sort = new QuickSort();
        sort.quickSort(employees);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
