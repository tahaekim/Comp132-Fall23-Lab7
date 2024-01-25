/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Ahmet Taha Ekim, 79234>
********************************************************************************/
package main;

//TO-DO
// IMPORT NECESSARY PACKAGES
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import course.Course;
import exception.InvalidCourseException;
import exception.InvalidRegistrationException;
import exception.InvalidStudentException;
import exception.NoSuchStudentException;
import student.Student;

public class Main {
    public static void main(String[] args) throws InvalidCourseException, InvalidStudentException, InvalidRegistrationException, NoSuchStudentException {
    	StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        //TO-DO
        //READ GIVEN INPUT FILE AND TEST YOUR STUDENT MANAGEMENT SYSTEM
        //YOU SHOULD PRINT SAME RESULTS WITH PART 1 ON EXPECTED OUTPUT
    	String filePath = "/Users/a.tahaekim/git/fall2023-lab7-tahaekim/src/main/Input.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            System.out.println("Part 1- Results after Input file is read");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] splitted = line.split(" ");
                
                Course course = new Course(splitted[0], (splitted[1] + " " + splitted[2]), Integer.parseInt(splitted[3]), Boolean.parseBoolean(splitted[4]));
                studentManagementSystem.addCourse(course);
                System.out.println("Course added: " + course.getCode() + ", Title: " + course.getTitle() + ", Capacity: " + course.getCapacity());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        


        //TO-DO
        //YOU SHOULD CREATE 2 DUMMY STUDENTS
        //PRINT REGISTRATION INFORMATION
        //PRINT EACH STUDENT'S TRANSCRIPT
        //FOLLOW THE EXAMPLE OUTPUT 
        System.out.println("\nPart 2 - All Registrations And Transcripts");
        Student student = new Student("0087548", "Ahmet", 25);
        Student student1 = new Student("0037432", "Taha", 20);
        
        studentManagementSystem.addStudent(student);
        studentManagementSystem.addStudent(student1);
        
        studentManagementSystem.registerStudent(student.getID(), "Comp132", 30.5);
        studentManagementSystem.registerStudent(student.getID(), "Comp304", 25.0);
        studentManagementSystem.registerStudent(student.getID(), "Comp306", 42.3);
        
        studentManagementSystem.registerStudent(student1.getID(), "Comp132", 90.5);
        studentManagementSystem.registerStudent(student1.getID(), "Comp304", 85.0);
        studentManagementSystem.registerStudent(student1.getID(), "Comp306", 92.3);
        
        studentManagementSystem.printAllRegistrations();
        studentManagementSystem.printStudentTranscript(student.getID());
        studentManagementSystem.printStudentTranscript(student1.getID());
        

        //TO-DO 
        //TEST INVALID STUDENT EXCEPTIONS
        System.out.println("\nPart 3 - Exception Testing");

        try {
        	Student invalidStudent = new Student("0000001", "Invalid", 15);
            studentManagementSystem.addStudent(invalidStudent);
		} catch (InvalidStudentException e) {
			System.out.println("InvalidStudentException: " + e.getMessage());
		}
        
        try {
            Student invalidStudent = new Student("0000", "Invalid", 20);
            studentManagementSystem.addStudent(invalidStudent);
        } catch (InvalidStudentException e) {
            System.out.println("InvalidStudentException: " + e.getMessage());
        }

        //TO-DO 
        //TEST INVALID COURSE EXCEPTIONS
        try {
			Course course = new Course("abc", "Invalid", 0, false);
			studentManagementSystem.addCourse(course);
		} catch (InvalidCourseException e) {
			System.out.println("InvalidCourseException: " + e.getMessage());
		}
        
        try {
			Course course = new Course("abcdfgh", "Invalid", 0, false);
			studentManagementSystem.addCourse(course);
		} catch (InvalidCourseException e) {
			System.out.println("InvalidCourseException: " + e.getMessage());
		}
        
        try {
			Course course = new Course("abcd123", "Invalid", 0, false);
			studentManagementSystem.addCourse(course);
		} catch (InvalidCourseException e) {
			System.out.println("InvalidCourseException: " + e.getMessage());
		}
        
        //TO-DO 
        //TEST INVALID REGISTRATION EXCEPTIONS
        try {
            studentManagementSystem.registerStudent(student.getID(), "Comp341", 5000.0);
		} catch (InvalidRegistrationException e) {
			System.out.println("InvalidRegistrationException: " + e.getMessage());
		}
        
        try {
        	Student student2 = new Student("0087549", "Ali", 25);
            Student student3 = new Student("0037433", "Ekim", 20);
            Student student4 = new Student("0087550", "Cemre", 25);
            Student student5 = new Student("0037434", "Cesur", 20);
            studentManagementSystem.addStudent(student2);
            studentManagementSystem.addStudent(student3);
            studentManagementSystem.addStudent(student4);
            studentManagementSystem.addStudent(student5);
            
            studentManagementSystem.registerStudent(student.getID(), "Comp341", 50.0);
            studentManagementSystem.registerStudent(student1.getID(), "Comp341", 58.0);
            studentManagementSystem.registerStudent(student2.getID(), "Comp341", 55.0);
            studentManagementSystem.registerStudent(student3.getID(), "Comp341", 60.0);
            studentManagementSystem.registerStudent(student4.getID(), "Comp341", 90.0);
            studentManagementSystem.registerStudent(student5.getID(), "Comp341", 70.0);
            
		} catch (InvalidRegistrationException e) {
			System.out.println("InvalidRegistrationException: " + e.getMessage());
		}
        
        //TO-DO 
        //TEST NO SUCH STUDENT EXCEPTION
        try {
            studentManagementSystem.registerStudent("0000001", "Comp132", 89.0);
        } catch (NoSuchStudentException e) {
            System.out.println("NoSuchStudentException: " + e.getMessage());
        }
    
    }
}
