package testNG;



import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class param_dataProvider {
  
	private WebDriver driver;
	private String baseUrl;
	//static Logger log = Logger.getLogger(TestNG_Parameters_DataProviders.class);
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//PropertyConfigurator.configure("log4j.properties");
		driver.get(baseUrl);
	}
	
	@DataProvider(name = "datas")
	public static Object[][] datafields(){
		return new Object[][] {{"New York","chicago","12/26/2016","12/28/2016"},
				{"New York","boston","12/26/2016","12/28/2016"}};
		
	}
	
	@Parameters({"origin","dest","depDate","retDate"})
	@Test
  public void param(String origin,String dest,String depDate,String retDate ) 
		  throws Exception {
	  
		//SearchPage.clearAllFields(driver);
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, origin);
		SearchPage.fillDestinationTextBox(driver, dest);
		SearchPage.fillDepartureDateTextBox(driver, depDate);
		SearchPage.fillReturnDateTextBox(driver, retDate);
		Thread.sleep(5000);
		 }
		 
	@Test(dataProvider = "datas")
	public void searchWithMultipleData(String origin,
			String dest,String depDate,String retDate) throws InterruptedException{
		
		
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.clearAllFields(driver);
		Thread.sleep(5000);
		SearchPage.fillOriginTextBox(driver, origin);
		SearchPage.fillDestinationTextBox(driver, dest);
		SearchPage.fillDepartureDateTextBox(driver, depDate);
		SearchPage.fillReturnDateTextBox(driver, retDate);
		Thread.sleep(5000);
		
		
	}
	
	
}

