package utils;

import java.io.File;

public class Contants {


	//String downloadesPath2 = System.getProperty("user.dir")+"\\DownloadedFiles";

	public static String downloadesPath() {
		String FilePath = System.getProperty("user.home")+"\\briq";
		File path = new File(FilePath);
		if (!path.exists()){
			path.mkdirs();
		}

		return FilePath;
	}

}
