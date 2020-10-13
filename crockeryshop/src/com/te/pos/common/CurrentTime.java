package com.te.pos.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import sun.util.calendar.BaseCalendar.Date;

public class CurrentTime {
	public String getTime() throws ParseException {
		LocalDateTime dateTime = LocalDateTime.now(); // Gets the current date and time
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return  dateTime.format(formatter);		
	}

}
