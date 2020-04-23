package com.capg.fms.addflights.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class Booking {

	private BigInteger bookingId;
	private User userId;
	private LocalDate bookingDate;
	private List<Passenger> passengerList;
	private double ticketCost;
	private Flight flight;
	private int noOfPassengers;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(BigInteger bookingId, User userId, LocalDate bookingDate, List<Passenger> passengerList,
			double ticketCost, Flight flight, int noOfPassengers) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.flight = flight;
		this.noOfPassengers = noOfPassengers;
	}

	public BigInteger getBookingId() {
		return bookingId;
	}

	public void setBookingId(BigInteger bookingId) {
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

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
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
