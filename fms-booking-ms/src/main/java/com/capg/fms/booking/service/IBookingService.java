package com.capg.fms.booking.service;

import java.util.List;

import com.capg.fms.booking.model.Booking;

public interface IBookingService{
	
	Booking addBooking(Booking booking) ;
	
	Booking getBooking(long bookingId) ;
	
	List<Booking> getAllBooking();
  
	Booking modifyBooking(Booking booking) ;
	
	boolean deleteBooking(long bookingId);
}
