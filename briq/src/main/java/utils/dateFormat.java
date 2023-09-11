package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dateFormat {

	public static String currentDate() {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("MM-DD-YY-HH-MM-SS");
        return dateformat.format(Calendar.getInstance().getTime());
		
	}

}
