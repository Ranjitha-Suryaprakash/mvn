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

public class AutoComplete {
WebDriver driver;
GenericMethods gm;
WaitTypes wait;
String baseURL;
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		baseURL = "https://www.southwest.com/";
		wait = new WaitTypes(driver);
		driver.manage().window().maximize();
	}

	

	@Test
	public void test() {
		//New Orleans,LA-MSY
				String searchText = "Boston Logan, MA - BOS";
				String partialText = "new";
				driver.get(baseURL);
				
				WebElement t = gm.getElement("air-city-departure", "id");
				t.sendKeys(partialText);
				
				WebElement t2 = gm.getElement("js-menu-wrapper", "id");
				
				List<WebElement> sugg = t2.findElements(By.tagName("li"));
				for(int i=0;i<sugg.size();i++){
					System.out.println("the suggestion contains : " + sugg.get(i).getText());
				}
				for(WebElement t3 : sugg){
					if(t3.getText().equals(searchText)){
						System.out.println("gotta match");
						t3.click();
					}
				}
				
				
				
	}
	

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(5000);
		driver.quit();
	
	}

}
