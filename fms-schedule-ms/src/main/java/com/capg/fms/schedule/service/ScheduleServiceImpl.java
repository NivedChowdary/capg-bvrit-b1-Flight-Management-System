package com.capg.fms.schedule.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IScheduleRepo;



@Service
public class ScheduleServiceImpl implements IScheduleService {

	
	@Autowired
	IScheduleRepo repo;
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(long flightNumber, Schedule schedule, int scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteScheduledFlight(int scheduleId) {
		// TODO Auto-generated method stub
		
	}

}
