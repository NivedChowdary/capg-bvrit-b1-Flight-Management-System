package com.capg.fms.passenger.service;

import java.util.List;

import com.capg.fms.passenger.model.Passenger;

public interface IPassengerService {
	Passenger addPassengers(Passenger passenger);
	
	Passenger cancelPassenger(long PassengerNum);
	
	Passenger modifyPassenger(Passenger passenger);
	
	Passenger viewPassenger(long PassengerNum);
	
	Passenger deletePassenger(long PassengerUIN);
	
	 List<Passenger> getAllPasssengers();
	 
	Passenger getPassenger(long PassengeUIN);

}
