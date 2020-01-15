package Assignment2;

public class JobSchedular {
    
    /**
     * Sorts the given processes based on arrival time.
     * It Mutates the array.
     * @param process : processes to be sorted.
     * @return sorted array of processes based on arrival time.
     * @throw if given array is null or empty.
     */
    public void sortProcesses(int[][] process) throws Exception {
        if ((process == null) || (process.length == 0)) {
            throw new Exception("Empty or null array is not allowed.");
        }
        final int length = process.length;
        final int arrivalTimeIndex = 0;
        
        for (int freezedElement = 0; freezedElement < length - 1; freezedElement++) {
             for (int processId = 0; processId < (length - freezedElement - 1); processId++) {
                 int arrivalTimeProcess1 = process[processId][arrivalTimeIndex];
                 int arrivalTimeProcess2 = process[processId + 1][arrivalTimeIndex];
                 
                 if (arrivalTimeProcess1 > arrivalTimeProcess2) {
                     int tempProcess[] = new int[2];
                     tempProcess = process[processId];
                     process[processId] = process[processId + 1];
                     process[processId + 1] = tempProcess;
                 }
             }
        }
    }
    /**
     * find maximum value in given array.
     * @param arr : array to be used.
     * @return maximum value from array.
     * @throw if given array is empty or null.
     */
    public int findMax(int[] arr) throws Exception{
        if ((arr == null) || (arr.length == 0)) {
          throw new Exception("Empty array is not allowed.");
        }
        
        int maxValue = arr[0];
        int length = arr.length;
        
        for (int index = 1; index < length; index++) {
            if (maxValue < arr[index]) {
                maxValue = arr[index];
            }
        }
        return maxValue;
    }
    
    /**
     * Checks if array is null or not.
     * @param array : array to be checked.
     * @return true if array is null, else false.
     */
    public boolean isNull(int array[][]) {
        return array == null;
    }
    
    /**
     * Calculates completion time of each process.
     * @param process : (n x 2) array having arrival time and burst time of each process.
     * @return array consists of completion time of each process.
     * @throw if given array is null or empty.
     */
    public int[] getCompletionTime(int[][] process) throws Exception{
        
        if (isNull(process) || (process.length == 0)) {
            throw new Exception("Empty or null array is not allowed.");
        }
        
        int length = process.length;
        int[] completionTime = new int[length];
        int arrivalTimeIndex = 0; // Index at which arrival time is present in process.
        int burstTimeIndex = 1;   // Index at which burst time is present in process.
        
        
        
        for (int processId = 0; processId < length; processId++) {
            int arrivalTime = process[processId][arrivalTimeIndex];;
            int burstTime = process[processId][burstTimeIndex];;
            
            /* If it is first process then completion time will be arrival time + burst time.*/
            if (processId == 0) {
                completionTime[processId] = arrivalTime + burstTime;
                continue;
            }
            
            int previousProcessCompletionTime = completionTime[processId - 1];
            
            if (previousProcessCompletionTime >= arrivalTime) {
                completionTime[processId] = previousProcessCompletionTime + burstTime;
            } else {
                completionTime[processId] = arrivalTime + burstTime;
            }
        }
        return completionTime;
    }
    
    /**
     * Calculate waiting time of each process.
     * @param process : (n x 2) array having arrival time and burst time of each process.
     * @return array consists of waiting time of each process.
     * @throw if given array is null or empty.
     */
    public int[] getWaitingTime(int[][] process) throws Exception {
        int[] turnAroundTime = getTurnAroundTime(process);
        int length = turnAroundTime.length;
        int[] waitingTime = new int[length];
        int burstTimeIndex = 1;
        
        for (int processId = 0; processId < length; processId++) {
            int burstTime = process[processId][burstTimeIndex];
            waitingTime[processId] = turnAroundTime[processId] - burstTime; 
        }
        return waitingTime;
    }
    
    /**
     * Calculate turn around time of each process.
     * @param process : (n x 2) array having arrival time and burst time of each process.
     * @return array consists of turn around time of each process.
     * @throw if given array is null or empty.
     */
    public int[] getTurnAroundTime(int[][] process) throws Exception {
        int[] completionTime = getCompletionTime(process);
        int length = completionTime.length;
        int[] turnAroundTime = new int[length];
        int arrivalTimeIndex = 0;
        
        for (int processId = 0; processId < length; processId++) {
            int arrivalTime = process[processId][arrivalTimeIndex];
            turnAroundTime[processId] = completionTime[processId] - arrivalTime;
        }
        return turnAroundTime;
    }
    
    /**
     * Computes average waiting time of given processes.
     * @param process : (n x 2) array having arrival time and burst time of each process.
     * @return average waiting time of given processes.
     * @throw if given array is null or empty. 
     */
    public double getAverageWaitingTime(int[][] process) throws Exception {
        int[] waitingTime = getWaitingTime(process);
        int length = waitingTime.length;
        double sum = 0.0;
        double avgWaitingTime;
        
        /* Calculate total sum of waiting time. */
        for (int processId = 0; processId < length; processId++) {
            sum += waitingTime[processId];
        }
        
        avgWaitingTime = sum / length;
        return avgWaitingTime;
    }
    
    /**
     * Finds maximum waiting time from given processes.
     * @param process : n * 2 array having arrival time and burst time of each process.
     * @return maximum waiting time that a process can take.
     * @throw if given array is null or empty. 
     */
    public int getMaxWaitingTime(int[][] process) throws Exception {
        int[] waitingTime = getWaitingTime(process);
        int maxWaitingTime = findMax(waitingTime);
        return maxWaitingTime;
    }
}
