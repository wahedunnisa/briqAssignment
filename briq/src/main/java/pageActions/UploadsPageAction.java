package pageActions;

import java.io.File;
import org.testng.Assert;

import pagesObjects.UploadsPage;
import utils.FilesUtility;
import webDriverSetup.WebDriverSetup;

public class UploadsPageAction extends WebDriverSetup {
	
	
	//Navigating to Uploads page
	public void goToPage() {
		driver = gotoURL(UploadsPage.URL);
	}
	
	//Uploading file into uploadfile input
	public void uploadFiles() {
		
		File downloadedFile = new FilesUtility().downloadedFile();
		if(downloadedFile != null) {
			driver.findElement(UploadsPage.uploadFile).sendKeys(downloadedFile.toString());
		}	
	}
	
	//Clicking on upload button
	public void clickUpload() {	
		driver.findElement(UploadsPage.submitButton).click();	
	}

	//Validating if the upload is successful
	public void validateSuccessfulUpload() {
		
		Assert.assertTrue(driver.findElement(UploadsPage.fileUploadedValidationElement).isDisplayed());
	}
}
