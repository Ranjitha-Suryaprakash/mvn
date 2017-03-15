package advanced;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchWindowFocus {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	}


	@Test
	public void test() throws InterruptedException {

		driver.get(baseURL);
		WebElement box = driver.findElement(By.id("name"));
		box.sendKeys("test started");
		String parentHandler = driver.getWindowHandle();
		System.out.println("Parent Handler : " + parentHandler);

		WebElement w2 = driver.findElement(By.id("openwindow"));
		w2.click();

		Set<String> windowsList = driver.getWindowHandles();

		for(String current : windowsList){
			if(!current.equals(parentHandler)){
				driver.switchTo().window(current);
				System.out.println("Current Handler : " + current);
				driver.findElement(By.id("search-courses")).sendKeys("python");
				Thread.sleep(3000);
				driver.close();
				
			}
		}
		
		driver.switchTo().window(parentHandler);
		box.clear();
		box.sendKeys("test completed");
		
		
	}



	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}


}
