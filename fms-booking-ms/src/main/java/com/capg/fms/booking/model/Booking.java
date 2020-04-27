package com.capg.fms.booking.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking_info")
public class Booking {
    
	@Id
	private long bookingId;
	private User userId;
	
	@DateTimeFormat(pattern="yyyy/MM/ddThh:mm:ss")
	private LocalDate bookingDate;
	
	@ElementCollection
	private List<Long> passengerList;
	private double ticketCost;
	private Flight flight;
	private int noOfPassengers;

	public Booking() {	}

	public Booking(long bookingId, User userId, LocalDate bookingDate, List<Long> passengerList, double ticketCost,
			Flight flight, int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}


	public User getUserId() {
		return userId;
	}


	public void setUserId(User userId) {
		this.userId = userId;
	}


	public LocalDate getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}


	public List<Long> getPassengerList() {
		return passengerList;
	}


	public void setPassengerList(List<Long> passengerList) {
		this.passengerList = passengerList;
	}


	public double getTicketCost() {
		return ticketCost;
	}


	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	public int getNoOfPassengers() {
		return noOfPassengers;
	}


	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", userId=" + userId + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", flight=" + flight
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

}
