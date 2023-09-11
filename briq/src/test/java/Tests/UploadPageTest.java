package Tests;


import org.testng.annotations.Test;

import pageActions.UploadsPageAction;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class UploadPageTest {


	UploadsPageAction uploadPage = new UploadsPageAction();


	@BeforeClass
	public void beforeclass() {
		uploadPage.ChromeDriverSetup();
	}

	@AfterClass
	public void afterClass() {
		uploadPage.quitBrowser();
	}

	@Test(priority = 1)
	public void gotoPage() {
		uploadPage.goToPage();
		
	}
	
	@Test(priority = 2)
	public void upload() {
		uploadPage.uploadFiles();
	}
	
	@Test(priority = 3)
	public void clickUpload() {
		uploadPage.clickUpload();
		
	}
	
	@Test(priority = 4)
	public void validateSuccessUpload() {
		uploadPage.validateSuccessfulUpload();
	}
	
}
