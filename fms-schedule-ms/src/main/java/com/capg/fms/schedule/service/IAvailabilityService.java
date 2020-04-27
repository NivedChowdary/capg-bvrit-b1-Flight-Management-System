package com.capg.fms.schedule.service;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.ScheduledFlight;

public interface IAvailabilityService {

	ScheduledFlight getFlightById(long flightNumber);
	
	ScheduledFlight checkSeatAvailability(long flightNumber,int availableSeats) throws SeatsAreNotAvailableException;
}
