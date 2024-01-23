package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POM.ContactPagepom;
import POM.LoginPage;

public class BaseClass {

	public WebDriver driver;
	//only to take screenshot
	public static WebDriver sdriver;
	PropertFileUtils futils = new PropertFileUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	ExcelUtils eutils = new ExcelUtils();
	JavaUtils jutils = new JavaUtils();
	//ContactPagepom  cont = new ContactPagepom ();
	
	@BeforeSuite
	public void BSconfig() {
		Reporter.log("--Connect to Data Base---",true);
	}
	
	@BeforeClass
	public void BCconfig() throws IOException {
		String BROWSER	=futils.getDataFromPropertyFile("browser");
		String URL = futils.getDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		//Maximize window
		wutils.maximize(driver);
		//To apply implicit wait
		wutils.implicitwait(driver);
		//Launch url
		driver.get(URL);
		//only to takescreenshot
		sdriver=driver;
	}
	
	@BeforeMethod
	public void BMconfig() throws IOException {
		String USERNAME = futils.getDataFromPropertyFile("username");
		String PASSWORD = futils.getDataFromPropertyFile("password");
		
		//Login to application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AMconfig() throws InterruptedException {
		WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Mouse hovering on admin image
		wutils.mousehover(driver, image);
		
		Thread.sleep(4000);
		//To signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void ACconfig() {
		driver.quit();
		
	}
	
	@AfterSuite
	public void ASconfig() {
		Reporter.log("---Disconnect to Data Base---",true);
	}
	
	
	

	
	

	}


