package testNG;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rubaround {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		WebElement e;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		String url = "https://www.expedia.com/Flights-Search?trip=roundtrip&leg1=from:New%20York,to:Chicago,departure:12/28/2016TANYT&leg2=from:Chicago,to:New%20York,departure:12/31/2016TANYT&passengers=children:0,adults:1,seniors:0,infantinlap:Y&mode=search";
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		e = wait.until(ExpectedConditions.elementToBeClickable(By.id("stopFilter_stops-0")));
		//e = driver.findElement(By.id("stopFilter_stops-0"));
		//Thread.sleep(3000);
		e.click();
		boolean b = e.isSelected();
		
		System.out.println("found 1"+ b);
		e = driver.findElement(By.id("leg0-morning-departure"));
		e.click();
		boolean c = e.isSelected();
		System.out.println("found 2"+ c);
		
		

	}

}
