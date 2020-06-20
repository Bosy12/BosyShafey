package SeleniumAutomationTask.SeleniumAutomation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
/**
 * 
 * @author Bosy Shafy
 *
 */
public class ScenarioTwo extends GooglePlaySearch {
	
	@Test
	public void facebookSearch() {
		
		searchFor("Facebook");
		By ImageIconCondiation =By.cssSelector("[src='https://lh3.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=s128-rw'],[src='https://lh3.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=s128']");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ImageIconCondiation));
		//make sure that the icon of the facebook is shown -- compatibility 
		assertTrue(driver.findElements(ImageIconCondiation).size()>0);
		

	}

	 
}
