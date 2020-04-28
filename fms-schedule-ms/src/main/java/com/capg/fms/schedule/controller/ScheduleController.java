package com.capg.fms.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/scheduleflight")
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl service;

	@PostMapping("/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

		return service.addScheduleFlight(scheduledFlight);

	}

	@GetMapping("/id/{scheduleId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable int scheduleId) {

		return service.viewScheduledFlight(scheduleId);
	}

	@GetMapping("/viewall")
	public List<ScheduledFlight> viewScheduledFlight() {

		return service.viewScheduledFlight();
	}

	@DeleteMapping("/delete/{scheduleId}")
	public void deleteScheduledFlight(@PathVariable int scheduleId) {
		service.deleteScheduledFlight(scheduleId);
	}

	@PostMapping("/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

		return service.modifyScheduledFlight(scheduledFlight.getScheduledFlightId(),
				scheduledFlight.getAvailableSeats(), scheduledFlight.getFlightNumber(), scheduledFlight.getSchedule());
	}

}