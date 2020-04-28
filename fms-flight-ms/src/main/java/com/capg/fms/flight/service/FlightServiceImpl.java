package com.capg.fms.flight.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
		public Flight deleteFlight(long flightNumber) {
		 Flight deleteFlight=flightRepo.getOne(flightNumber);
		 flightRepo.deleteById(flightNumber);
			return deleteFlight;
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
		

	
	
}
