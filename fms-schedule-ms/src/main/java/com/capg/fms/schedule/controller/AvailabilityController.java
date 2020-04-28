package com.capg.fms.schedule.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.schedule.excepions.SeatsAreNotAvailableException;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.service.IAvailabilityService;

@RestController
@RequestMapping("/flights")
public class AvailabilityController {

	@Autowired
	IAvailabilityService service;

	@GetMapping("/{flightNumber}")
	public List<ScheduledFlight> getFlightById(@PathVariable long flightNumber) {
		return service.getFlightById(flightNumber);
	}
	
	@GetMapping("/{flightNumber}/{availableSeats}")
	public boolean checkSeatAvailability(@PathVariable long flightNumber, @PathVariable int availableSeats) throws SeatsAreNotAvailableException {
		return service.checkSeatAvailability(flightNumber, availableSeats);
	}
}

//@GetMapping("/{flightNumber}")
//public ResponseEntity<Flight> getFlightById(@PathVariable long flightNumber) {
//	Flight flight=service.getFlightById(flightNumber);
//	return new ResponseEntity<Flight>(flight,HttpStatus.FOUND);
//}


//Airport airport=new Airport("Rajiv Ganndhi", "354fgdf", "Shamshabad");
//Flight flight=new Flight(4724489326L, "Air ways", "DLF", 100);