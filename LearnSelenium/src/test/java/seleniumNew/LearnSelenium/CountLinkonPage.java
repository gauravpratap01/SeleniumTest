package seleniumNew.LearnSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountLinkonPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/"); 
		//All the links represented by <a> HTML tags
		List<WebElement> linklists=driver.findElements(By.tagName("a"));
		System.out.println(linklists.size());
		//Print text of all links
		for (int i=0;i<linklists.size();i++)
		{
			System.out.println(linklists.get(i).getText());
			
		}
		driver.close();

	}

}
