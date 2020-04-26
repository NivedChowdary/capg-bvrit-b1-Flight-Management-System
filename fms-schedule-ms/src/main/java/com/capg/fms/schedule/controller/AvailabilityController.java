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
import com.capg.fms.schedule.model.Airport;
import com.capg.fms.schedule.model.Flight;
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
		Flight flight=new Flight(334464577L, "Airways", "GSM", 100);
		Airport airport=new Airport("Rajiv Gandhi", "13234HFF", "Shamshabad");
		Schedule schedule=new Schedule(101,airport, airport, LocalDateTime.of(2020, 04, 25, 10, 30),LocalDateTime.of(2020, 04, 25, 12, 00));
		ScheduledFlight scheduledFlight=new ScheduledFlight(101, 21, 334464577L, schedule, schedule, schedule, schedule, 6000);		
	}
	
	@GetMapping("/{flightNumber}")
	public ResponseEntity<Flight> getFlightById(@PathVariable long flightNumber) {
		Flight flight=service.getFlightById(flightNumber);
		return new ResponseEntity<Flight>(flight,HttpStatus.FOUND);
	}
}
