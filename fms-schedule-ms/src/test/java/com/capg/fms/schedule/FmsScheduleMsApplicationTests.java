package com.capg.fms.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.repository.IAvailabilityScheduleRepo;
import com.capg.fms.schedule.repository.IAvailabilityScheduledFlightRepo;
import com.capg.fms.schedule.service.IAvailabilityService;

@SpringBootTest
class FmsScheduleMsApplicationTests {
	
	@Autowired
	IAvailabilityService availabilityService;
	
	@Autowired
	IAvailabilityScheduleRepo repo;
	
	@Autowired
	IAvailabilityScheduledFlightRepo flightRepo;
	
	static ScheduledFlight scheduledFlight;

//	@Test
//	void contextLoads() {	
//	}
	@Test
	public void testFlightNnumber(){
		assertEquals(true, availabilityService.validateFlightId(4462336284L));
	}
}
