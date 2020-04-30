package com.capg.fms.addflights.repo;


import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

import com.capg.fms.addflights.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{


}
