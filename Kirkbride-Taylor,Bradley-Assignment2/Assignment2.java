import java.util.Scanner ;

/**
* ClassName: Assignment2 - Let teacher enter grades for a student then calculate the weighted average.
*
*
*<pre>
* Assignment: #2
* Course: ADEV-1003
* Version: 1.0
* Date created: September 21, 2015
*
* Revision Log
* WHO          WHEN        REASON
* ---------------------------------
*
* </pre>
*
* @author Bradley Kirkbride-Taylor
* @version 1.0*
*/

public class Assignment2
{
    /**
    * main -Runs the program, asks user for marks and calculates their grade.
    *
    * @param String[] args -  Uses arguments provide by user in the command line. This is no utilized in this 
    * program.
    */
    public static void main(String[] args) 
    {
        final int ASSIGNMENT_WEIGHT = 15 ;
        final int MIDTERM_WEIGHT = 40 ;
        final int FINAL_EXAM = 45 ;
        String studentName ;
        double assignments ; 
        double midTerm ;
        double finalExam ;
        double assignmentsWeighted ;
        double midTermWeighted ;
        double finalWeighted ;
        double finalGrade ;
        Scanner input ;
        
        // create a new scanner object
        input = new Scanner(System.in) ;
        
        //Welcome message
        System.out.println("Mark Calculator\n");
        
        //Prompt user for name of Student
        System.out.print("Enter the student's name:") ;
        studentName = input.nextLine() ;
        System.out.println() ;

        //Prompt user for mark on Assignments
        System.out.print("Enter " + studentName + "'s mark for Assignments (Max. 140): ") ;
        assignments = Double.parseDouble(input.nextLine()) ;
        System.out.println() ;
        
        //Propmt user for mark on mid-term
        System.out.print("Enter " + studentName + "'s Mid-term Exam mark. (Max. 60): ") ;
        midTerm = Double.parseDouble(input.nextLine()) ;
        System.out.println() ;
        
        //Prompt user for mark on final
        System.out.print("Enter " + studentName + "'s Final Exam mark. (Max. 85): ") ;
        finalExam = Double.parseDouble(input.nextLine()) ;
        System.out.println() ;

        //Calculate weighted grades
        assignmentsWeighted = (assignments / 140) * ASSIGNMENT_WEIGHT ;
        midTermWeighted = (midTerm / 60) * MIDTERM_WEIGHT ;
        finalWeighted = (finalExam / 85) * FINAL_EXAM ;
        finalGrade = assignmentsWeighted + midTermWeighted + finalWeighted ;

        //Print out final Report
        System.out.println("Grade Report") ;
        System.out.println("------------") ;
        System.out.println("Student: " + studentName) ;
        System.out.println() ;
        System.out.println("Assignments: " + assignments + "/140 worth 15%") ;
        System.out.println("Mid-term Exam: " + midTerm + "/60 worth 40%") ;
        System.out.println("Final Exam: " + finalExam + "/85 worth 45%") ;
        System.out.println() ;
        System.out.print("Final Mark: " + finalGrade ) ;
        
    }
}