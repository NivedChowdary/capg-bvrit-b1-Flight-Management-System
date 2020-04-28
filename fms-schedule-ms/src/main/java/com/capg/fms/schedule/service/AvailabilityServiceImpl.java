package com.capg.fms.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.schedule.excepions.FlightNotFoundException;
import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IAvailabilityFlightRepo;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	IAvailabilityFlightRepo flightRepository;

	@Override
	public ScheduledFlight getFlightById(long flightNumber) {
		if(flightRepository.existsById(flightNumber)) {
			throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
		}
		return (ScheduledFlight)flightRepository.findByFlightNumber(flightNumber);	
	}
	
	@Override
	public ScheduledFlight checkSeatAvailability(long flightNumber, int availableSeats) throws SeatsAreNotAvailableException{
		if(!flightRepository.findByFlightNumber(flightNumber).contains(availableSeats)) {
			throw new SeatsAreNotAvailableException("Seats are not available");
		}
		return null;
	}	
}


//@Override
//public Flight getFlightById(long flightNumber) {
//	return flightRepository.findById(flightNumber).
//			orElseThrow(()-> new FlightNotFoundException(flightNumber));
//}


//@Override
//public Flight getFlightById(long flightNumber) {
//	if(!flightRepository.existsById(flightNumber)) {
//		throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
//	}
//	return flightRepository.getOne(flightNumber);
//}



//if(!flightRepository.findByFlightNumber(flightNumber).contains(availableSeats)) {
//throw new SeatsAreNotAvailableException("Seats in "+flightNumber+" are NOT AVAILABLE");
//}
//return true;
