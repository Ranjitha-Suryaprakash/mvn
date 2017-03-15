package usefulMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {

	WebDriver driver;

	public GenericMethods(WebDriver driver){
		this.driver=driver;
	}

	public WebElement getElement(String locator,String type){
		type = type.toLowerCase();
            WebElement element ;         
		if(type.equals("id")){
			
			try {
				element =  this.driver.findElement(By.id(locator));
			} catch (NoSuchElementException e1) {
				
				
				System.out.println("not found");
				return null;
			}
		}
		else if(type.equals("name")){
			element = this.driver.findElement(By.name(locator));
		}
		else if(type.equals("xpath")){
			element = this.driver.findElement(By.xpath(locator));
		}
		else if(type.equals("css")){
			element = this.driver.findElement(By.cssSelector(locator));
		}
		else if(type.equals("partiallinktext")){
			element = this.driver.findElement(By.partialLinkText(locator));
		}
		else if(type.equals("linktext")){
			element = this.driver.findElement(By.linkText(locator));
		}

		else
		{
			System.out.println("Locator type not supported");
			return null;
		}
		
		String e = element.getTagName();
	   if(e.isEmpty()){
		   System.out.println("element not found");
		   return null;
		   
	   }
	   else{
		   System.out.println("Element found is : "+locator  + " and tagname is : "+e);
		   return element;
	   }
	}
	
	public List<WebElement> getElementList(String locator,String type){
		type = type.toLowerCase();

		List<WebElement> elementList = new ArrayList<WebElement>();

		if(type.equals("id")){

			elementList = this.driver.findElements(By.id(locator));
		}
		else if(type.equals("name")){
			elementList = this.driver.findElements(By.name(locator));
		}
		else if(type.equals("xpath")){
			elementList = this.driver.findElements(By.xpath(locator));
		}
		else if(type.equals("css")){
			elementList = this.driver.findElements(By.cssSelector(locator));
		}
		else if(type.equals("partiallinktext")){
			elementList = this.driver.findElements(By.partialLinkText(locator));
		}
		else if(type.equals("linktext")){
			elementList = this.driver.findElements(By.linkText(locator));
		}

		else
		{
			System.out.println("Locator type not supported");
			return null;
		}
        		
		if(elementList.isEmpty()){
			System.out.println("item not found with loctaor : " + locator);
			return null;
		}
		else{
			return elementList;
		}
		
	}

	public boolean isElementPresent(String locator,String type){

		List<WebElement> w = getElementList(locator, type);
		if(w.size()>0){
			return true;
		}
		else{
			return false;
		}




	}

}
