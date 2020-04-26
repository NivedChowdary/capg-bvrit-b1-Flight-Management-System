package com.capg.fms.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.fms.schedule.model.Flight;

public interface IAvailabilityFlightRepo extends JpaRepository<Flight, Long> {

}
