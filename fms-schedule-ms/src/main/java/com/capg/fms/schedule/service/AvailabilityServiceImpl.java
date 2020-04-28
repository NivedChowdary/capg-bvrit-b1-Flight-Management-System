package com.capg.fms.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.schedule.excepions.FlightNotFoundException;
import com.capg.fms.schedule.excepions.InvalidInputException;
import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.repository.IAvailabilityScheduledFlightRepo;
import com.capg.fms.schedule.repository.IAvailabilityScheduleRepo;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	IAvailabilityScheduledFlightRepo flightRepository;
	
	@Autowired
	IAvailabilityScheduleRepo scheduleRepo;

	@Override
	public boolean checkScheduledFlightById(long flightNumber) {

		if(!flightRepository.existsByFlightNumber(flightNumber)) {
			System.out.println(flightNumber);
			throw new FlightNotFoundException("FlightNumber with "+flightNumber+" is NOT FOUND");
		}
		return true;
	}
		
	@Override
	public boolean checkSeatAvailability(long flightNumber, int availableSeats) throws SeatsAreNotAvailableException{
		
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(flightRepository.existsAvailableSeats(0)) {
				throw new SeatsAreNotAvailableException("Seats are not available in "+flightNumber);
			}
		}
		return true;
	}

	@Override
	public boolean checkSource(long flightNumber,String sourceAirport) {
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
				throw new InvalidInputException("Source Airport is not valid");
			}
		}	
		return true;
	}
	
	@Override
	public boolean checkDestination(long flightNumber, String destinationAirport) {
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
				throw new InvalidInputException("Destination Airport is not valid");
			}
		}	
		return true;
	}

	@Override
	public boolean checkSourceAndDestination(long flightNumber, String sourceAirport, String destinationAirport) {
		if(flightRepository.existsByFlightNumber(flightNumber)) {
			if(scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
				if(flightRepository.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
					return true;
				}
			}
		}		
		return false;
	}
	
	@Override
	public boolean validateFlightId(long flightNumber) {

		int count=0;
		while(flightNumber>0) {
			count++;
			flightNumber=flightNumber/10;
		}
		
		if(count<12 || count>12) {
			throw new InvalidInputException("ID should be of 12 digits");	
		}
		return true;
	}
}