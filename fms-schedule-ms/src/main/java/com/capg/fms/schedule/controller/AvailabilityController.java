package com.capg.fms.schedule.controller;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.service.IAvailabilityService;

@RestController
@RequestMapping("/flights")
public class AvailabilityController {

	@Autowired
	IAvailabilityService service;
	
	@PostConstruct
	public void init() {		
		Schedule schedule=new Schedule(101, "Hyderabad", "Pune", 
				LocalDateTime.of(2020, 04, 25, 10, 30), LocalDateTime.of(2020, 04, 25, 12, 30));	
		ScheduledFlight scheduledFlight=new ScheduledFlight(101, 20, 4724489326L, schedule);
		
	}
	
	@GetMapping("/{flightNumber}")
	public ResponseEntity<ScheduledFlight> getFlightById(@PathVariable long flightNumber) {
		ScheduledFlight flight=service.getFlightById(flightNumber);
		return new ResponseEntity<ScheduledFlight>(flight,HttpStatus.FOUND);
	}
	
	@GetMapping("/{flightNumber}/{availableSeats}")
	public void checkSeatAvailability(@PathVariable long flightNumber, @PathVariable int availableSeats) throws SeatsAreNotAvailableException {
		service.checkSeatAvailability(flightNumber, availableSeats);
	}
}

//@GetMapping("/{flightNumber}")
//public ResponseEntity<Flight> getFlightById(@PathVariable long flightNumber) {
//	Flight flight=service.getFlightById(flightNumber);
//	return new ResponseEntity<Flight>(flight,HttpStatus.FOUND);
//}


//Airport airport=new Airport("Rajiv Ganndhi", "354fgdf", "Shamshabad");
//Flight flight=new Flight(4724489326L, "Air ways", "DLF", 100);