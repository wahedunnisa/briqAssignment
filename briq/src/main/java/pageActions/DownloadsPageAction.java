package pageActions;

import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import PagesObjects.DownloadsPage;
import webDriverSetup.WebDriverSetup;

public class DownloadsPageAction extends WebDriverSetup {
	

	//Navigating to Downloads Web page
	public void goToPage() {
		driver = gotoURL(DownloadsPage.URL);
	}
	

	//Validating if we landed on downloads page
	public void validateLandingPage() {
		Assert.assertTrue(driver.findElement(DownloadsPage.pageElement).isDisplayed());
	}
	
	//Fetching all the files that are to be downloaded
	public List<WebElement> getDownloadElements() {
		return driver.findElements(DownloadsPage.allDownloadElements);
	}
	
	//Downloading all files
	public void downloadAllFiles() {
		List<WebElement> downloadElementsList = this.getDownloadElements();
		for(WebElement element : downloadElementsList) {
			if(!element.getText().contains(".png") ) {
				element.click();
			}
		}
	}
	
	
}
