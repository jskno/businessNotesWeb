package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static Date getDateMinusXDays(int days) {
		
		Date returnedDate;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, days);  // number of days to add
		returnedDate = c.getTime();  // dt is now the new date
		return returnedDate;
	}
	
	public static String substractDays(String startDate, int days)
			throws ParseException {
		
		String endDate;  // Returned date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(startDate));
		c.add(Calendar.DATE, days);  // number of days to add
		endDate = sdf.format(c.getTime());  // dt is now the new date
		return endDate;
	}
	
	public static String now() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");
		String now = formatter.format(currentDate.getTime());
		return now;
	}

}
