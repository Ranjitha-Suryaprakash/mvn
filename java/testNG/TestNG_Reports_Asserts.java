package testNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNG_Reports_Asserts {
  @Test
  public void testString() {
	  String actualValue = "Ranjitha";
	  Reporter.log("the actual value is "+actualValue, true);
	  Assert.assertEquals(actualValue, "Ranjitha");
	  Reporter.log("Verifying the actual string with expected value", true);
	  Reporter.log("");
  }
  @Test
  public void testInteger() {
	  int actualValue = 10;
	  Reporter.log("the actual value is "+actualValue, true);
	  Assert.assertEquals(actualValue, 10);
	  Reporter.log("Verifying the actual integer with expected value", true);
	  Reporter.log("");
  }
  @Test
  public void testArray() {
	  int[] q={1,2,3};
	  int[] y={1,2,3};
	  for(int i : q){
		  Reporter.log("the actual value is "+i, true); 
	  }
	  Assert.assertEquals(q, y);
	  Reporter.log("Verifying the actual array with expected value", true);
	  Reporter.log("");
  }
}
