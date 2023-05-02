package SeleniumHackathon;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author mailsni Using Mouse as the search parameter as kindle doesnt give the
 *         option of Amazon's choice. This class enables to find Amazon's choice
 *         of mouse and add it to the cart and confirm that the item is added in
 *         the cart.
 * 
 *
 */
public class AddAmazonChoiceProductToCart {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
//launch Amazon website
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
//Searching "mouse" on the searchbox
	public void addToAmazonCart() throws AWTException {
		Robot r = new Robot();
		WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		search.sendKeys("kindle");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println();
		WebElement amazonChoiceProduct = driver.findElement(By.xpath("//*[@id=\"B0836GXKKB-amazons-choice-label\"]/span/span[1]"));
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        
		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-cart-text-container\"]")));
		WebElement cart = driver.findElement(By.id("nav-cart"));
		cart.click();
		WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"B0836GXKKB-amazons-choice-label]"));
		Assert.assertTrue(cartItem.isDisplayed(), "Item is not available in the cart");

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
