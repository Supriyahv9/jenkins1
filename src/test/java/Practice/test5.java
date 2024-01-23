package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test5 {

	public WebDriver driver;
	@Parameters("Browser")
	@Test
	public void facebook(String Browser) {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.facebook.com/");

}
}
