package pojo;

public interface List {
    
    // Special exception messages.
    String DUPLICATE_ID_EXCEPTION = "Id should be unique.";
    String LIST_EMPTY_EXCEPTION = "List is empty.";
    String ID_NOT_FOUND_EXCEPTION = "Id not found in the list.";
    
    /**
     * Adds the given employee to the list.
     * @param employee : employee to be added.
     * @throws Exception if employee id already exists.
     */
    void add(Employee employee) throws Exception;
    
    /**
     * Removes the employee with the given id.
     * @param id : id of the employee to be deleted.
     * @return deleted employee.
     * @throws Exception if employee with the given id does not exist.
     */
    Employee remove(int id) throws Exception;
    
    /**
     * Sorts the employee based on salary in descending order.
     */
    void sort();
    
    /**
     * Traverse the list.
     */
    void traverse();
    
    /**
     * The number of employees in the list.
     * @return
     */
    int getLength();
}
