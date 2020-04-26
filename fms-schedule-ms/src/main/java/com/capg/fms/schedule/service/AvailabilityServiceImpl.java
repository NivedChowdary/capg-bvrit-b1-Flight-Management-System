package com.capg.fms.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.schedule.excepions.FlightNotFoundException;
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.repository.IAvailabilityFlightRepo;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	IAvailabilityFlightRepo flightRepository;
	
	@Override
	public Flight getFlightById(long flightNumber) {
		return flightRepository.findById(flightNumber).
				orElseThrow(()-> new FlightNotFoundException(flightNumber));
	}
}
