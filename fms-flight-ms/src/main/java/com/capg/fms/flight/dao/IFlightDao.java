package com.capg.fms.flight.dao;
import java.util.List;

import com.capg.fms.flight.model.Flight;

public interface IFlightDao {
	
    public Flight addFlight(Flight flight);
	
	public void deleteFlight(long flightNumber) ;
	
	public List<Flight> getAll();


}
