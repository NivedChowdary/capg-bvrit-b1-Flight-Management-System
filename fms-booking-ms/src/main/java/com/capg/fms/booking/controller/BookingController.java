package com.capg.fms.booking.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.service.IBookingService;

@RestController
@RequestMapping("/boooking")
public class BookingController {
	
	@Autowired
	IBookingService service;
	
	@GetMapping("/id/{bookingId}")
	public Booking getBooking(@PathVariable long bookingId) {
		return service.getBooking(bookingId);
	}
	
	@GetMapping("/all")
	public List<Booking> getAllBooking(){
		return service.getAllBooking();	
	}
	
	@PostMapping("/add")
	public Booking addBooking(@RequestBody Booking booking) {
		return service.addBooking(booking); 
	}

	@PostMapping("/modify")
	public Booking modifyBooking(Booking booking) {
		return service.modifyBooking(booking);
	} 
	
	@DeleteMapping("/delete/{bookingId}")
	public boolean deleteBooking(@PathVariable long bookingId) {
		return service.deleteBooking(bookingId);
	}
	
}
