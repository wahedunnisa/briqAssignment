package pagesObjects;

import org.openqa.selenium.By;

public interface WebTableToCSVGeneratePage {
	
	
	String URL = "http://the-internet.herokuapp.com/challenging_dom";
	By elementInPage = By.cssSelector(".large-2.columns>a.button.alert");
	By rowsLocator = By.xpath("//table//tr");
	By columnsLocator = By.xpath("//table//th");	
	String cellPartialLocator = "//table//tbody//tr[";
	
	
}
