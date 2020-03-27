package fileoperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import pojo.Student;
import queue.Queue;
import queue.QueueImpl;

public class FileOperation {
    
    private Path currentRelativePath = Paths.get("");
    private String absolutePath = currentRelativePath.toAbsolutePath().toString() + "/data/";
    
    /**
     * Read the file and constructs a map containing program name as key and capacity as value.
     * @param fileName : name of file.
     * @return : programs containing program name as key and its capacity as value.
     * @throws IOException
     */
    public Map<String, Integer> getProgramsInfo(String fileName) throws IOException {
        Map<String, Integer> programs = new HashMap<String, Integer>();
        File excelFile = new File(absolutePath + fileName);
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        
        // Creating workbook
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        
        // Get First Sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        
        // Iterating on rows
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
        
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            
            // Constructing map for programs offered by college and their corresponding capacity
            programs.put(row.getCell(0).toString(), (int) Float.parseFloat(row.getCell(1).toString()));
            
        }
        
        workbook.close();
        fileInputStream.close();
        
        return programs;
    }
    
    /**
     * Get students information and constructs a queue consisting of students.
     * @param fileName : name of file.
     * @return : queue containing students.
     * @throws IOException
     */
    public Queue getStudentsInfo(String fileName) throws IOException {
        Queue students = new QueueImpl();
        
        File excelFile = new File(absolutePath + fileName);
        FileInputStream fileInputStream = new FileInputStream(excelFile);
        
        // Creating workbook
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        
        // Get First Sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        
        // Iterating on rows
        Iterator<Row> rowIterator = sheet.iterator();
        Row row = rowIterator.next();
        
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            
            Student newStudent = new Student(row.getCell(0).toString());
            
            for (int programNumber = 1; programNumber <= 5; programNumber++) {
                Object programName = row.getCell(programNumber);
                if (programName != null) {
                    newStudent.getProgramOptions().add(programName.toString());
                }
            }
            students.enqueue(newStudent);
        }
        
        workbook.close();
        fileInputStream.close();
        
        return students;
    }
    
    /**
     * this writes the final list to the file i.e. allocated programs to students.
     * @param finalList : it contains student name as key and allocated program as value.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeFinalList(Map<String, String> finalList) throws FileNotFoundException, IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
     
        int rowCount = 0;
        
        Row row = sheet.createRow(rowCount);
        
        Cell cell = row.createCell(0);
        cell.setCellValue("Student Name");
        
        cell = row.createCell(1);
        cell.setCellValue("Allocated Program");
        
        for (String studentName : finalList.keySet()) {
            row = sheet.createRow(++rowCount);
            
            cell = row.createCell(0);
            cell.setCellValue(studentName);
         
            cell = row.createCell(1);
            cell.setCellValue(finalList.get(studentName));

        }
        
        FileOutputStream outputStream = new FileOutputStream(absolutePath + "finalList.xls");
        workbook.write(outputStream);
        
        workbook.close();
    }
}
