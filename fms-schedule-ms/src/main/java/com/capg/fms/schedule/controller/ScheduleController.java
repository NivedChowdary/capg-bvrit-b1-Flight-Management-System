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

import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/scheduleflight")
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl service;

	@PostMapping("/addscheduledflight")
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {
		ScheduledFlight scheduleFlight1 = service.addScheduleFlight(scheduledFlight);
		return scheduleFlight1;
	}

	@GetMapping("/getscheduledflight{scheduleId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable int scheduleId) {

		return service.viewScheduledFlight(scheduleId);

	}

	@GetMapping(value = "/getallscheduledflight")
	public List<ScheduledFlight> viewScheduledFlight() {

		return service.viewScheduledFlight();

	}

	@PostMapping("/modifyscheduledflight")
	public ScheduledFlight modifyScheduledFlight(@PathVariable long flightNumber, @RequestBody Schedule schedule,
			@PathVariable int scheduleId) {

		ScheduledFlight scheduledFlight = service.modifyScheduledFlight(flightNumber, schedule, scheduleId);

		return scheduledFlight;

	}

	@DeleteMapping("/deletescheduledflight/{scheduleid}")
	public String deleteScheduledFlight(@PathVariable int scheduleId) {
		service.deleteScheduledFlight(scheduleId);
		return "Flight schedule deleted";
	}
}
