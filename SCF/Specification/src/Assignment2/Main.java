package Assignment2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    
    /**
     * Allow user to enter only positive integer only.
     * @return value entered by user.
     */
    private static int getPositiveIntegerOnly() {
        int value;
        
        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                
                if (value < 0) {
                    throw new ArithmeticException("Only positive integers are allowed");
                } 
                return value;
            } catch (ArithmeticException ex) {
                
                System.out.println(ex.getMessage());
                System.out.println("Again Enter value : ");
            
            } catch (NumberFormatException ex) {
                
                System.out.println("Only positive integers are allowed.");
                System.out.println("Again Enter value : ");
            
            }
        }
    }
    
    /**
     * Get number of students from user.
     * @return number of students entered by user.
     */
    private static int getStudentCount() {
        
        int numberOfStudents = getPositiveIntegerOnly();
        
        while (numberOfStudents == 0) {
            System.out.println("Number of students can't be zero.");
            System.out.println("Again enter value : ");
            numberOfStudents = getPositiveIntegerOnly();
        }
        return numberOfStudents;
    }
    
    /**
     * Get grades for given number of students from user.
     * @param numberOfStudents : total number of students.
     * @return an array having grades of given number of students.
     * @throw if numberOfStudents is equals to zero.
     */
    private static int[] getGradesOfStudents(int numberOfStudents) throws ArithmeticException{
        if (numberOfStudents == 0) {
            throw new ArithmeticException("Number of students can't be zero.");
        }
        
        int[] gradesOfStudents = new int[numberOfStudents];
        
        for (int studentId = 0; studentId < numberOfStudents; studentId++) {
            System.out.println("Enter grade for student " + (studentId + 1) + " : ");
            gradesOfStudents[studentId] = getPositiveIntegerOnly(); 
        }
        return gradesOfStudents;
    }
    
    /**
     * Get grades from user and calculate
     * (1) Average of grades,  
     * (2) Maximum grade, 
     * (3) Minimum grade, 
     * (4) Percentage of students passed.
     */
    public static void main(String args[]) {
        int numberOfStudents;
        
        System.out.println("Enter number of students : ");
        numberOfStudents = getStudentCount();
        
        while (numberOfStudents == 0) {
            System.out.println("Number of students can't be zero.");
            System.out.println("Again enter value : ");
            numberOfStudents = getPositiveIntegerOnly();
        }
        
        final Marksheet classFourth = new Marksheet();
        
        int[] grades = new int[numberOfStudents];
        
        try {
            
            grades = getGradesOfStudents(numberOfStudents);
            DecimalFormat twoDecimalPlaces = new DecimalFormat("#.00");
            System.out.println("| Average Grade : " 
                                + twoDecimalPlaces.format(classFourth.getAverageGrade(grades)) + " |");
            System.out.println("| Maximum Grade : " 
                                + classFourth.getMaximumGrade(grades) + " |");
            System.out.println("| Minimum Grade : " 
                                + classFourth.getMinimumGrade(grades) + " |");
            System.out.println("| Percentage of students passed : " 
                                + twoDecimalPlaces.format(classFourth.getPercentageOfStudentsPassed(grades)) + " |");
            
            
        } catch (ArithmeticException ex) {
            System.out.println(ex.getMessage());
            main(new String[0]);
        }
    }
}
