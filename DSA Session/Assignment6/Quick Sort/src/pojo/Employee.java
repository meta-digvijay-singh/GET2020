package pojo;

/**
 * Represents Employee
 * @author Digvijay
 *
 */
public class Employee {
    public int id;
    public String name;
    public int age;
    public double salary;
    
    /**
     * Constructs employee with the given id, name, age, salary.
     * @param id : id of employee
     * @param name : name of employee
     * @param age : age of employee
     * @param salary : salary of employee
     */
    public Employee(int id, String name, int age, double salary) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age
                + ", salary=" + salary + "]";
    }
}
