package com.capg.fms.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.fms.booking.model.Booking;
import com.capg.fms.booking.repository.IBookingRepo;


@Service
public class BookingServiceImpl implements IBookingService  {

	@Autowired
	IBookingRepo repo;
	
	@Override
	public Booking addBooking(Booking booking) {
		return repo.save(booking);
	}

	@Override
	public Booking getBooking(long bookingId) {
		return repo.getOne(bookingId);
	}

	@Override
	public List<Booking> getAllBooking() {
		return repo.findAll();
	}

	@Override
	public Booking modifyBooking(Booking newBooking) {
		Booking booking=repo.getOne(newBooking.getBookingId());
		booking.setUserId(newBooking.getUserId());
		booking.setBookingDate(newBooking.getBookingDate());
		booking.setPassengerList(newBooking.getPassengerList());
		booking.setTicketCost(newBooking.getTicketCost());
		booking.setFlightNumber(newBooking.getFlightNumber());
		booking.setNoOfPassengers(newBooking.getNoOfPassengers());
		return booking;
	}

	@Override
	public boolean deleteBooking(long bookingId) {
		repo.deleteById(bookingId);
		return !repo.existsById(bookingId);
	}
	
		
}
