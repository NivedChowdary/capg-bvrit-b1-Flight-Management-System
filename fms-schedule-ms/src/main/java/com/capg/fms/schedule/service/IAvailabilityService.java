package com.capg.fms.schedule.service;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;

public interface IAvailabilityService {

	boolean checkScheduledFlightById(long flightNumber);
	boolean checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
	boolean checkSource(long flightNumber, String sourceAirport);
	boolean checkDestination(long flightNumber, String destinationAirport);
	boolean checkSourceAndDestination(long flightNumber,String sourceAirport, String destinationAirport);
	boolean validateFlightId(long flightNumber);
}
