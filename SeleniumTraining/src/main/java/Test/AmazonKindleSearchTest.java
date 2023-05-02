package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonKindleSearchTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		// launch Amazon website
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	// Searching "kindle" on the searchbox
	public void addToAmazonCart() throws AWTException {
		Robot r = new Robot();
		WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		search.sendKeys("kindle");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println();
		
		//select the item with Amazon choice label and add it to the cart
		WebElement amazonChoiceLabelItem = driver
				.findElement(By.xpath("//*[@id=\"B08KTZ8249-amazons-choice-label\"]/span/span[1]"));
		amazonChoiceLabelItem.click();
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		 Actions actions = new Actions(driver);
	        actions.moveToElement(addToCartButton).perform();
		addToCartButton.click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		// explicit wait - to wait for the compose button to be click-able
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".a-modal-scroller")));
        driver.get("https://www.amazon.com/gp/cart/view.html");

		WebElement cart = driver.findElement(By.id("nav-cart"));
		cart.click();
		WebElement cartItem = driver.findElement(By.xpath("//*[@class=\"a-truncate-cut\"]"));
		Assert.assertTrue(cartItem.isDisplayed(), "Item is not available in the cart");

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
