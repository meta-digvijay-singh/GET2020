package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a directory in system.
 * @author Digvijay
 *
 */
public class Directory {
    public Directory parentDirectory;
    public String directoryName;
    public Date creationDate;
    public List<Directory> subDirectories;
    
    /**
     * Creates a new Directory with the specified name and the parent directory.
     * @param directoryName : name of directory
     * @param parentDirectory : parent directory
     */
    public Directory(String directoryName, Directory parentDirectory) {
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
        this.creationDate = new Date();
        this.subDirectories = new ArrayList<Directory>();
    }
}
