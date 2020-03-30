package main;

import java.util.List;

import pojo.Bowler;
import utility.InputUtility;
import bowlingorder.BowlingOrder;

public class Runner {
    
    /**
     * Finds the order of bowling.
     * @return list of string containing the bowlers name.
     */
    private static List<String> findOrder() {
        BowlingOrder bowlingOrder = new BowlingOrder();
        
        System.out.println("Enter number of bowlers : ");
        int numberOfBowlers = InputUtility.getPositiveIntegerOnly();
        
        System.out.println("Enter number of maximum balls virat is going to play : ");
        int maximumBalls = InputUtility.getPositiveIntegerOnly();
        
        Bowler[] bowlers = new Bowler[numberOfBowlers];
        
        for (int index = 0; index < numberOfBowlers; index++) {
            System.out.println("Enter bowler name : ");
            String name = InputUtility.getString();
            System.out.println("Enter balls assigned to bowler " + name + " : ");
            int balls = InputUtility.getPositiveIntegerOnly();
            bowlers[index] = new Bowler(name, balls);
        }
        
        return bowlingOrder.findBowlingOrder(bowlers, maximumBalls);
    }
    
    /**
     * Main to run the application.
     * @param args : cmd-line-args.
     */
    public static void main(String[] args) {
        List<String> bowlingOrder = findOrder();
        System.out.println("Bowling order : ");
        for (String bowlerName : bowlingOrder) {
            System.out.println(bowlerName);
        }
    }
}
