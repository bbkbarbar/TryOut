package hu.barbar.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHandler {

	public static String DATE_FORMAT_PATTERN = "yyyy.MM.dd HH:mm:ss";
	
	public static final int SECONDS_IN_AN_HOUR = 3600;
	public static final int SECONDS_IN_A_MINUTE = 60;
	
	
	@SuppressWarnings("deprecation")
	public static Date getOccurrenceInNext24h(Date baseDate, int h, int m, int s){
		
		if(baseDate == null){
			return null;
		}
		
		int hour = getValueInRange(h, 24);
		int min  = getValueInRange(m, 60);
		int sec  = getValueInRange(s, 60);
		
		int baseHour = baseDate.getHours();
		int baseMin =  baseDate.getMinutes();
		int baseSec =  baseDate.getSeconds();
		
		int baseTimeInSec = getTimeInSecondsOfDay(baseHour, baseMin, baseSec);
		int specifiedTimeInSec = getTimeInSecondsOfDay(hour, min, sec);
		
		boolean nextOccuranceWillInBaseDay = baseTimeInSec < specifiedTimeInSec;
		
		Date result;
		if(nextOccuranceWillInBaseDay){
			result = baseDate;
		}else{
			result = plusDay(baseDate, 1);
		}
		
		result.setHours(hour);
		result.setMinutes(min);
		result.setSeconds(sec);
		
		return result;
	}
	
	
	public static Date plusDay(Date d, int day){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, day);
		return c.getTime();
	}
	
	
	private static int getTimeInSecondsOfDay(int hour, int min, int sec){
		return ((SECONDS_IN_AN_HOUR * hour) +
				(SECONDS_IN_A_MINUTE * min) +
				sec)
		;
	}
	
	private static int getValueInRange(int value, int rangeMax){
		int res = value;
		while (res < 0){
			res += rangeMax;
		}
		while (res >= rangeMax){
			res -= rangeMax;
		}
		return res;
		
	}

	
	public static String getDateStr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		return sdf.format(date);
	}
	
	
}
