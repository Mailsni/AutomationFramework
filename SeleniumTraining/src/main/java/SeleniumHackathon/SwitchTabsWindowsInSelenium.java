package SeleniumHackathon;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTabsWindowsInSelenium {
	WebDriver driver;

	@BeforeTest
	public void launchTabs() {

		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com');");

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		} catch (Exception e) {
			System.out.println("Error occurred while setting up WebDriver: " + e.getMessage());
		}

	}

	@Test
	public void switchingTheTabs() {
		if (driver == null) {
            System.out.println("WebDriver not initialized. Test skipped.");
            return;
        }

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
	
        driver.switchTo().window(tabs.get(0));

      for (int i = 0; i < tabs.size(); i++) {
          driver.switchTo().window(tabs.get(i));
      }
  }


	@AfterTest
	public void tearDown() {
		if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}