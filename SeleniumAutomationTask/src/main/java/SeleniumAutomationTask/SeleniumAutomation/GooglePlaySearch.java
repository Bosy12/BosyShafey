package SeleniumAutomationTask.SeleniumAutomation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * 
 * @author Bosy Shafy
 *
 */
public class GooglePlaySearch {
	protected static WebDriver driver;
	protected static WebDriverWait wait;

	@Parameters({ "Browser" })
	@BeforeTest
	public void openGooglePlay(String Browser) {

		if (Browser.toUpperCase().equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", ".\\addons\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browser.toUpperCase().equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", ".\\addons\\geckodriverwin64\\geckodriver.exe");

			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.edge.driver", ".\\addons\\edge\\MicrosoftWebDriver.exe");

			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 10);

		driver.navigate().to("https://play.google.com/store");

		assertTrue(wait.until(ExpectedConditions.titleContains("Google Play")));

	}

	public void searchFor(String Word) {
		// search with Word in the search area
		WebElement SearchInput = driver.findElement(By.cssSelector("#gbqfqwb input"));
		SearchInput.clear();
		SearchInput.sendKeys(Word);
		// click search button
		driver.findElement(By.cssSelector("#gbqfbw button")).click();

		wait.until(ExpectedConditions.titleContains(Word));
	}

	@AfterTest
	public void closeWindow() {
		driver.quit();
	}

}
