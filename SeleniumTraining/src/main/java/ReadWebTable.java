import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.espncricinfo.com/series/icc-world-test-championship-2021-2023-1268315/points-table-standings/");
		driver.manage().window().maximize();

		WebElement table = driver.findElement(By.xpath("//*[@id=\"modalContainer]"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rnum=0;
		int head=0;
		for (rnum = 0; rnum < rows.size(); rnum++);
		{
			List<WebElement> header = rows.get(rnum).findElements(By.tagName("th"));
			for (head = 0; head < header.size(); head++);
			{
				System.out.println(header.get(head).getText());
			}
			
			header = rows.get(rnum).findElements(By.tagName("td"));
			for (head = 0; head < header.size(); head++);
			{
				System.out.println(header.get(head).getText());
			}
		}

	}
}
