package com.cab.booking.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CalendarificResponse {
	
	private Meta meta;
	
	private Response response;

	public static class Meta {

		private Integer code;

		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
	}
	
	public static class Response {
		private List<Holiday> holidays;
		public List<Holiday> getHolidays() {
			return holidays;
		}
		public void setHolidays(List<Holiday> holidays) {
			this.holidays = holidays;
		}
	}
	
	public static class Holiday {
		private String name;
		private Date date;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		
		
	}
	
	public static class Date {
		private DateTime  datetime;
		public DateTime getDatetime() {
			return datetime;
		}
		public void setDatetime(DateTime datetime) {
			this.datetime = datetime;
		}
	}
	
	public static class DateTime {
		private int year;
		private int month;
		private int day;
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
	
	
}
