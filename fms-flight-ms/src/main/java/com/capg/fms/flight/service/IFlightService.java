package com.capg.fms.flight.service;

import java.util.List;

import com.capg.fms.flight.model.Flight;



public interface IFlightService {
	
	
	public Flight addFlight(Flight flight);
	
	public void deleteFlight(long flightNumber);
	
	public List<Flight> getAll();

}
