package com.capg.fms.schedule.service;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;

public interface IAvailabilityService {

	boolean checkScheduledFlightById(long flightNumber);
	boolean checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
	boolean validateFlightId(long flightNumber);
	boolean validateSource(String sourceAirport);
	boolean validateDestination(String destinationAirport);
	boolean validateSourceAndDestination(String sourceAirport, String destinationAirport);
}
