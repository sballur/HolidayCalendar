package com.cab.booking.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.booking.entity.Tuple2;

@Service
public class CalendarService {
	
	static private Map<Integer,Map<Integer,List<Tuple2>>> holidaysMap= new HashMap<>(); 
	
	@Autowired
	private CalendarificRestService calendarificRestService;
	
	public List<Tuple2> getHolidays(Integer year,Integer month) {
		if(holidaysMap.containsKey(year)) {
			if(holidaysMap.get(year).containsKey(month)) {
				return holidaysMap.get(year).get(month);
			} else {
				return Collections.emptyList();
			}
		} else {
			Map<Integer, List<Tuple2>> map = calendarificRestService.getYearHolidays(year);
			holidaysMap.put(year, map);
			if(map.containsKey(month)) {
				return map.get(month);
			}
		}
		
		return Collections.emptyList();
	}
	

}
