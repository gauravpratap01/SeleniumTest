package seleniumNew.LearnSelenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver"); 
		driver.findElement(By.xpath("//button[@id='populate-text']")).click();

		//Below code will also work		
		/*
		WebDriverWait wait=new WebDriverWait(driver,20); 
		WebElement ele=driver.findElement(By.xpath("//h2[@id='h2']"));
		wait.until(ExpectedConditions.textToBePresentInElement(ele,"Selenium Webdriver"));
		System.out.println(ele.getText()); driver.close();
		*/		

		String text=getText(driver,driver.findElement(By.xpath("//h2[@id='h2']")),20);
		System.out.println(text);
		driver.close();		

	}
	public static String getText(WebDriver driver, WebElement ele,int timeout) {
		new WebDriverWait(driver,timeout)
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.textToBePresentInElement(ele,"Selenium Webdriver"));
		return ele.getText();

	}

}
