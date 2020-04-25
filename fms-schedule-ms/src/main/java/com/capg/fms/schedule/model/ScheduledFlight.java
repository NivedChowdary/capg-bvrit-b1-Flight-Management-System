package com.capg.fms.schedule.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduledFlight {

	@Id
	private Flight flight;
	private int availableSeats;
	private Schedule schedule;

	public ScheduledFlight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScheduledFlight(Flight flight, int availableSeats, Schedule schedule) {
		super();
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.schedule = schedule;
	}

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
