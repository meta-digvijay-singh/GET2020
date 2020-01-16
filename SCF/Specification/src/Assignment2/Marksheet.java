package Assignment2;

public class Marksheet {
    
    /**
     * Checks whether entered grades lie between [0 - 100].
     * @return true if grades[i] belongs to "0 <= grades[i] <= 100" for all i,
     *         where i can be 0 <= i < length(grades),
     *         otherwise return false.
     * @throw  if given array is empty or null.
     */
    public boolean isValid(int[] grades) throws ArithmeticException {
        if ((grades == null) || (grades.length == 0)) {
            throw new ArithmeticException("There is no grade available.");
        }
        
        final int NUMBER_OF_STUDENTS = grades.length;
        
        for (int studentId = 0; studentId < NUMBER_OF_STUDENTS; studentId++) {
            
            if ((grades[studentId] < 0) || (grades[studentId] > 100)) {
                return false;
            }
        }
        
        return true;
    }
    
    
    /**
     * Computes average of all grades.
     * @return average of grades.
     * @throw if grades is "null or empty" or 
     *        grades[i] is not between [0 - 100]
     *        for any i, where i can be 0 <= i < length(grades). 
     */
    public double getAverageGrade(int[] grades) throws ArithmeticException {
        
        if (!isValid(grades)) {
            throw new ArithmeticException("Grade should have value between 0 to 100.");
        }
        double sumOfGrades = 0.0;
        double averageGrade;
        final int NUMBER_OF_STUDENTS = grades.length;
        
        for (int studentId = 0; studentId < NUMBER_OF_STUDENTS; studentId++) {
            sumOfGrades += grades[studentId];
        }
        averageGrade = sumOfGrades / NUMBER_OF_STUDENTS;
        return averageGrade;
    }
    
    /**
     * Finds maximum grade out of all the grades.
     * @return maximum grade value.
     * @throw if grades[i] is not between [0 - 100]
     *        for any i, where i can be 0 <= i < length(grades).
     *        Or grades is empty or null. 
     */
    public int getMaximumGrade(int[] grades) throws ArithmeticException {
        
        if (!isValid(grades)) {
            throw new ArithmeticException("Grade should have value between 0 to 100");
        }
        
        int maxGrade = 0;
        int currentGrade;
        final int NUMBER_OF_STUDENTS = grades.length;
        
        for (int studentId = 0; studentId < NUMBER_OF_STUDENTS; studentId++) {
            currentGrade = grades[studentId];
            if (currentGrade > maxGrade) {
                maxGrade = currentGrade;
            }
        }
        return maxGrade;
    }
    
    /**
     * Finds minimum grade out of all the grades.
     * @return minimum grade value.
     * @throw if grade[i] is not between [0 - 100]
     *        for any i, where i can be 0 <= i < length(grades).
     *        Or grades is null or empty.
     */
    public int getMinimumGrade(int[] grades) throws ArithmeticException {
        
        if (!isValid(grades)) {
            throw new ArithmeticException("Grade should have value between 0 to 100");
        }
        
        int minGrade = 100;
        int currentGrade;
        final int NUMBER_OF_STUDENTS = grades.length;
        
        for (int studentId = 0; studentId < NUMBER_OF_STUDENTS; studentId++) {
            currentGrade = grades[studentId];
            
            if (currentGrade < minGrade) {
                minGrade = currentGrade;
            }
        }
        
        return minGrade;
    }
    
    /**
     * Computes percentage of students passed.
     * passing criteria is greater than or equal to 40 percent.
     * @return percentage of students passed.
     * @throw if grade[i] is not between [0 - 100]
     *        for any i, where 0 <= i < length(grades).
     *        Or grades is empty or null.
     */
    public double getPercentageOfStudentsPassed(int[] grades) throws ArithmeticException {
        
        if (!isValid(grades)) {
            throw new ArithmeticException("Grade should have value between 0 to 100");
        }
        
        int currentGrade;
        final int NUMBER_OF_STUDENTS = grades.length;
        double numberOfStudentsPassed = 0;
        double percentageOfStudentsPassed;
        
        for (int studentId = 0; studentId < NUMBER_OF_STUDENTS; studentId++) {
            currentGrade = grades[studentId];
            
            if (currentGrade >= 40) {
                numberOfStudentsPassed += 1;
            }
        }
        percentageOfStudentsPassed = (numberOfStudentsPassed / NUMBER_OF_STUDENTS) * 100;
        return percentageOfStudentsPassed;
    }
}
