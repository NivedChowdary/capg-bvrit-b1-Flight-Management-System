package com.capg.fms.schedule.service;

import java.util.List;

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;

public interface IScheduleService {
	
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight viewScheduledFlight(int scheduleId);
	
	public List<ScheduledFlight> viewScheduledFlight();

	public ScheduledFlight modifyScheduledFlight(long flightNumber, Schedule schedule, int scheduleId);
	
	public void deleteScheduledFlight(int scheduleId);

}


