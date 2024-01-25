package registration;
import student.*;
import course.*;

public class Registration {
	private Student Student;
	private Course Course;
	private double Grade;
	
	public Registration(Student student, Course course, double grade) {
		this.Student = student;
		this.Course = course;
		this.Grade = grade;
		int capacity = course.getCapacity();
		capacity--;
		course.setCapacity(capacity);
	}

	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student student) {
		Student = student;
	}

	public Course getCourse() {
		return Course;
	}

	public void setCourse(Course course) {
		Course = course;
	}

	public double getGrade() {
		return Grade;
	}

	public void setGrade(double grade) {
		Grade = grade;
	}
	
	
}
