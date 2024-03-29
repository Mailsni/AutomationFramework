package Salesforce_Automation;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_11_CreateView extends SalesforceLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		Robot r1 = new Robot();
		driver.findElement(By.id("username")).sendKeys("mailsni@abc.com");
		driver.findElement(By.id("password")).sendKeys("abc12345");

		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("User is on home page");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		//Opening Accounts page
				WebElement Accounts_Tab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
				Accounts_Tab.click();
				System.out.println("Clicked on Accounts Ta..");
				//Creating New View
				WebElement CreateNewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
				CreateNewView.click();
				System.out.println("Clicked on Create New View..");
				
				WebElement ViewName = driver.findElement(By.xpath("//*[@id=\"fname\"]"));
				ViewName.clear();
				ViewName.sendKeys("hhhhh");
				
				String value = driver.findElement(By.xpath("//*[@id=\"fname\"]")).getAttribute("value");
				System.out.println(value);
				
				WebElement ViewUniqueName = driver.findElement(By.xpath("//*[@id=\"devname\"]"));
				ViewUniqueName.clear();
				ViewUniqueName.sendKeys("h");
				
				WebElement Save = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
				Save.click();
				System.out.println("Clicked on save button"); 

				WebElement dropdown = driver.findElement(By.className("title"));
				dropdown.click();
				Select dropdown_options = new Select(dropdown);
				List<WebElement> options = dropdown_options.getOptions();
				
				for(int i=0; i<options.size(); i++) {
					if(options.get(i).getText().equals(value)) {
						System.out.println("Account name is displayed in the dropdown");
					}
				}
				System.out.println("TC_11_Createnewview is completed");
				driver.close();
			}
}

	}

}
