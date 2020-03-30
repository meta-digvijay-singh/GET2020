package virtualcommanprompt;

import java.util.List;

import tree.DirectoryTree;
import tree.DirectoryTreeImpl;

public class VirtualCommandPrompt {
    private DirectoryTree directoryTree;
    
    /**
     * Creates the directory tree with initially 
     * root directory i.e. R:/>
     */
    public VirtualCommandPrompt() {
        this.directoryTree = new DirectoryTreeImpl();
        traverseDirectoryPath(directoryTree.getDirectoryPath());
    }
    
    /**
     * Executes the appropriate command provided by user.
     * @param command : command given by user.
     */
    public void executeCommand(String command) {
        String[] commandAndInput = command.split(" ");
        try {
            switch(commandAndInput[0]) {
                case "mkdir":
                    makeDirectory(commandAndInput[1]);
                    break;
                
                case "cd":
                    changeDirectory(commandAndInput[1]);
                    break;
                
                case "bk":
                    moveUpwards();
                    break;
                
                case "ls":
                    listDirectories();
                    break;
                
                case "find":
                    findDirectory(commandAndInput[1]);
                    break;
                
                case "tree":
                    traverseDirectories();
                    break;
                
                case "exit":
                    removeTreeAndExit();
                    break;
                
                default: 
                    System.out.println("You entered a wrong command");
                    traverseDirectoryPath(directoryTree.getDirectoryPath());
            }
        } catch (Exception ex) {
            System.out.println("Please specify the argument(s).");
            traverseDirectoryPath(directoryTree.getDirectoryPath());
        }
    }

    /**
     * Remove the tree and exit.
     */
    private void removeTreeAndExit() {
        directoryTree.exit();
        System.exit(0);
    }

    /**
     * traverse the directories.
     */
    private void traverseDirectories() {
        directoryTree.tree();
        traverseDirectoryPath(directoryTree.getDirectoryPath());
    }

    /**
     * Finds the directory
     * @param directoryName : name of directory.
     */
    private void findDirectory(String directoryName) {
        List<List<String>> directoryPaths = directoryTree.findDirectory(directoryName);
        for (List<String> directoryPath : directoryPaths) {
            System.out.print(".");
            for (String folderName : directoryPath) {
                System.out.print("/" +folderName);
            }
            System.out.println();
        }
        traverseDirectoryPath(directoryTree.getDirectoryPath());
    }

    /**
     * List all the directories present in the current working directory.
     */
    private void listDirectories() {
        directoryTree.listDirectories();
        traverseDirectoryPath(directoryTree.getDirectoryPath());
    }

    /**
     * Moves one level upward in directory tree.
     */
    private void moveUpwards() {
        traverseDirectoryPath(directoryTree.backDirectory());
    }

    /**
     * Change the directory to the given name.
     * @param directoryName : name of the directory.
     */
    private void changeDirectory(String directoryName) {
        traverseDirectoryPath(directoryTree.changeDirectory(directoryName));
    }

    /**
     * Makes a new directory in the present working directory with the given name.
     * @param directoryName : name of the directory.
     */
    private void makeDirectory(String directoryName) {
        directoryTree.makeDirectory(directoryName);
        traverseDirectoryPath(directoryTree.getDirectoryPath());
    }
    
    /**
     * Traverse the directory path.
     * @param directoryPath : path of the directory.
     */
    private void traverseDirectoryPath(List<String> directoryPath) {
        System.out.println();
        for (String directory : directoryPath) {
            System.out.print(directory + "/");
        }
        System.out.print(">");
    }
}
