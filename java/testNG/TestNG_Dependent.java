package testNG;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;



public class TestNG_Dependent {
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(TestNG_Dependent.class);
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
	}

	@Test
	public void searchFlights() throws Exception {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDateTextBox(driver, "12/28/2016");
		SearchPage.fillReturnDateTextBox(driver, "12/31/2016");
		SearchPage.clickOnSearchButton(driver);
	}

	@Test(dependsOnMethods={ "searchFlights" })
	public void selectMorning() {
		SearchPage.selectMorningFlight(driver);
	}

	@AfterClass
	public void afterClass() {
	}
}