package service;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

public class MakeCode {
	public static void main(String[]args) {
		GregorianCalendar obj = new GregorianCalendar();
		String date = Integer.toString(obj.getWeekYear())+(GregorianCalendar.DAY_OF_WEEK+1)+GregorianCalendar.DATE;
		System.out.println(date);
		System.out.println(UUID.randomUUID().toString().substring(0,6));
	}
	
}
