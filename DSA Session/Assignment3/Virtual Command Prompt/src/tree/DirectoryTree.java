package tree;

import java.util.List;

/**
 * Represents the directory structure.
 * @author Digvijay
 *
 */
public interface DirectoryTree {
    String ROOT_DIRECTORY_NAME = "R:";
    int DIRECTORY_UNAVAILABLE = -1;
    
    /**
     * Makes a new Directory.
     * @param directoryName : name of directory.
     */
    void makeDirectory(String directoryName);
    
    /**
     * Change the directory to downwards.
     * @param directoryName : name of the directory.
     * @return directory path.
     * @throws Exception : if directory does not exist.
     */
    List<String> changeDirectory(String directoryName);
    
    /**
     * Move to the parent directory.
     * @return current directory path.
     */
    List<String> backDirectory();
    
    /**
     * Gives the sub directories name and their creation date.
     * and the number of sub directories present in the current directory.
     */
    void listDirectories();
    
    /**
     * Finds the directory name in the current directory recursively. 
     * @param directoryName : name of the directory.
     * @return list of directory paths to that directory if found.
     */
    List<List<String>> findDirectory(String directoryName);
    
    /**
     * Display the entire directory structure from the root directory.
     */
    void tree();
    
    /**
     * Make the tree ready for Garbage collection.
     */
    void exit();
    
    /**
     * Gives the folder names from root to present working directory.
     * @return list of directories from root to current working directory.
     */
    List<String> getDirectoryPath();
}
