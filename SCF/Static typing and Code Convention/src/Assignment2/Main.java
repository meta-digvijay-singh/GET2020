package Assignment2;
import java.util.Scanner;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    
    /**
     * Allows user to enter only Non-negative integer.
     * @return value entered by user.
     */
    private static int getNonNegativeIntegerOnly() {
        int value = -1;
        
        /* Does not allow user to enter negative value or any other invalid value. */
        while (value < 0) {
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                System.out.println("Only Non negative integer values are allowed.");
                System.out.print("Again enter non negative value : ");
            }
        
        }
        return value;
    }
    
    /**
     * Takes the number of processes from user.
     * @return value entered by user.
     */
    private static int getNumOfProcess() {
        int numOfProcess = getNonNegativeIntegerOnly();
        
        while (numOfProcess == 0) {
            System.out.println("Number of processes can't be zero : ");
            System.out.println("Again enter number of processes : ");
            numOfProcess = getNonNegativeIntegerOnly();
        }
        
        return numOfProcess;
    }
    
    private static int[][] getArrivalAndBurstTime(final int numOfProcess) {
        int[][] process = new int[numOfProcess][2];
        int arrivalTimeIndex = 0; // Index at which arrival time of process is present.
        int burstTimeIndex = 1;   // Index at which burst time of process is present.
        
        for (int processId = 0; processId < numOfProcess; processId++) {
            process[processId] = new int[2];
        }
        
        for (int processId = 0; processId < numOfProcess; processId++) {
            int arrivalTime;
            int burstTime = 0;
            
            System.out.println("Enter arrival time for process " + (processId + 1) + " : ");
            arrivalTime = getNonNegativeIntegerOnly();
            process[processId][arrivalTimeIndex] = arrivalTime;
            
            System.out.println("Enter burst time for process " + (processId + 1) + " : ");
            burstTime = getNonNegativeIntegerOnly();
            
            /* Does not allow user to enter burst time as zero. */
            while (burstTime == 0) {
                System.out.println("burst time can't be zero.");
                System.out.println("Enter burst time again : ");
                burstTime = getNonNegativeIntegerOnly();
            }
            process[processId][burstTimeIndex] = burstTime;
        }
        
        return process;
    }
    
    /**
     * Prints the elements present in given array.
     * @param arr : array to be printed.
     * @throws Exception if given array is empty or null.
     */
    private static void show(int[] arr) throws Exception {
        if ((arr == null) || (arr.length == 0)) {
            throw new Exception("Null or empty array are not allowed");
        }
        
        final int length = arr.length;
        
        /* Prints process id and corresponding value. */
        for (int index = 0; index < length; index++) {
            System.out.println("PID " + (index + 1) + " : " + arr[index]);
        }
    }
    
    /**
     * prints process and their position in queue.
     * @param process : processes in any order.
     */
    private static void printQueue(int[][] process) {
        JobSchedular FCFS = new JobSchedular();
        
        try {
            FCFS.sortProcesses(process); //It mutates the array "process".
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        
        final int length = process.length;
        final int arrivalTimeIndex = 0;
        final int burstTimeIndex = 1;
        
        System.out.println();
        
        /* Prints processes in queue in sorted order. */
        System.out.println("**************************Queue Status**************************");
        for (int processId = 0; processId < length; processId++) {
                int arrivalTime = process[processId][arrivalTimeIndex];
                int burstTime = process[processId][burstTimeIndex];
                
                System.out.println("PID " + (processId + 1) 
                                   + " : Arrival Time =  " + arrivalTime 
                                   + ", Burst Time = " + burstTime);
            
        }
        System.out.println("****************************************************************");
        System.out.println();
    }
    /**
     * Performs FCFS Scheduling on given array.
     * @param process : array on which operation will be performed.
     */
    private static void userManual(int[][] process) {
        boolean isExit = false;
        int choice = 1;
        final JobSchedular FCFS = new JobSchedular();
        
        printQueue(process);
        
        while (true) {
            try {
                switch (choice) {
                    case 1:
                        System.out.println("********Welcome to FCFS Shedular********");
                        System.out.println("Press below keys for actions");
                        System.out.println("1. To see instructions again");
                        System.out.println("2. To get completion time of each process");
                        System.out.println("3. To get waiting time of each process");
                        System.out.println("4. To get turn around time of each process");
                        System.out.println("5. To get average waiting time");
                        System.out.println("6. To get max waiting time taken by process");
                        System.out.println("7. To Exit");
                        break;
                        
                    case 2:
                        System.out.println("Completion time of processes is ");
                        show(FCFS.getCompletionTime(process));
                        break;
                        
                    case 3:
                        System.out.println("Waiting time of processes is ");
                        show(FCFS.getWaitingTime(process));
                        break;
                        
                    case 4:
                        System.out.println("Turn around time of processes is ");
                        show(FCFS.getTurnAroundTime(process));
                        break;
                    
                    case 5:
                        System.out.println("Average waiting time of processes is " 
                                            + FCFS.getAverageWaitingTime(process));
                        break;
                    
                    case 6:
                        System.out.println("Max waiting time taken by process is "
                                            + FCFS.getMaxWaitingTime(process));
                        break;
                        
                    case 7:
                        isExit = true;
                        break;
                    
                    default:
                        System.out.println("Choice is not valid");
                }   
                
                if (isExit) {
                    System.out.println("Thanks for using our service :)");
                    break;
                }
                
                System.out.println("Enter your choice : ");
                choice = getNonNegativeIntegerOnly();
                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            
        }
    }
    
    /**
     * Combines functionality of all the helper methods.
     * @param args : Command line arguments.
     */
    public static void main(String args[]) {
        int numOfProcess;
        int process[][];
        
        System.out.println("Enter number of processes : ");
        numOfProcess = getNumOfProcess();
        process = getArrivalAndBurstTime(numOfProcess);
        userManual(process);
    }
    
}
