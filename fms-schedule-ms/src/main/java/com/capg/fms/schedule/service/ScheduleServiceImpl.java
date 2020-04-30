package com.capg.fms.schedule.service;


import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.schedule.excepions.ScheduledFlightNotFound;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IScheduleRepo;



@Service
public class ScheduleServiceImpl implements IScheduleService {

	
	@Autowired
	IScheduleRepo repo;
	ScheduledFlight scheduleFlightobj;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {
		 return repo.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {
		// TODO Auto-generated method stub
		if (! repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		return repo.findById(scheduleId).get();
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void deleteScheduledFlight(int scheduleId) {
		if (! repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		repo.deleteById(scheduleId);
		
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule) {
		// TODO Auto-generated method stub
		
		//if (!repo.existsById(scheduleFlightobj.getScheduledFlightId())) 
		if (! repo.existsById(scheduledFlightId)) {
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
