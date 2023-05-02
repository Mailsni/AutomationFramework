import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelRadioButton {
	
	//Not completed : The webpage is different from the window. 

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://designsystem.digital.gov/components/radio-buttons/"); //tried a random one from the internet
		driver.manage().window().maximize();
		
		List<WebElement> radio_button = driver.findElements(By.name("historical-figure"));//using pagesource found the name for the class button
		boolean bvalue;
		
		bvalue = radio_button.get(1).isSelected();
		
		if (bvalue==false) {
			radio_button.get(1).click(); // failed
		}else
		{
			System.out.println("It is already chosen"); 
			
		}
	}

}
