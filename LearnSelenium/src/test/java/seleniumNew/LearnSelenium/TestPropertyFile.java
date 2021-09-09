package seleniumNew.LearnSelenium;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPropertyFile {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;
		Properties prop = new Properties();
		FileInputStream is = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(is);

		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (prop.getProperty("browser").equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		driver.get(prop.getProperty("url"));

	}

}
