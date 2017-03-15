package usefulMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	static WebDriver driver;
	public WaitTypes(WebDriver driver){
		this.driver = driver;
	}

	public static WebElement waitForElements(By locator, int timeout){
		WebElement element = null;
		
		try {
			System.out.println("Waiting for maximum " + timeout + " for the element to appear");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("element appeared yaaayyy");
		} catch (Exception e) {
			System.out.println("Element did not appear");
		}
		
		
		return element;
	}
	public WebElement clickElement(By locator, int timeout){
		WebElement element = null;
		
		try {
			System.out.println("Waiting for maximum " + timeout + " for the element to click");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("element clicked");
		} catch (Exception e) {
			System.out.println("Element did not appear");
		}
		
		
		return element;
	}
}
