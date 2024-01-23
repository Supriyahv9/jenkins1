package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class test7 {


	@BeforeSuite
	public void BSconfig() {
		//System.out.println("Connect to data base");
		Reporter.log("--Connect to data base--",true);
	}
	
	@BeforeClass
	public void BCconfig() {
		Reporter.log("--Launch the Browser--- ",true);
	}
	
	@BeforeMethod
	public void BMconfig() {
		Reporter.log("--Login to the application--- ",true);
	}

		@Test
		public void vtiger() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8888/");
		}
		
		@AfterMethod
		public void AMconfig() {
			Reporter.log("--Logout to the application--- ",true);
		}
		
		@AfterClass
		public void ACconfig() {
			Reporter.log("--Close the Browser---",true);
		}
		
		@AfterSuite
		public void ASconfig() {
			//System.out.println("Disconnect to data base");
			Reporter.log("--Disconnect to data base--",true);
		}
	}



