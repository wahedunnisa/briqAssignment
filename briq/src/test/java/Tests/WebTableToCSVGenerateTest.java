package Tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import PagesObjects.DownloadsPage;
import pageActions.WebTableToCVSGeneratePageAction;
import utils.FilesUtility;
import webDriverSetup.WebDriverSetup;

public class WebTableToCSVGenerateTest {
	
	
	WebTableToCVSGeneratePageAction page = new WebTableToCVSGeneratePageAction();
	
	
	@BeforeClass
	public void beforeclass() {
		page.ChromeDriverSetup();
	}
	
	@Test
	public void gotoPage() {
		page.goToPage();
	}
	
	@Test(priority = 1)
	public void validatePage() {
		page.validateLandingPage();
	}
	
	
	@Test(priority = 2)
	public void downloadFiles(){
		page.readDataIntoTable();
		page.generateCSVFile();
	
	}
	
	@AfterClass
	public void aftercall() {
		page.quitBrowser();
	}
}




