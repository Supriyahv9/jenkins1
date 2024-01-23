package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test2 {

	SoftAssert s = new SoftAssert();
		@Test
		public void vtiger() {
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.vtiger.com/vtigercrm/");
			String actualtitle = driver.getTitle();
		
		
		String expectedtitle = "vtigerpune";
		s.assertEquals(actualtitle, expectedtitle);
	//	Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println(actualtitle);
		System.out.println("Good morning");
		s.assertAll();
		
	}
		
		@Test
		public void vtigercrm() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8888/");
			WebElement loginbtn = driver.findElement(By.id("submitButton"));
		//	Assert.assertTrue(loginbtn.isEnabled());
		//	Assert.assertTrue(loginbtn.isSelected());
			Assert.assertFalse(loginbtn.isSelected());
			Assert.assertTrue(loginbtn.isEnabled());
			System.out.println("Hello");
		
		
		
		
		
		
		
		
		}
}












