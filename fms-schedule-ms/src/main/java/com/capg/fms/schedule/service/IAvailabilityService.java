package com.capg.fms.schedule.service;

import com.capg.fms.schedule.model.Flight;

public interface IAvailabilityService {

	Flight getFlightById(long flightNumber);
}
