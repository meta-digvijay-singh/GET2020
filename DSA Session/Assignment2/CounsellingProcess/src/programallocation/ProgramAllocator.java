package programallocation;

import java.util.HashMap;
import java.util.Map;

import pojo.Student;
import queue.Queue;
import fileoperations.FileOperation;

/**
 * Represents the class responsible for allocation related activities.
 * @author Digvijay
 *
 */
public class ProgramAllocator {
    
    // Interacts with file related operation.
    private FileOperation fileOperation;
    
    public ProgramAllocator() {
        fileOperation = new FileOperation();
    }
    
    /**
     * Allocate Program to given students based on their info according to programs info.
     * @param programsInfo : it contains program offered by college and each program's capacity. 
     * @param studentsInfo : it contains students.
     */
    public void allocateProgram(Map<String, Integer> programsInfo, Queue studentsInfo) {
        Map<String, String> finalList = new HashMap<String, String>();
        
        while (!studentsInfo.isEmpty()) {
            try {
                Student frontStudent = studentsInfo.dequeue();
                for (String programOption : frontStudent.getProgramOptions()) {
                    int programCapacity = programsInfo.get(programOption);
                    if (programCapacity != 0) {
                        finalList.put(frontStudent.getName(), programOption);
                        programsInfo.put(programOption, programCapacity - 1);
                        break;
                    }
                }
                fileOperation.writeFinalList(finalList);
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
    }
}
