package testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import usefulMethods.WaitTypes;

import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;




public class testNG_RunTestSuite {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(testNG_RunTestSuite.class);
	WaitTypes wait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		wait = new WaitTypes(driver);

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4jCA.properties");
		driver.get(baseUrl);
	}

	@Test
	public void test1_fillBasicInfo() throws Exception {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDateTextBox(driver, "12/25/2016");
		SearchPage.fillReturnDateTextBox(driver, "12/31/2016");
		Thread.sleep(3000);
	}
	
	@Test
	public void test2_fillAdvancedInfo() {
		// Expedia remembers last settings, if you have previously visited the page clicked advanced options
		// Then next time, when automation runs that option will already be open
		// And automation will click it and this time it will close
		// And the test will fail because it will not be able to find not-stop and flight class checkboxes
		// We are adding If condition to find whether the advanced option is open or close
		WebElement e = driver.findElement(By.id("advanced-options"));
		String clicked = e.getAttribute("aria-expanded");
		System.out.println("found attribute");
		System.out.println("Value of aria-expanded is: " + clicked);
		if (clicked.contains("false")) {
			SearchPage.clickOnAdvancedLink(driver);
		}
		SearchPage.clickNonStopCheckBox(driver);
		SearchPage.selectFlightClass(driver, "first");
		SearchPage.clickOnSearchButton(driver);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		wait.waitForElements(By.id("stopFilter_stops-0"), 2);
		driver.quit();
	}

}
