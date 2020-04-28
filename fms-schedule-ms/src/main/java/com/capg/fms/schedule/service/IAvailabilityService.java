package com.capg.fms.schedule.service;

import java.util.List;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.ScheduledFlight;

public interface IAvailabilityService {

	List<ScheduledFlight> getFlightById(long flightNumber);
	boolean checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
	boolean validateFlightId(long flightNumber);
	boolean validateSource(String sourceAirport);
	boolean validateDestination(String destinationAirport);
	boolean validateSourceAndDestination(String sourceAirport, String destinationAirport);
}
