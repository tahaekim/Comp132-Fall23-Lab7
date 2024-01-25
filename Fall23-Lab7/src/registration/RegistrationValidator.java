package registration;

import exception.InvalidRegistrationException;

public class RegistrationValidator {
	
	public void validateGrade(double grade) throws  InvalidRegistrationException{
		if((grade > 100.0) || (grade < 0.0)) throw new InvalidRegistrationException("Invalid grade, must be between 0.0 and 100.0");
	}
	
	public void validateCapacity(int capacity) throws InvalidRegistrationException{
		if(capacity <= 0) throw new InvalidRegistrationException("Course is full, cannot register");
	}
	
}
