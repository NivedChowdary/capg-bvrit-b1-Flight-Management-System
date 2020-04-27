package com.capg.fms.schedule.service;


import java.util.List;

import javax.print.attribute.standard.SheetCollate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		  ScheduledFlight scheduledFlight1 = new ScheduledFlight();
		  scheduledFlight1.setFlightNumber(scheduledFlight.getFlightNumber());
		  Schedule schedule = new Schedule();
		  schedule.setArrivalTime(schedule.getArrivalTime()); 
		  Schedule schedule1= new Schedule();
		  schedule1.setDepartureTime(schedule1.getDepartureTime());
		  Schedule schedule2= new Schedule();
		  schedule2.setSourceAirport(schedule.getSourceAirport());
		  Schedule schedule3 = new Schedule();
		  schedule3.setDestinationAirport(schedule.getDestinationAirport());
		  scheduledFlight.setAvailableSeats(scheduledFlight.getAvailableSeats());
		  scheduledFlight.setTicketcost(scheduledFlight.getTicketcost());
		  scheduledFlight.setFlightNumber(scheduledFlight.getFlightNumber());
		  ScheduledFlight scheduledFlight2 = new ScheduledFlight(scheduledFlight.getScheduleFlightId(),scheduledFlight.getAvailableSeats(),scheduledFlight.getFlightNumber(), schedule3, schedule1, schedule2,schedule,scheduledFlight.getTicketcost());
		  return repo.save(scheduledFlight2);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {
		// TODO Auto-generated method stub
		return repo.findById(scheduleId).get();
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(long flightNumber, Schedule schedule, int scheduleId) {
		// TODO Auto-generated method stub
		
		  ScheduledFlight scheduledFlight = repo.findById(scheduleId).get();
		  if(scheduledFlight != null) {
		  schedule.setArrivalTime(schedule.getArrivalTime()); 
		  Schedule schedule1= new Schedule();
		  schedule1.setDepartureTime(schedule1.getDepartureTime());
		  Schedule schedule2= new Schedule();
		  schedule2.setSourceAirport(schedule.getSourceAirport());
		  Schedule schedule3 = new Schedule();
		  schedule3.setDestinationAirport(schedule.getDestinationAirport());
		  scheduledFlight.setAvailableSeats(scheduledFlight.getAvailableSeats());
		  scheduledFlight.setTicketcost(scheduledFlight.getTicketcost());
		  scheduledFlight.setFlightNumber(scheduledFlight.getFlightNumber());
		  ScheduledFlight scheduledFlight1 = new ScheduledFlight(scheduledFlight.getScheduleFlightId(),scheduledFlight.getAvailableSeats(),scheduledFlight.getFlightNumber(), schedule3, schedule1, schedule2,schedule,scheduledFlight.getTicketcost());
		  return repo.save(scheduledFlight1);
		  }
		 
		return null;
	}

	@Override
	public void deleteScheduledFlight(int scheduleId) {
		repo.deleteById(scheduleId);
		
	}

}
