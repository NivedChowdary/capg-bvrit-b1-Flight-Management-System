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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.service.FlightServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/flights")
public class FlightController {
	/* http://localhost:9089/flights/add
	* POSTMAN (Post : body{ "flightModel" : "SpiceJet", "carrierName" : "air", "seatCapacity" : 50 })
	* Don't insert number, number is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
	*/

	@Autowired
	FlightServiceImpl flightservice;
	
     
	@PostMapping("/add")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
		flightservice.addFlight(flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.CREATED);
	}

	

	/* 
	 * This deleteFlightById(long flightNumber) method will removes a particular flight
	 */
//	@DeleteMapping("/deleteById/{flightNumber}")
//	public ResponseEntity<Flight> deleteFlight(@PathVariable long flightNumber){
//		Flight deleted = flightservice.deleteFlight(flightNumber);
//	if(deleted.getFlightNumber()==flightNumber)
//		return new ResponseEntity<Flight>(HttpStatus.OK);
//	  return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
//	
//	}
	@DeleteMapping("/deleteById/{flightNumber}")
	public ResponseEntity<Flight> deleteFlight(@PathVariable long flightNumber){
		flightservice.deleteFlight(flightNumber);
		return new ResponseEntity<Flight>(HttpStatus.OK);
		
	}
	
	
	
	/*
	 * This showAll() method will view the details of all flights
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Flight>> getAllFlights(){
	List<Flight> allFlights=flightservice.getAll();	
	return new ResponseEntity<List<Flight>>(allFlights,HttpStatus.OK);
	}
	
	
	@PutMapping("/modify")
	public ResponseEntity<Flight> modifyFlight(@RequestBody Flight flight){
		Flight newFlight=flightservice.modifyFlight(flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
	@GetMapping("get/{flightNumber}")
	public ResponseEntity<Flight> getFlightById(@PathVariable long flightNumber) {
		Flight flight=flightservice.getFlightById(flightNumber);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
//	@GetMapping("/{flightNumber}")
//	public List<ScheduledFlight> getFlightById(@PathVariable long flightNumber) {
//		return service.getFlightById(flightNumber);
//	}
//	
	@ExceptionHandler(Exception.class)
	public String inValid(Exception e) {
		return e.getMessage();
	}

}




//
//
//@CrossOrigin(origins = "http://localhost:4200")
//
//@RestController
//@RequestMapping("/flights")
//public class FlightController {
//	/* http://localhost:9085/flights/flight/add
//	* POSTMAN (Post : body{ "flightModel" : "SpiceJet", "carrierName" : "air", "seatCapacity" : 50 })
//	* Don't insert number, number is :@GeneratedValue(strategy =GenerationType.SEQUENCE)
//	*/
//
//	@Autowired
//	FlightServiceImpl flightservice;
//	
//     
//	@PostMapping("/flight/add") // postman: POST
//	public ResponseEntity<Boolean> saveFlight(@RequestBody Flight flight) {
//		Flight b = flightservice.addFlight(flight);
//		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
//		System.out.println("response entity=" + responseEntity);
//		return responseEntity;
//		
//		//return "Hello " + b.getCarrierName() + "\n Your Flight " + b.getFlightModel()
//				//+ " is successfully created with the number " + b.getFlightNumber();
//	}
//
//	/* 
//	 * This deleteFlightById(long flightNumber) method will removes a particular flight
//	 */
//	@DeleteMapping("/flight/deleteById/{flightNumber}") // postman : DELETE
//	public ResponseEntity<Boolean> deleteFlightById(@PathVariable long flightNumber)
//	{
//		flightservice.deleteFlight(flightNumber);
//		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
//		System.out.println("response entity=" + responseEntity);
//		//return "your flight is deleted successfully" ;
//		return responseEntity;
//	}
//	
//	/*
//	 * This showAll() method will view the details of all flights
//	 */
//	@GetMapping("/flight/showall") // postman: GET
//	public ResponseEntity<List<Flight>> showAll() {
//		List<Flight> flight = flightservice.getAll();
//		return new ResponseEntity<List<Flight>>(flight,new HttpHeaders(),HttpStatus.OK);
//
//	}
//
//	@ExceptionHandler(Exception.class)
//	public String inValid(Exception e) {
//		return e.getMessage();
//	}
//
//}

