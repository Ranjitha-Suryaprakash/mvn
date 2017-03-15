/*
package usefulMethods;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericDemo {
WebDriver driver;
String baseURL;
GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		gm = new GenericMethods(driver);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(4000);
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		WebElement q1 =gm.getElement("name", "id");
		try {
			q1.sendKeys("Ranjitha");
		} catch (NullPointerException e) {
			
			System.out.println("exception");
			e.getMessage();
		}
		Thread.sleep(2000);
			
		WebElement q3 = gm.getElement("Login","partiallinktext");
		q3.click();
		Thread.sleep(2000);
		
		WebElement q4 = gm.getElement("Practice","partiallinktext");
		q4.click();
		Thread.sleep(2000);
		
		WebElement q5 = gm.getElement("hdcbhjb", "id");
		try {
			q5.sendKeys("Ranjitha");
		} catch (NullPointerException e) {
			
			System.out.println("exception");
			e.getMessage();
		}
		
		}
		
    
	/*@Test
	public void test2() throws InterruptedException {
		driver.get(baseURL);
		List<WebElement> q1 =gm.getElementList("//input[@type='text']", "xpath");
		int e = q1.size();
		for(int y=0; y<e; y++)
		{
			System.out.println("the item is : "+ q1.get(y).getAttribute("type"));
		}
		
	}*/
    
	/*@Test
	public void test3() throws InterruptedException {
		driver.get(baseURL);
	boolean q1 =gm.isElementPresent("//input[@type='text']", "xpath");
	System.out.println("is element present in xpath query : " + q1);
	
	boolean q2 =gm.isElementPresent("name", "id");
	System.out.println("is element present in id query : " + q2);
	
	boolean q3 =gm.isElementPresent("ranju", "id");
	System.out.println("is element present in xpath query : " + q3);
	
}*/
