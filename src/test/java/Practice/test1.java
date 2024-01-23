package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test1 {

	@Test(groups="socialmedia")
	public void facebook() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void zomato() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://zomato.com/");
	}
	
	@Test(groups="socialmedia")
	public void instagram() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
		
	}

}
