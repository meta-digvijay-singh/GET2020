package Question1;

import java.util.List;

public class Main {

    /**
     * function to get user input
     * @throws Exception if any of the employee's field is invalid.
     */
    private void userInput() throws Exception {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.addEmployee(new Employee(1, "Gaurav", "xyz street"));
        employeeCollection.addEmployee(new Employee(3, "Digvijay", "xyz street"));
        employeeCollection.addEmployee(new Employee(2, "Shashank", "xyz street"));

        System.out.println("sort by id : ");
        List<Employee> sortedOnId = employeeCollection.sortById();
        for (Employee employee : sortedOnId) {
            System.out.println(employee.getEmployeeName());
        }

        System.out.println("sort by name : ");
        List<Employee> sortedOnName = employeeCollection.sortByName();
        for (Employee employee : sortedOnName) {
            System.out.println(employee.getEmployeeName());
        }
    }

    /**
     * Main to run the application.
     * @param args : cmd-line-args.
     */
    public static void main(String[] args) {
        Main mainObject = new Main();
        try {
            mainObject.userInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
