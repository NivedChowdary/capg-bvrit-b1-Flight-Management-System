package com.capg.fms.schedule.model;

import javax.persistence.Entity;
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Table;

=======
import javax.persistence.Table;

import javax.persistence.Id;
>>>>>>> branch 'master' of https://github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git

<<<<<<< HEAD
@Entity
=======
//github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git


@Entity
@Table(name="Flight")
>>>>>>> branch 'master' of https://github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git
public class Flight {
    
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
=======
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
 //github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git
>>>>>>> branch 'master' of https://github.com/NivedChowdary/capg-bvrit-b1-flight-management-system.git
	public long flightNumber;
	public String flightModel;
	public String carrierName;
	public int seatCapacity;

	public Flight() {
		super();		
	}

	public Flight(long flightNumber, String flightModel, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightModel = flightModel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", flightModel=" + flightModel + ", carrierName=" + carrierName
				+ ", seatCapacity=" + seatCapacity + "]";
	}

}