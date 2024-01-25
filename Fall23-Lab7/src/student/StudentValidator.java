package student;
import exception.*;

import java.util.regex.Pattern;

public class StudentValidator {
	
	public void validateID(String ID) throws InvalidStudentException {
        String regex = "^00\\d{5}$";

        if (!Pattern.matches(regex, ID)) {
            throw new InvalidStudentException("Invalid student ID format.");
        }
    }
	
	public void validateAge(int age) throws InvalidStudentException{
		if (age <= 17) throw new InvalidStudentException("Invalid age, must be a positive integer greater than 17");
	}
}
