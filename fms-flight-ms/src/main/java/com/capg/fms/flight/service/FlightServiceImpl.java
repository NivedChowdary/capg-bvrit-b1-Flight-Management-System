package com.capg.fms.flight.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.flight.dao.IFlightDao;
import com.capg.fms.flight.model.Flight;



@Service
public class FlightServiceImpl implements IFlightService {
	@Autowired
	IFlightDao flightdao;

	@Override
	public Flight addFlight(Flight flight) {
	
		return flightdao.addFlight(flight);
	}

	@Override
	public void deleteFlight(long flightNumber) {
		
	flightdao.deleteFlight(flightNumber);
		
		
	}

	@Override
	public List<Flight> getAll() {
		
		return flightdao.getAll();
	}

}
