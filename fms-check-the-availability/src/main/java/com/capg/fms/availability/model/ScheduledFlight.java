package com.capg.fms.availability.model;

public class ScheduledFlight {

	private Flight flight;
	private int availableSeats;
	private Schedule schedule;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [flight=" + flight + ", availableSeats=" + availableSeats + ", schedule=" + schedule
				+ "]";
	}

}
