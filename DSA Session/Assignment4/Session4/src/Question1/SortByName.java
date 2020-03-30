package Question1;

import java.util.Comparator;

/**
 * Comparator to sort the employees by name.
 * @author Digvijay
 *
 */
public class SortByName implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getEmployeeName().compareTo(
                employee2.getEmployeeName());
    }
}
