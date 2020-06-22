package com.cab.booking.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.booking.entity.Tuple2;
import com.cab.booking.service.CalendarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@RequestMapping(value = "/days" , method = RequestMethod.GET)
	public String getDays(@RequestParam Integer year, @RequestParam Integer month) {
		ObjectMapper mapper = new ObjectMapper();
		Map<Integer,String> days = new HashMap<>();
		List<Tuple2> holidays = calendarService.getHolidays(year, month);
		try {
			LocalDate localedate = LocalDate.of(year, month, 1);
			int numberOfDays = localedate.lengthOfMonth();
			for(int i=1; i<=numberOfDays;i++) {
				days.put(i, "");
			}
			holidays.forEach(e -> days.put(e.getDayNumber(), e.getHolidayDesc()));
			return mapper.writeValueAsString(days);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";		
	}

}
