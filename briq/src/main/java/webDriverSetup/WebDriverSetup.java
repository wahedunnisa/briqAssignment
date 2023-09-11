package webDriverSetup;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Contants;

public class WebDriverSetup {
	
	protected WebDriver driver;
	
	public void ChromeDriverSetup() {
		if (this.driver == null) {
        	//Adding preferences
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", Contants.downloadesPath);
            prefs.put("profile.default_content_settings.popups", 0);
            prefs.put("safebrowsing.enabled", "false");

            // Adding capabilities to ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications","--headless");
            options.setExperimentalOption("prefs", prefs);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver(options);
        }

    }

	
	public WebDriver gotoURL(String url) {
		
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public void quitBrowser() {
		driver.close();
	}
	

}
