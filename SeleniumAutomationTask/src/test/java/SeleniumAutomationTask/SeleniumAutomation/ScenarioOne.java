package SeleniumAutomationTask.SeleniumAutomation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
/**
 * 
 * @author Bosy Shafy
 *
 */
 
public class ScenarioOne extends GooglePlaySearch {

	@Test
	public void openApps() {
		//click on the apps side menu item
		driver.findElement(By.xpath("//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/ul/li[2]/a/span/span[2]")).click();
		assertTrue(wait.until(ExpectedConditions.titleContains("Android Apps on Google Play")));
	}

	@Test(dependsOnMethods = "openApps")
	public void chooseCategory() {

		//open Categories menu
		driver.findElement(By.className("TwyJFf")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Education")));

		//click the Education menu item
		driver.findElement(By.linkText("Education")).click();

		assertTrue(wait.until(ExpectedConditions.titleContains("Education - Android Apps on Google Play")));

	}

	@Test(dependsOnMethods = "chooseCategory")
	public void searchForTED() {
		By Tedcon= By.cssSelector("[title='TED']");
		//write TED in the search bar 
		searchFor("TED");
		// to hanlde the invaild dom element visibility status
		driver.navigate().refresh();
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".b8cIId.ReQCgd.Q9MA7b[title='TED'] a")));

		wait.until(ExpectedConditions.elementToBeClickable(Tedcon));

		// click the TED -- compatibility with firfox 
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Tedcon));
		js.executeScript("arguments[0].click();", driver.findElement(Tedcon));
		
		 //wait until the page header to be TED
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.AHFaub")));

		assertEquals(driver.getCurrentUrl(), "https://play.google.com/store/apps/details?id=com.ted.android");

	}

}
