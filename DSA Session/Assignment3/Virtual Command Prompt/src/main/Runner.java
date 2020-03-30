package main;

import virtualcommanprompt.VirtualCommandPrompt;
import java.util.Scanner;

/**
 * Runner to start the application.
 * @author Digvijay
 *
 */
public class Runner {
    private static VirtualCommandPrompt vcp = new VirtualCommandPrompt();
    private static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        String command;
        while(true) {
            command = sc.nextLine();
            vcp.executeCommand(command);
        }
    }
}
