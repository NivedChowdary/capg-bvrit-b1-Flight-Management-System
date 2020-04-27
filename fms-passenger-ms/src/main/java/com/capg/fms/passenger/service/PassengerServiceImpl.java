package com.capg.fms.passenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.fms.passenger.exceptions.EmptyPassengerListException;
import com.capg.fms.passenger.exceptions.PassengerAlreadyExistException;
import com.capg.fms.passenger.exceptions.PassengerNotFoundException;
import com.capg.fms.passenger.model.Passenger;
import com.capg.fms.passenger.repository.IPassengerRepo;

@Service
	public class PassengerServiceImpl implements IPassengerService {

		@Autowired(required=false)
		IPassengerRepo passengerRepo;

		@Override
		@Transactional
		public Passenger addPassenger(Passenger passenger) {
			if(passengerRepo.existsById(passenger.getPassengerNum()))
				throw new PassengerAlreadyExistException("Passenger with Number: " +passenger.getPassengerNum()+" is Already Exist");
			return passengerRepo.save(passenger);
		}
		


		@Override
		@Transactional
		public boolean deletePassenger(long passengerUIN) {
			if(!passengerRepo.existsById(passengerUIN)) 
			{	
			   throw new PassengerNotFoundException("Passenger with UIN "+passengerUIN+" Not Found");
			}
			passengerRepo.deleteById(passengerUIN);
			return !passengerRepo.existsById(passengerUIN);

		}
		@Override
		@Transactional
		public Passenger getPassenger(long passengerUIN) {
			if(!passengerRepo.existsById(passengerUIN)) 
			{	
			   throw new PassengerNotFoundException("Passenger with UIN "+passengerUIN+" Not Found");
			}
		    return passengerRepo.getOne(passengerUIN);

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
			if(!passengerRepo.existsById(passenger.getPassengerNum()))
				throw new PassengerNotFoundException("Passenger with Number : " +passenger.getPassengerNum()+" Not Found");
		
			Passenger newPassenger=passengerRepo.getOne(passenger.getPassengerNum());
			newPassenger.setPassengerName(passenger.getPassengerName());
			newPassenger.setPassengerAge(passenger.getPassengerAge());
			newPassenger.setPassengerUIN(passenger.getPassengerUIN());
			newPassenger.setLuggage(passenger.getLuggage());

		passengerRepo.save(newPassenger);
			return newPassenger;	
		}



}