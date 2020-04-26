package com.capg.fms.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.service.ScheduleServiceImpl;

@RestController
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl service;
	

}
