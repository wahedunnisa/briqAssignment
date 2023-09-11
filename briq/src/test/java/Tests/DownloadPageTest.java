package Tests;

import org.testng.annotations.Test;

import pageActions.DownloadsPageAction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DownloadPageTest {

	DownloadsPageAction downloadPage = new DownloadsPageAction();



	@BeforeClass
	public void beforeclass() {
		
		downloadPage.ChromeDriverSetup();
		
	}

	@AfterClass
	public void afterClass() {
		downloadPage.quitBrowser();
	}
	
	
	@Test(priority = 0)
	public void downloadFiles() {
		downloadPage.goToPage();
	}
	
	@Test(priority = 1)
	public void validatePage() {
		downloadPage.validateLandingPage();
	}
	
	@Test(priority = 2)
	public void dowloadFiles(){
		downloadPage.downloadAllFiles();
	}

}
