package com.capg.fms.addflights.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.addflights.model.Flight;
import com.capg.fms.addflights.repo.FlightRepo;
@Service
public class AddFlightServiceImpl {

	@Autowired
	static
	FlightRepo  flightRepo;
	
	public List<Flight> findAll() {
		return flightRepo.findAll();
	}
	@Transactional
	
	public static Flight save(Flight flight) {
		// TODO Auto-generated method stub
		return flightRepo.save(flight);
	}

//	public static boolean deleteById(int id) {
//		flightRepo.deleteById(flightNumber);
//		return !flightRepo.existsById(flightNumber);
//	
//	}

	

}
	
	
	
	
	 