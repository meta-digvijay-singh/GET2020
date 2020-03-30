package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojo.Directory;

/**
 * Implementation of Directory tree.
 * @author Digvijay
 *
 */
public class DirectoryTreeImpl implements DirectoryTree {
    private Directory rootDirectory;
    private Directory currentDirectory;
    private List<String> currentDirectoryPath;
    
    /**
     * Creates the directory structure.
     * Initially we only have root directory.
     */
    public DirectoryTreeImpl() {
        this.rootDirectory = new Directory(ROOT_DIRECTORY_NAME, null);
        this.currentDirectory = rootDirectory;
        this.currentDirectoryPath = new ArrayList<String>();
        this.currentDirectoryPath.add(ROOT_DIRECTORY_NAME);
    }
    
    /**
     * Checks if a directory exists with the given name.
     * @param directoryName : name of directory.
     * @return index of directory if exists else -1.
     */
    private int getDirectoryIndex(String directoryName) {
        List<Directory> currentSubDirectories = currentDirectory.subDirectories;
        int index = DIRECTORY_UNAVAILABLE;
        for (Directory directory : currentSubDirectories) {
            if (directory.directoryName.equals(directoryName)) {
                index = currentSubDirectories.indexOf(directory);
                break;
            }
        }
        return index;
    }
    
    @Override
    public void makeDirectory(String directoryName) {
        if (getDirectoryIndex(directoryName) == DIRECTORY_UNAVAILABLE) {
            Directory newDirectory = new Directory(directoryName, currentDirectory);
            currentDirectory.subDirectories.add(newDirectory);
        } else {
            System.out.println("Directory already exists.");
        }
    }

    @Override
    public List<String> changeDirectory(String directoryName) {
        int index = getDirectoryIndex(directoryName);
        if (index == DIRECTORY_UNAVAILABLE) {
            System.out.println("Direcroty does not exist.");
        } else {
            currentDirectory = currentDirectory.subDirectories.get(index);
            currentDirectoryPath.add(currentDirectory.directoryName);
        }
        return new ArrayList<String>(currentDirectoryPath);
    }

    @Override
    public List<String> backDirectory() {
        if (currentDirectory.parentDirectory != null) {
            currentDirectory = currentDirectory.parentDirectory;
            currentDirectoryPath.remove(currentDirectoryPath.size() - 1);
        } else {
            System.out.println("You are currently on root directory");
        }
        return new ArrayList<String>(currentDirectoryPath);
    }

    @Override
    public void listDirectories() {
        List<Directory> currentSubDirectories = currentDirectory.subDirectories;
        for (Directory directory : currentSubDirectories) {
            System.out.println(directory.directoryName + ", created on : " + directory.creationDate);
        }
        System.out.println(currentSubDirectories.size() + " directories found.");
    }

    /**
     * Find directory recursively in the present directory.
     * @param directoryName : name of directory.
     * @param presentDirectory : current directory.
     * @param pathToDirectory : path to directory if found.
     */
    private void findDirectoryRecursively(String directoryName, Directory presentDirectory,
                                                        List<List<String>> pathToDirectory) {
        if (presentDirectory.directoryName.equals(directoryName)) {
            List<String> directoryPath = constructDirectoryPath(presentDirectory);
            pathToDirectory.add(directoryPath);
        }
        List<Directory> currentSubDirectories = presentDirectory.subDirectories;
        for (Directory directory : currentSubDirectories) {
            findDirectoryRecursively(directoryName, directory, pathToDirectory);
        }
    }
    
    /**
     * Constructs the directory path from the current working directory 
     * to the given present working directory.
     * @param presentDirectory : directory to which we want the path.
     * @return list of directory names describing the path.
     */
    private List<String> constructDirectoryPath(Directory presentDirectory) {
        Directory tempDirectory = presentDirectory;
        List<String> path = new ArrayList<String>();
        while (!tempDirectory.equals(currentDirectory)) {
            path.add(tempDirectory.directoryName);
            tempDirectory = tempDirectory.parentDirectory;
        }
        path.add(currentDirectory.directoryName);
        Collections.reverse(path);
        return path;
    }

    @Override
    public List<List<String>> findDirectory(String directoryName) {
        List<List<String>> directoryPaths = new ArrayList<List<String>>();
        findDirectoryRecursively(directoryName, currentDirectory, directoryPaths);
        return directoryPaths;
    }

    /**
     * Traverse the entire directory tree.
     * @param presentDirectory : the current working directory.
     */
    private void traverseTree(Directory presentDirectory) {
        List<Directory> currentSubDirectories = presentDirectory.subDirectories; 
        System.out.println("|");
        for (Directory directory : currentSubDirectories) {
            System.out.println("|-" + directory.directoryName);
        }
        System.out.println("--------------END---------------");
        for (Directory directory : currentSubDirectories) {
            traverseTree(directory);
        }
    }
    
    @Override
    public void tree() {
        traverseTree(rootDirectory);
    }

    @Override
    public void exit() {
        rootDirectory = currentDirectory = null;
    }
    
    public List<String> getDirectoryPath() {
        return new ArrayList<String>(currentDirectoryPath);
    }
}
