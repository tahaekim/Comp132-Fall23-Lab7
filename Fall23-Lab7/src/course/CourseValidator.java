package course;

import java.util.regex.Pattern;

import exception.InvalidCourseException;

public class CourseValidator {
	
	public void validateCode(String code) throws InvalidCourseException{
		String regex = "^[A-Za-z]{4}\\d{3}$";

        if (code.length() != 7) {
            throw new InvalidCourseException("Invalid course code format, course ID should contain 7 characters exactly");
        }else if(!Pattern.matches(regex, code)) {
        	throw new InvalidCourseException("Invalid course code format, course ID starts with four letters and ends with three digits.");
        }
	}
	
	public void validateOffering(boolean isOffered) throws InvalidCourseException{
		if (isOffered == false) {
			throw new InvalidCourseException("Course is not offered");
		}
	}
}
