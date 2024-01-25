[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/oKMt6VLv)
# COMP 132, Fall 2023

# IMPORTANT

For each lab assignment, **you must include and sign (by writing your name and student ID number) the following Pledge of Honor statement at the **TOP of your Test.java class (if you do not do this, you will get zero)** source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on GitHub.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-7 Prelab - Student Management System

![](/student-course.png?raw=true "")

In this programming lab, you will be mainly practicing **Exception Handling**, and **Files and Streams** concepts. You are asked to implement a Student Management System in Java. The system involves managing student records, courses, and enrollments. Each enrollment is considered as a "Registration."

You are provided with a Java project structure below and should develop your solution within this structure. 

Use the Scanner class to read input from the provided Input.txt file. Note that we may test your code with various test cases.

# Folder Structure:
```
src/
|-- student/
|   |-- Student.java
|   |-- StudentValidator.java
|-- course/
|   |-- Course.java
|   |-- CourseValidator.java
|-- registration/
|   |-- Registration.java
|   |-- RegistrationValidator.java
|-- exception/
|   |-- InvalidStudentException.java
|   |-- InvalidCourseException.java
|   |-- NoSuchStudentException.java
|   |-- InvalidRegistrationException.java
|-- main/
|   |-- Input.txt
|   |-- Main.java
|   |-- StudentManagementSystem.java
```

#### NOTE: All class variables must be declared as private. You should also implement getters and setters when necessary. Otherwise you will lose points!

## Student Class:
```
  - ID, type String.
  - Name, type String.
  - Age, type int.
  - A constructor with the signature Student(String ID, String name, int age)
```

## StudentValidator Class:
  - validateID method with the signature (String ID): Validates if the student ID is in the correct format. If not, it throws an InvalidStudentException.

  #### NOTE: The student ID includes seven digit characters, with the first two zeros (e.g., 0087548).

  - validateAge method with the signature (int age): Validates if the age is a positive integer greater than 17. If not, it throws an InvalidStudentException.

## Course Class:
```
  - Code, type String.
  - Title, type String.
  - Capacity, type int.
  - isOffered, type boolean
  - A constructor with the signature Course(String code, String title, int capacity, boolean isOffered)
```
## CourseValidator Class:

  - validateCode method with the signature (String code): Validates if the course code is in the correct format. If not, it throws an InvalidCourseException.

  #### Note: The course code includes four letters and three digits (e.g., Comp132).

  - validateOffering method: If the isOffered holds a false value, the method should throw an InvalidCourseException.

## Registration Class:
```
  - Student, type Student.
  - Course, type Course.
  - Grade, type double.
  - A constructor with the signature Registration(Student student, Course course, double grade)
```

#### NOTE: Each time a student registers in the course, the capacity should be decreased by 1. 

  - If the course does not have enough capacity, the system should throw an InvalidRegistrationException with the proper message.

## RegistrationValidator Class:

  - validateGrade method with the signature (double grade): Validates if the grade is within the valid range (0.0 to 100.0). If not, it throws an InvalidRegistrationException.

## InvalidStudentException Class:

  - Custom exception class for invalid student information.

## InvalidCourseException Class:

  - Custom exception class for invalid course information.

## NoSuchStudentException Class:

  - Custom exception class for situations where a student does not exist.

## InvalidRegistrationException Class:

  - Custom exception class for invalid registration information.
    
## StudentManagementSystem Class:

  - Students, type HashMap<String, Student>. The keys of the map are the student IDs. The values are the Student objects.
  - Courses, type HashMap<String, Course>. The keys of the map are the course codes. The values are the Course objects.
  - Registrations, type ArrayList. An ArrayList that contains registration objects.

## Methods:

  - addStudent method with the signature (Student student): Validates and adds a student to the system.

  - addCourse method with the signature (Course course): Validates and adds a course to the system.
  
  - registerStudent method with the signature (String studentID, String courseCode, double grade): Validates and registers a student for a course.

  - printAllRegistrations method: Prints information about all registrations.
  
  - printStudentTranscript method with the signature (String studentID): Prints the transcript of a student.

Your task is to implement the classes and methods according to the specifications provided. Ensure proper exception handling and validation in your code.
The expected output is shared with you below. You should arrange your main file accordingly to be able to display that your code works correctly and your exception handling is fine.

## Main Class:

#### You are expected to implement the Main class according to the expected output and the TODOs, which are in the given template Main.java file.
  
  - For the exception handling you can try different student ID’s, names etc.

  - For the Part 1 you should read the Input file and print added courses like in the below output.
  
  - For Part 2 you should register students with below ID’s, grades and Course codes. Then you should print all registrations and student transcripts. Please follow the example output.

  - Finally, for Part 3 you should demonstrate your exception handling works properly. Create test cases for each exception and get the following outputs. During the demo you should be able to explain why you get such an exception. 

## Expected output;
```
Part 1- Results after Input file is read
Course added: Comp132, Title: Advanced Programming, Capacity: 5
Course added: Comp304, Title: Operating Systems, Capacity: 4
Course added: Comp467, Title: Network Security, Capacity: 7
Course added: Comp306, Title: Database Management, Capacity: 5
Course added: Comp341, Title: Artificial Intelligence, Capacity: 4
Course added: Comp412, Title: Computer Vision, Capacity: 6
Course added: Comp423, Title: Computer Networks, Capacity: 7
```

```
Part 2 - All Registrations And Transcripts
Student ID: 0087548, Course Code: Comp132, Grade: 30.5
Student ID: 0087548, Course Code: Comp304, Grade: 25.0
Student ID: 0087548, Course Code: Comp306, Grade: 42.3
Student ID: 0037432, Course Code: Comp132, Grade: 90.5
Student ID: 0037432, Course Code: Comp341, Grade: 85.0
Student ID: 0037432, Course Code: Comp412, Grade: 92.3

Transcript for Student ID: 0087548
Course Code: Comp132, Grade: 30.5
Course Code: Comp304, Grade: 25.0
Course Code: Comp306, Grade: 42.3

Transcript for Student ID: 0037432
Course Code: Comp132, Grade: 90.5
Course Code: Comp341, Grade: 85.0
Course Code: Comp412, Grade: 92.3
```

```
Part 3 - Exception Testing
InvalidStudentException: Invalid age, must be a positive integer greater than 17
InvalidStudentException: Invalid student ID format
InvalidCourseException: Invalid course code format, course ID should contain 7 characters exactly
InvalidCourseException: Invalid course code format, course ID starts with four letters and ends with three digits.
InvalidCourseException: Course is not offered
InvalidRegistrationException: Invalid grade, must be between 0.0 and 100.0
InvalidRegistrationException: Course is full, cannot register
NoSuchStudentException: Student with ID 0000001 does not exist
```






