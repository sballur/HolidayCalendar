package com.cab.booking.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cab.booking.entity.CalendarificResponse;
import com.cab.booking.entity.Tuple2;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CalendarificRestService {
	
	final String HOLIDAY_URL = "https://calendarific.com/api/v2/holidays?api_key=b1905a77a1f16d49f30cbeb956f4562aff4a92f3&country=IN&year=";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Map<Integer,List<Tuple2>> getYearHolidays(int year) {
		ResponseEntity<CalendarificResponse> result = null;
		
		for(int i=0; i<3; i++) {
			try {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
				result = (ResponseEntity<CalendarificResponse>) restTemplate.exchange(HOLIDAY_URL+year, HttpMethod.GET,entity,CalendarificResponse.class);
				if(null != result && 200 == result.getBody().getMeta().getCode()) {
					break;
				}
				System.out.println(new ObjectMapper().writeValueAsString(result.getBody()));
			} catch(Exception e) {
				System.out.println("Re-Trying to get list of holidays");
			}
		}
		
		
		Map<Integer, List<Tuple2>> mappedResponse = result
				.getBody()
				.getResponse()
				.getHolidays()
				.stream()
				.collect(groupingBy(e -> e.getDate().getDatetime().getMonth(), mapping(e -> new Tuple2(e.getDate().getDatetime().getDay(), e.getName()), toList())));
		
		return mappedResponse;
	}

}
