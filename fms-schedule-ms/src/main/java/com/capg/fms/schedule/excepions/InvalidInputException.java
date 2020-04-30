package com.capg.fms.schedule.excepions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No availability",code = HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException {

	
	public InvalidInputException(String message) {
		super(message);
	}

}
