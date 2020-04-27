package com.capg.fms.schedule.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.fms.schedule.model.Flight;

@Repository
public interface IAvailabilityFlightRepo extends JpaRepository<Flight, Long> {
	
	@Query(value="from Flight where flightNumber=:flightNumber")
	List<Flight> findByFlightNumber(long flightNumber);
}
