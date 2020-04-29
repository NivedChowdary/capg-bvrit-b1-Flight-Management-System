/***************************************************************
 -Author                : Nived Chowdary
 -Created/Modified Date : 28/04/2020
 -Description           : Repository Interface implements JPARepo
 						  for all crud methods
*******************************************************************/
package com.capg.fms.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.ScheduledFlight;

public interface IScheduleRepo extends JpaRepository<ScheduledFlight, Integer> {

}
