package utils;

import java.io.File;

public class FilesUtility {

	public File[] allDownloadedFiles() {
		File[] allFiles = new File(Contants.downloadesPath()).listFiles();
		return allFiles;
	}
	
	public File downloadedFile() {
		if(allDownloadedFiles().length != 0 ) {
			return allDownloadedFiles()[0];
		}
		else {
			return null;
		}
	}
	
}
