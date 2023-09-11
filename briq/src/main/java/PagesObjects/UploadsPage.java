package PagesObjects;

import org.openqa.selenium.By;

public interface UploadsPage {
	
	String URL = "https://the-internet.herokuapp.com/upload";
	By uploadFile = By.id("file-upload");
	By submitButton = By.id("file-submit");
	By fileUploadedValidationElement = By.id("uploaded-files");

}
