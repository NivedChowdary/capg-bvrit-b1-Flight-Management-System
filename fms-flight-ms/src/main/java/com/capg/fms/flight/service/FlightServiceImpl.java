package com.capg.fms.flight.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.flight.exception.FlightNotFoundException;
import com.capg.fms.flight.model.Flight;
import com.capg.fms.flight.repo.IFlightRepo;




@Service
public class FlightServiceImpl implements IFlightService {


	@Autowired(required = true)
	IFlightRepo flightRepo;
	

	 @Override
	 @Transactional
	  public Flight addFlight (Flight flight) {
		  System.out.println(flight);
		  if(flightRepo.existsById(flight.getFlightNumber())) {
			 throw new RuntimeException("Flight Already Exits");
		  }
		 return flightRepo.save(flight);
	  }	
	  

	 @Override
		@Transactional
		public void deleteFlight(long flightNumber) {
		 if(!flightRepo.existsById(flightNumber)) {
			 throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
		 }
//		 Flight deleteFlight=flightRepo.getOne(flightNumber);
//		 flightRepo.deleteById(flightNumber);
//			return deleteFlight;
		 flightRepo.deleteById(flightNumber);
	 }
	 
	 
	 @Transactional
		public Flight modifyFlight(Flight newFlightData) {
		 Flight flight=flightRepo.getOne(newFlightData.getFlightNumber());		
		 flight.setFlightModel(newFlightData.getFlightModel());
		 flight.setCarrierName(newFlightData.getCarrierName());
		 flight.setSeatCapacity(newFlightData.getSeatCapacity());
			flightRepo.save(flight);
			return flight;

	}

	 @Override
	
		public List<Flight> getAll(){	
			return flightRepo.findAll();
		}
	 @Transactional
	 public Flight getFlightById(long flightNumber) {
		 if(!flightRepo.existsById(flightNumber)) {
			 throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");
		 }
		 return flightRepo.getOne(flightNumber);
	 }

//	 @Override
//		public List<Flight> getFlightById(long flightNumber) {
//			if(flightRepo.existsById(flightNumber)) {
//				throw new FlightNotFoundException("flightNumber with "+flightNumber+" is NOT FOUND");	
//			}
//			return flightRepo.getFlightById(flightNumber);
//		}
//	@Override
//	@Transactional
//	public Flight getFlightId(long flightNumber) {
//		 Flight getFlight=flightRepo.getOne(flightNumber);
//		 flightRepo.getFlightById(flightNumber);
//			return getFlight;
	}
		

	
	

