package seleniumNew.LearnSelenium;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HeadlessBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		HtmlUnitDriver driver=new HtmlUnitDriver(BrowserVersion.CHROME);
		driver.get("www.facebook.com");
		System.out.println(driver.getTitle());
		//driver.close();
	}
}
