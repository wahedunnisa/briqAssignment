package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageActions.WebTableToCVSGeneratePageAction;

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




