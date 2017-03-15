package testNG;

import org.testng.annotations.Test;
import org.testng.internal.ITestResultNotifier;

import java.util.NoSuchElementException;
import usefulMethods.ScreenShots;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Assert_Fail_Screenshot {
	
	
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		baseUrl = "http://www.letskodeit.com/";
		driver = new FirefoxDriver();

		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test1_invalidCredentials() throws Exception {
		
		
		
		WebElement signup = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signup.click();
		
		WebElement login = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		login.click();
		
		WebElement email = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		System.out.println("email found");
		
		email.click();
		Thread.sleep(5000);
		
		email.sendKeys("test1@email.com");
		WebElement pass = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		System.out.println("pass found");
		pass.click();
		Thread.sleep(5000);
		pass.sendKeys("abcabc");
		
		WebElement go = driver.findElement(By.xpath("//div[@id='memberLoginDialogoklink']//span"));
		System.out.println("go button found");
		Thread.sleep(5000);
		go.click();
		
        Thread.sleep(3000);
		
		WebElement welcomeText = null;
		
		try{
		welcomeText=driver.findElement(By.xpath(".//div[@id='comp-iiqg1vggmemberTitle']"));
		}		
		catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("not founsd");
			
		}
		
		
			
		Assert.assertTrue(welcomeText!=null);
		
  }
  @AfterMethod
  public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			ScreenShots.takeScreenshot(driver, testResult.getName());
		}
		else{
			System.out.println("result is : " + testResult.getStatus());
		}
		
		driver.quit();
	}

  

}
