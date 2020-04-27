package com.capg.fms.flight.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.capg.fms.flight.model.Flight;

@Repository
@Transactional
public class FlightDaoImpl implements IFlightDao {
	
	
	@PersistenceContext
	EntityManager entitymanager;

	@Override
	public Flight addFlight(Flight flight) {
		
		entitymanager.persist(flight);
		 
		 return flight;
		
	}

	@Override
	public void deleteFlight(long flightNumber) {
	
		
	Flight b =	entitymanager.find(Flight.class,flightNumber);
	 entitymanager.remove(b);
	
		
	}

	@Override
	public List<Flight> getAll() {
		
		TypedQuery<Flight> query = entitymanager.createQuery("from Flight Table", Flight.class);
		return query.getResultList();
	
	}

}
