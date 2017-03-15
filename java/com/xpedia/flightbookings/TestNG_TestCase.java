package com.xpedia.flightbookings;
import advanced.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG_TestCase  {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(log4j.class);

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4jCA.properties");
	}

	@Test
	public void testMethod() {
		driver.get(baseUrl);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDateTextBox(driver, "12/25/2016");
		SearchPage.fillReturnDateTextBox(driver, "12/31/2016");
		SearchPage.clickOnSearchButton(driver);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
