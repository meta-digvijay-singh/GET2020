package pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents student.
 * @author Digvijay
 *
 */
public class Student {
    private String name;
    private List<String> programOptions;
    
    public Student(String name) {
        this.name = name;
        this.programOptions = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getProgramOptions() {
        return programOptions;
    }

    public void setProgramOptions(List<String> programOptions) {
        this.programOptions = programOptions;
    }
    
    @Override
    public String toString() {
        return "Student [name=" + name + ", programOptions=" + programOptions
                + "]";
    }
}
