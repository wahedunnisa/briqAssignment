package utils;

import java.io.File;

public class Constants {

	public static String URL = "https://data.sfgov.org/resource/p4e4-a5a7.json";
	
	public static String requiredDateFormat = "MM-DD-YY-HH-MM-SS";
	
	public static String filepath() {
		String FilePath = System.getProperty("user.home")+"\\briq";
		File path = new File(FilePath);
		if (!path.exists()){
			path.mkdirs();
		}

		return FilePath;
	}

}
