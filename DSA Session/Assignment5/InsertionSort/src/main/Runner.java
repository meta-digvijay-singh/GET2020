package main;

import linkedlist.LinkedList;
import pojo.Employee;
import pojo.List;
import utility.InputUtility;

public class Runner {
    
    /**
     * Shows instructions to the user.
     */
    private static void showInstructions() {
        System.out.println("Press below keys for operations :-");
        System.out.println("1. Help");
        System.out.println("2. Add employee");
        System.out.println("3. Remove employee");
        System.out.println("4. Traverse list");
        System.out.println("5. Sort employees");
        System.out.println("6. To get the number of employees");
        System.out.println("7. Exit");
    }
    
    /**
     * Adds employee to the list.
     * @param list : list to be used.
     */
    private static void addEmployee(List list) {
        int id;
        String employeeName;
        int age;
        int salary;
        
        System.out.println("Enter employee id : ");
        id = InputUtility.getPositiveIntegerOnly();
        
        System.out.println("Enter employee name : ");
        employeeName = InputUtility.getString();
        
        System.out.println("Enter " + employeeName + "'s age : ");
        age = InputUtility.getPositiveIntegerOnly();
        
        System.out.println("Enter " + employeeName + "'s salary : ");
        salary = InputUtility.getPositiveIntegerOnly();
        
        try {
            list.add(new Employee(id, employeeName, age, salary));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Removes employee from the list.
     * @param list : list to be used.
     */
    private static void removeEmployee(List list) {
        int id;
        
        System.out.println("Enter id : ");
        id = InputUtility.getPositiveIntegerOnly();
        
        try {
            Employee employee = list.remove(id);
            System.out.println("Employee deleted : " + employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sort the list.
     * @param list : list to be used.
     */
    private static void sortList(List list) {
        list.sort();
        System.out.println("List sorted successfully based on salary.");
        list.traverse();
    }
    
    /**
     * Perform various operations.
     */
    private static void performOperations() {
        int option = 1;
        List list = new LinkedList();
        while (true) {
            switch(option) {
                case 1:
                    showInstructions();
                    break;
                    
                case 2:
                    addEmployee(list);
                    break;
                    
                case 3:
                    removeEmployee(list);
                    break;
                    
                case 4:
                    list.traverse();
                    break;
                    
                case 5:
                    sortList(list);
                    break;
                
                case 6:
                    System.out.println("Number of employees are : " + list.getLength());
                    break;
                
                case 7:
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Enter option : ");
            option = InputUtility.getPositiveIntegerOnly();
        }
    }
    
    public static void main(String[] args) {
        performOperations();
    }
}
