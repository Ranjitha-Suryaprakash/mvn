package advanced;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IFrames {

	private WebDriver driver;
	private String baseURL;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver = new FirefoxDriver();
		js=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(3000);
		driver.close();

	}

	@Test
	public void test() throws InterruptedException {
		WebElement box = driver.findElement(By.id("name"));
		box.sendKeys("test started");
		Thread.sleep(3000);

		//switch to frame by id
		driver.switchTo().frame("courses-iframe");
		////div[@class='btn-group']//button  Software IT (1)
		//div[contains(text(),'Category:')]//following-sibling::div//button//following-sibling::ul//li//a[text()='All']
		driver.findElement(By.xpath("//div[contains(text(),'Category:')]//following-sibling::div//button")).click();
		Thread.sleep(3000);
		//button//following-sibling::ul//li//a[text()='All']
		driver.findElement(By.xpath("//button//following-sibling::ul//li//a[text()='Software IT (1)']")).click();
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, -1000);");
		box.clear();
		box.sendKeys("test 1 finished");
		Thread.sleep(3000);


		// switch to frame by name
		driver.switchTo().frame("iframe-name");
		WebElement f1 = driver.findElement(By.id("search-courses"));
		f1.sendKeys("Python");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, -1000);");
		box.clear();
		box.sendKeys("test 2 finished");
		Thread.sleep(3000);

		// switch to frame by id
		driver.switchTo().frame(0);
		WebElement f2 = driver.findElement(By.id("search-courses"));
		f2.clear();
		f2.sendKeys("Selenium");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, -1000);");
		box.clear();
		box.sendKeys("test 3 finished");
		Thread.sleep(3000);
	
	}

}
