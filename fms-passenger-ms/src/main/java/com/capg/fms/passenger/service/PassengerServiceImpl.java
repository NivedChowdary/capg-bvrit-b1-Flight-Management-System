package com.capg.fms.passenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.InvalidInputException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerUinAlreadyExistException;
import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.repository.IPassengerRepo;

@Service
	public class PassengerServiceImpl implements IPassengerService {

		@Autowired(required=false)
		IPassengerRepo passengerRepo;

		@Override
		@Transactional
		public Passenger addPassenger(Passenger passenger) {
			if(passengerRepo.existsById(passenger.getPassengerNumber()))
				throw new PassengerAlreadyExistException("Passenger with Number: " +passenger.getPassengerNumber()+" is already exist");
//			if(passengerRepo.existsById(passenger.getPassengerUIN()))
//				throw new PassengerUinAlreadyExistException("Passenger with UIN: " +passenger.getPassengerUIN()+" is already exist");
			return passengerRepo.save(passenger);

		}

		@Override
		@Transactional
		public boolean deletePassenger(long passengerNumber) {
			if(!passengerRepo.existsById(passengerNumber)) 
			{	
			   throw new PassengerNotFoundException("Passenger with Number "+passengerNumber+" Not Found");
			}
			passengerRepo.deleteById(passengerNumber);
			return !passengerRepo.existsById(passengerNumber);
		}
		
		@Override
		@Transactional
		public Passenger getPassenger(long passengerNumber) {
			if(!passengerRepo.existsById(passengerNumber)) 
			{	
			   throw new PassengerNotFoundException("Passenger with Num "+passengerNumber+" Not Found");
			}
		    return passengerRepo.getOne(passengerNumber);
		}
		
		
		@Override
		@Transactional
		public List<Passenger> getAllPasssengers() {
			 if(passengerRepo.count()==0)
			    	throw new EmptyPassengerListException("No Passenger Found in Passenger Database");
				return passengerRepo.findAll();
		}

		@Override
		@Transactional
		public Passenger updatePassenger(Passenger passenger) {
			if(!passengerRepo.existsById(passenger.getPassengerNumber()))
				throw new PassengerNotFoundException("Passenger with Number : " +passenger.getPassengerNumber()+" Not Found");
			Passenger newPassenger=passengerRepo.getOne(passenger.getPassengerNumber());
			newPassenger.setPassengerName(passenger.getPassengerName());
			newPassenger.setPassengerAge(passenger.getPassengerAge());
			newPassenger.setPassengerUIN(passenger.getPassengerUIN());
			newPassenger.setLuggage(passenger.getLuggage());
		     passengerRepo.save(newPassenger);
			 return newPassenger;	
		}
		@Override
		public boolean validatePassengerNumber(long passengerNumber) {
		String s=Long.toString(passengerNumber);
		if(!(s.length()==10 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Passenger number should be of 10 digits");
		}
		return true;	}
		
		@Override
		public boolean validatePassengerUIN(long passengerUIN) {
		String s=Long.toString(passengerUIN);
		if(!(s.length()==12 && s.charAt(0)!=0)) {
			throw new InvalidInputException("Passenger UIN should be of 12 digits");
		}
		return true;	}
		
		@Override
		public void validatePassenger(Passenger passenger) {
			//VALIDATE PASSENGER NUMBER
			long passengerNumber=passenger.getPassengerNumber();
		    this.validatePassengerNumber(passengerNumber);
		    
		    //VALIDATE PASSENGER UIN
			long passengerUIN=passenger.getPassengerUIN();
			this.validatePassengerUIN(passengerUIN);
		}

		

}
	