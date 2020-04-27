package com.capg.fms.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.service.FlightServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/flights")
public class FlightController {
	/* http://localhost:9085/flights/flight/add
	* POSTMAN (Post : body{ "flightModel" : "SpiceJet", "carrierName" : "air", "seatCapacity" : 50 })
	* Don't insert number, number is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
	*/

	@Autowired
	FlightServiceImpl flightservice;
	
     
	@PostMapping("/flight/add") // postman: POST
	public ResponseEntity<Boolean> saveFlight(@RequestBody Flight flight) {
		Flight b = flightservice.addFlight(flight);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
		
		//return "Hello " + b.getCarrierName() + "\n Your Flight " + b.getFlightModel()
				//+ " is successfully created with the number " + b.getFlightNumber();
	}

	/* 
	 * This deleteFlightById(long flightNumber) method will removes a particular flight
	 */
	@DeleteMapping("/flight/deleteById/{flightNumber}") // postman : DELETE
	public ResponseEntity<Boolean> deleteFlightById(@PathVariable long flightNumber)
	{
		flightservice.deleteFlight(flightNumber);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		//return "your flight is deleted successfully" ;
		return responseEntity;
	}
	
	/*
	 * This showAll() method will view the details of all flights
	 */
	@GetMapping("/flight/showall") // postman: GET
	public ResponseEntity<List<Flight>> showAll() {
		List<Flight> flight = flightservice.getAll();
		return new ResponseEntity<List<Flight>>(flight,new HttpHeaders(),HttpStatus.OK);

	}

	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}

//	@Autowired
//	FlightServiceImpl  flightService;
//	
//	@GetMapping("/all")
//	public List<Flight>  showAll()
//	{
//		  return flightService.getAll();
//	}
//
////	@GetMapping("/flight/id/{id}")
////	public Flight getOne(@PathVariable int id) 
////	{
////		  return AddFlightServiceImpl.getOne(id);
////	}
////	
////	@PostMapping("/add")
////	public Flight  save(@RequestBody Flight flight)
////	{
////		return  FlightServiceImpl.addFlight(flight);
////	}
////	
////	@DeleteMapping("/flight/id/{id}")
////	public boolean  deleteById(@PathVariable int id)
////	{
////		return  AddFlightServiceImpl.deleteById(id);
////	}
//
////	@PutMapping("/flight")
////	public Flight  updateFlight(@RequestBody Flight flight)
////	{
////		return  AddFlightServiceImpl.updateProduct(flight);
////	}
//	
//
//
//}
//
//
