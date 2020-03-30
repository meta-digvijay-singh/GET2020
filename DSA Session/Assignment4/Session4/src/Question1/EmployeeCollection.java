package Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the collection of employees.
 * 
 * @author Digvijay
 *
 */
public class EmployeeCollection {

    private List<Employee> employeeList;

    /**
     * Creates the employees collection.
     */
    public EmployeeCollection() {
        employeeList = new ArrayList<>();
    }

    /**
     * Adds employee to the collection.
     * @param employee : employee to be added.
     * @throws Exception if employee is null or id is not unique.
     */
    public void addEmployee(Employee employee) throws Exception {
        if (employee == null) {
            throw new Exception("Null object can't be added.");
        }

        if (isUnique(employee.getId())) {
            employeeList.add(employee);
        } else {
            throw new Exception("ID is not unique");
        }
    }

    /**
     * Checks whether id is unique.
     * @param id : id of the employee.
     * @return true if id is unique else false.
     */
    private Boolean isUnique(int id) {
        for (Employee iterator : employeeList) {
            if (iterator.getId() == id) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sorts the employees by id.
     * @return sorted employees by id.
     */
    public List<Employee> sortById() {
        List<Employee> sortedList = employeeList;
        Collections.sort(sortedList);
        return employeeList;
    }

    /**
     * Sorts the employees by name.
     * @return sorted employees by name.
     */
    public List<Employee> sortByName() {
        List<Employee> sortedList1 = employeeList;
        Collections.sort(sortedList1, new SortByName());
        return sortedList1;
    }
}
