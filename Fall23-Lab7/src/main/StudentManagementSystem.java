package main;

import java.util.ArrayList;
import java.util.HashMap;

import course.Course;
import course.CourseValidator;
import exception.InvalidCourseException;
import exception.InvalidRegistrationException;
import exception.InvalidStudentException;
import exception.NoSuchStudentException;
import registration.Registration;
import registration.RegistrationValidator;
import student.Student;
import student.StudentValidator;

public class StudentManagementSystem {
	private HashMap<String, Student> Students;
	private HashMap<String, Course> Courses;
	private ArrayList<Registration> Registrations;
	
	public StudentManagementSystem() {
        Students = new HashMap<>();
        Courses = new HashMap<>();
        Registrations = new ArrayList<>();
    }
	
	public void addStudent(Student student) throws InvalidStudentException {
		StudentValidator validator = new StudentValidator();

        validator.validateID(student.getID());
        validator.validateAge(student.getAge());
        Students.put(student.getID(), student);
    }
	
	public void addCourse(Course course) throws InvalidCourseException{
		CourseValidator validator = new CourseValidator();
		validator.validateCode(course.getCode());
		validator.validateOffering(course.isOffered());
		Courses.put(course.getCode(), course);
	}
	
	public void registerStudent(String studentID, String courseCode, double grade) throws InvalidStudentException, InvalidCourseException, InvalidRegistrationException, NoSuchStudentException{
		Student student = null;
		Course course = null;
		
		RegistrationValidator validator = new RegistrationValidator();
		CourseValidator validator1 = new CourseValidator();
		StudentValidator validator2 = new StudentValidator();
		validator.validateGrade(grade);
		validator1.validateCode(courseCode);
		validator2.validateID(studentID);
		
		for(String id : Students.keySet()) {
			if(id.equals(studentID)) {
				student = Students.get(id);
			}
		}
		
		for(String code: Courses.keySet()) {
			if(code.equals(courseCode)) {
				course = Courses.get(code);
			}
		}
		
		if (!Students.containsKey(studentID)) {
	        throw new NoSuchStudentException("Student with ID " + studentID + " does not exist");
	    }
		
		validator.validateCapacity(course.getCapacity());
		Registration registration = new Registration(student, course, grade);
		Registrations.add(registration);
	}
	
	public void printAllRegistrations() {
		for(Registration registration : Registrations) {
			System.out.println("Student ID: " + registration.getStudent().getID() + ", Course Code: " + registration.getCourse().getCode() + ", Grade: " + registration.getGrade());
		}
	}
	
	public void printStudentTranscript(String studentID) {
		System.out.println("\nTranscript for Student ID: " + studentID);
		for(Registration registration : Registrations) {
			if(registration.getStudent().getID().equals(studentID)) {
				System.out.println("Course Code: " + registration.getCourse().getCode() + ", Grade: " + registration.getGrade());
			}
		}
	}
}
