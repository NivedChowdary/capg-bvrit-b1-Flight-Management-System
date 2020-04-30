package com.capg.fms.passenger.exceptions;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.http.HttpStatus;

//@ResponseStatus(code = HttpStatus.ALREADy_REPORTED,reason = "Passenger UIN already exists", value = HttpStatus.NOT_FOUND)
public class PassengerUinAlreadyExistException extends RuntimeException {
	public PassengerUinAlreadyExistException(String message) {
		super(message);
	}

}
