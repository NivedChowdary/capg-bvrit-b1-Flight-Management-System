package com.capg.fms.passenger.service;

import java.util.List;

import com.capg.fms.passenger.model.Passenger;

public interface IPassengerService {
	
	Passenger addPassenger(Passenger passenger);
	boolean deletePassenger(long passengerUIN);
	Passenger getPassenger(long passengerUIN);
	List<Passenger> getAllPasssengers();
	Passenger updatePassenger(Passenger passenger);

	
//	 boolean cancelPassenger(long passengerNum);
	
//	Passenger viewPassenger(long passengerNum);
	 
	

}
