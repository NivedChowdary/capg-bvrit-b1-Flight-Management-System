package com.capg.fms.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.fms.schedule.model.ScheduledFlight;

@Repository
public interface IAvailabilityFlightRepo extends JpaRepository<ScheduledFlight, Long> {

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.flightNumber = :flightNumber")
	public boolean existsByFlightNumber(long flightNumber);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.availableSeats = :availableSeats")
	public boolean checkAvailableSeats(int availableSeats);
	

}
