package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatter {

	public static String requiredFormat() {

		SimpleDateFormat dateformat = new SimpleDateFormat(Constants.requiredDateFormat);
		return dateformat.format(Calendar.getInstance().getTime());

	}


}
