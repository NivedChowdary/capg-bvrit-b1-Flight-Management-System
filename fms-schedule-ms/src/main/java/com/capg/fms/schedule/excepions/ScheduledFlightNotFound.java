/***************************************************************
 -Author                : Nived Chowdary
 -Created/Modified Date : 28/04/2020
 -Description           : Exception For ScheduledFlight
 
*******************************************************************/
package com.capg.fms.schedule.excepions;

public class ScheduledFlightNotFound extends RuntimeException {

	public ScheduledFlightNotFound(String message) {

		super(message);

	}

}
