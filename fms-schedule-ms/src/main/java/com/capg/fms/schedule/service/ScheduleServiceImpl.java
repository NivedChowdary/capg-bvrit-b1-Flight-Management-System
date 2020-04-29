/*************************************************************************
 -Author                : Nived 
 -Created/Modified Date : 28/04/2020
 -Description           : ScheduleServiceImpl implements IScheduleService
 						  for Schedule Management System
***************************************************************************/
package com.capg.fms.schedule.service;

import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.schedule.excepions.ScheduleAlreadyExistException;
import com.capg.fms.schedule.excepions.ScheduledFlightNotFound;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IScheduleRepo;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	IScheduleRepo repo;
	ScheduledFlight scheduleFlightobj;

	/*************************************************************************
	 -FunctionName          : addScheduleFlight
	 -Input Parameters      : ScheduledFlight Object
	 -Return Type           : ScheduledFlight
	 -Throws				: ScheduleAlreadyExistException
	 -Author				: Nived 
	 -Creation Date			: 28/04/2020
	 -Description			: Adding Schedule to database
	***************************************************************************/
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {
		if (repo.existsById(scheduledFlight.getScheduledFlightId())) {
			throw new ScheduleAlreadyExistException("Schedule Already exists by this Id");
		}
		return repo.save(scheduledFlight);
	}

	/*************************************************************************
	 -FunctionName          : viewScheduleFlight
	 -Input Parameters      : ScheduledFlightId
	 -Return Type           : ScheduledFlight
	 -Throws				: ScheduledFlightNotFound
	 -Author				: Nived 
	 -Creation Date			: 28/04/2020
	 -Description			: Viewing ScheduledFlight based on Id
	***************************************************************************/
	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {
		// TODO Auto-generated method stub
		if (!repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		return repo.findById(scheduleId).get();
	}

	/*************************************************************************
	 -FunctionName          : viewScheduleFlight
	 -Input Parameters      : None
	 -Return Type           : ScheduledFlight
	 -Throws				: None
	 -Author				: Nived 
	 -Creation Date			: 28/04/2020
	 -Description			: Viewing ScheduledFlight List
	***************************************************************************/
	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	/*************************************************************************
	 -FunctionName          : deleteScheduleFlight
	 -Input Parameters      : ScheduledFlightId
	 -Return Type           : Void
	 -Throws				: ScheduledFlightNotFound
	 -Author				: Nived 
	 -Creation Date			: 28/04/2020
	 -Description			: delete ScheduledFlight based on Id
	***************************************************************************/
	@Override
	public void deleteScheduledFlight(int scheduleId) {
		if (!repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		repo.deleteById(scheduleId);

	}

	/*************************************************************************
	 -FunctionName          : modifyScheduleFlight
	 -Input Parameters      : ScheduledFlightId,availableSeats,flightNumber,schedule
	 -Return Type           : ScheduledFlight
	 -Throws				: ScheduledFlightNotFound
	 -Author				: Nived 
	 -Creation Date			: 28/04/2020
	 -Description			: Modify ScheduledFlight 
	***************************************************************************/
	@Override
	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule) {
		// TODO Auto-generated method stub

		// if (!repo.existsById(scheduleFlightobj.getScheduledFlightId()))
		if (!repo.existsById(scheduledFlightId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		ScheduledFlight scheduledFlight = repo.getOne(scheduledFlightId);
		scheduledFlight.setAvailableSeats(availableSeats);
		scheduledFlight.setFlightNumber(flightNumber);
		scheduledFlight.setSchedule(schedule);
		repo.save(scheduledFlight);

		return scheduledFlight;
	}

}
