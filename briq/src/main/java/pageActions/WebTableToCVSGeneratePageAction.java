package pageActions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.opencsv.CSVWriter;

import PagesObjects.WebTableToCSVGeneratePage;
import utils.Contants;
import utils.dateFormat;
import webDriverSetup.WebDriverSetup;

public class WebTableToCVSGeneratePageAction extends WebDriverSetup{

	//Initializing Table
	private ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();

	//Navigating to webpage
	public void goToPage() {
		driver = gotoURL(WebTableToCSVGeneratePage.URL);
	}

	//Validating if we are in webpage
	public void validateLandingPage() {
		Assert.assertTrue(driver.findElement(WebTableToCSVGeneratePage.elementInPage).isDisplayed());
	}

	//Reading data on wenpage into the table
	public void readDataIntoTable() {		
		List<WebElement> columns = driver.findElements(WebTableToCSVGeneratePage.columnsLocator);
		int rows = driver.findElements(WebTableToCSVGeneratePage.rowsLocator).size();

		for(int i = 0 ; i<rows; i++) table.add(new ArrayList());

		for(int i=0;i<columns.size()-1 ; i++) {

			table.get(0).add(columns.get(i).getText());
		}

		for(int i = 1; i<rows ; i++) {
			//Reading data rows and storing in arraylist
			for(int j = 1;j<columns.size();j++) {		
				table.get(i).add(driver.findElement(By.xpath(WebTableToCSVGeneratePage.cellPartialLocator+String.valueOf(i)+"]/td["+String.valueOf(j)+"]")).getText());
			}
		}
		this.table = table;	
	}

	//Stroing the data into csv file
	public void generateCSVFile() {
		try {

			File file = new File(Contants.downloadesPath+"/webtable_"+dateFormat.currentDate()+".csv");
			CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
			for(ArrayList<String> row : table) {
				String[] rowStr = row.toArray(new String[row.size()]);
				csvWriter.writeNext(rowStr);
			}
			csvWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
