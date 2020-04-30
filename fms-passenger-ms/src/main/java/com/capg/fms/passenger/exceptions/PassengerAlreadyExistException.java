package com.capg.fms.passenger.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Passenger already exists", value = HttpStatus.NOT_FOUND)
public class PassengerAlreadyExistException extends RuntimeException {
	public PassengerAlreadyExistException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
