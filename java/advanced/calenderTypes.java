package advanced;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import usefulMethods.GenericMethods;
import usefulMethods.WaitTypes;

public class calenderTypes {
	WebDriver driver;
	String baseURL;
	WaitTypes wait;
	GenericMethods gm;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseURL = "https://www.expedia.com/";
		wait = new WaitTypes(driver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	//div[@class='datepicker-cal-month'][position()=1]
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();

	}

	@Test
	public void test() {
		driver.get(baseURL);
		wait.clickElement(By.id("tab-flight-tab"), 3);
		wait.clickElement(By.id("flight-departing"),1);
		WebElement w1 = gm.getElement(".//div[@class='datepicker-cal-month'][position()=1]", "xpath");
		List<WebElement> l1 = w1.findElements(By.tagName("button"));

		/*for(WebElement s : l1){
			System.out.println("the date is : " + s.getText());
		}*/

		for(WebElement date : l1){

			if(date.getText().equals("30")){
				System.out.println("clicked : "+date.getText());
				date.click();

				break;
			}
		} 

	}

}
