package pagesObjects;

import org.openqa.selenium.By;

public interface DownloadsPage {
	
	String URL = "https://the-internet.herokuapp.com/download";
	By allDownloadElements = By.xpath("//*[@id='content']//a");
	
	By pageElement = By.xpath("//*[@id='content']//h3");

}
