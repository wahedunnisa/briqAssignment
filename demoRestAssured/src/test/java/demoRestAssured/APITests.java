package demoRestAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import APIBase.API;

public class APITests {


	@BeforeTest
	public void setURL() {
		API.setBaseURL();
	}

	@Test(priority = 1)
	public void response() {
		API.ResponseonGET();
	}

	@Test(priority = 2)
	public void saveResponseFile() {
		API.saveResponseInFile();
	}

	@Test(priority= 3)
	public void saveResponseCSV(){
		API.addIsRoofAttribute();
		API.saveResponseInCSV();
	}

}
