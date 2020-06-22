/**
 * 
 */
package com.cab.booking.entity;

/**
 * @author ashiva
 *
 */
public class Tuple2 {
	
	private final Integer dayNumber;
	
	private final String holidayDesc;
	
	public Tuple2(Integer dayNumber,String holidayDesc) {
		this.dayNumber = dayNumber;
		this.holidayDesc = holidayDesc;
	}

	public Integer getDayNumber() {
		return dayNumber;
	}

	public String getHolidayDesc() {
		return holidayDesc;
	}
}
