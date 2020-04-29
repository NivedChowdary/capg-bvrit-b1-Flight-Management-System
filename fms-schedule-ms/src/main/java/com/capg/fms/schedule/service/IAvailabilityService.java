package com.capg.fms.schedule.service;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;

public interface IAvailabilityService {

	String checkScheduledFlightById(long flightNumber);
	boolean checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
	String checkSource(long flightNumber, String sourceAirport);
	String checkDestination(long flightNumber, String destinationAirport);
	String checkSourceAndDestination(long flightNumber,String sourceAirport, String destinationAirport);
	boolean validateFlightId(long flightNumber);
//	This is a ygbybuji,kj 
}
