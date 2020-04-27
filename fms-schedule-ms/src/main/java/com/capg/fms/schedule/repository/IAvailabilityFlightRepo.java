package com.capg.fms.schedule.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.ScheduledFlight;

@Repository
public interface IAvailabilityFlightRepo extends JpaRepository<Flight, Long> {
	
	@Query(value="from ScheduledFlight where flightNumber=:flightNumber")
	List<Flight> findByFlightNumber(long flightNumber);

}
