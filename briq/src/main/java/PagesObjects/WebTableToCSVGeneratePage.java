package PagesObjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import webDriverSetup.WebDriverSetup;

public interface WebTableToCSVGeneratePage {
	
	
	String URL = "http://the-internet.herokuapp.com/challenging_dom";
	By elementInPage = By.cssSelector(".large-2.columns>a.button.alert");
	By rowsLocator = By.xpath("//table//tr");
	By columnsLocator = By.xpath("//table//th");	
	String cellPartialLocator = "//table//tbody//tr[";
	
	
}
