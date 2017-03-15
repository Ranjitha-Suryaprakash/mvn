/**
 * 
 */
/**
 * @author 30196083
 *
 

=================================================================================
<!---INCLUDE=======runs only specified method in class 
and avoid other methods from running--!>

<methods>
<include name="searchWithMultipleData"/>
</methods>
=================================================================================

=================================================================================
PROBLEM IN CLICKING SUBMIT BUTTON---ALTERNATIVE
With recent webdriver and FF update, there might be issues in clicking the goButton.
// If you also encouter the issues, please comment the above code for goButton and un-comment the below code
		
//		WebElement goButton =driver.findElement(By.xpath("//button[@id='memberLoginDialogsubmitButton']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(goButton).click().perform();
====================================================================================

*/
package testNG;