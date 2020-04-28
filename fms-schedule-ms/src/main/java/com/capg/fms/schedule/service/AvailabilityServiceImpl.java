package com.capg.fms.schedule.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.schedule.excepions.FlightNotFoundException;
import com.capg.fms.schedule.excepions.InvalidInputException;
import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IAvailabilityFlightRepo;

@Service
public class AvailabilityServiceImpl implements IAvailabilityService {

	@Autowired
	IAvailabilityFlightRepo flightRepository;

	@Override
	public List<ScheduledFlight> getFlightById(long flightNumber) {
		if(flightRepository.existsById(flightNumber)) {
			throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");	
		}
		return flightRepository.findByFlightNumber(flightNumber);
	}
	
	@Override
	public boolean checkSeatAvailability(long flightNumber, int availableSeats) throws SeatsAreNotAvailableException{

		if(availableSeats<=0) {
			throw new SeatsAreNotAvailableException("Seats are not available in "+flightNumber);
		}
		return true;
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

	@Override
	public boolean validateSource(String sourceAirport) {
		
		if((sourceAirport.equalsIgnoreCase(sourceAirport)) || sourceAirport.matches(sourceAirport)) {
			return true;
		}
		else {
		    throw new InvalidInputException("Source Airport is not valid");
		}		
	}

	@Override
	public boolean validateDestination(String destinationAirport) {
		
		if((destinationAirport.equalsIgnoreCase(destinationAirport)) || destinationAirport.matches(destinationAirport)) {
			return true;
		}
		else {
		    throw new InvalidInputException("Destination Airport is not valid");
		}		
	}

	@Override
	public boolean validateSourceAndDestination(String sourceAirport, String destinationAirport) {

		if((sourceAirport.matches(sourceAirport)) && (destinationAirport.matches(destinationAirport)) ||
				(sourceAirport.equalsIgnoreCase(sourceAirport) && destinationAirport.equalsIgnoreCase(destinationAirport))) {
			return true;
		}
		else {
		    throw new InvalidInputException("Flight is unavailable");
		}
	}	
}













//if(!flightRepository.findAll().contains(flightRepository.findByFlightNumber(flightNumber))) {
//System.out.println((flightNumber));
//throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
//}



//if(!flightRepository.findByFlightNumber(flightNumber).contains(availableSeats)) {
//throw new SeatsAreNotAvailableException("Seats in "+flightNumber+" are NOT AVAILABLE");
//}
//return true;

