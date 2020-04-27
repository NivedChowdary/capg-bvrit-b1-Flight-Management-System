package com.capg.fms.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.flight.model.Flight;

public interface IFlightRepo extends JpaRepository<Flight, Long>{

}
