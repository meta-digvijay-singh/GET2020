package pojo;

/**
 * Represents employee.
 * @author Digvijay
 *
 */
public class Employee {
    public int id;
    public String name;
    public int age;
    public double salary;
    
    public Employee(int id, String name, int age, double salary) {
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
