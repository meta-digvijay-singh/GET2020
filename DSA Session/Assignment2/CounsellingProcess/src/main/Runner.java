package main;

import java.util.Map;

import programallocation.ProgramAllocator;
import queue.Queue;
import fileoperations.FileOperation;

/**
 * Runner class to start the application.
 * @author Digvijay
 *
 */
public class Runner {
    
    public static void main(String[] args) {
        FileOperation fo = new FileOperation();
        
        try {
            Map<String, Integer> programsInfo = fo.getProgramsInfo("programs.xls");
            for (String key : programsInfo.keySet()) {
                System.out.println(programsInfo.get(key));
            }
            Queue studentsInfo = fo.getStudentsInfo("students.xls");
            studentsInfo.displayQueue();
            
            ProgramAllocator pa = new ProgramAllocator();
            pa.allocateProgram(programsInfo, studentsInfo);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
