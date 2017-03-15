package advanced;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopUps {

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
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		WebElement box = driver.findElement(By.id("name"));
		box.sendKeys("Ranjitha");
		
		WebElement A = driver.findElement(By.id("alertbtn"));
		A.click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		al.accept();
		
		Thread.sleep(3000);
		
		box.sendKeys("Akshay");
		WebElement C = driver.findElement(By.id("confirmbtn"));
		C.click();
		Thread.sleep(3000);
		al = driver.switchTo().alert();
		al.dismiss();
		
		
		
		
	}

}
