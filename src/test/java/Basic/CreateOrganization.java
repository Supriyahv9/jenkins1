package Basic;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateOrganization {
	
	@Test
	public void Organization() throws IOException, InterruptedException {
	
	
		final WebDriver driver;
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		
		/*To read data from property file*/
		String BROWSER	=futils.getDataFromPropertyFile("browser");
		String URL = futils.getDataFromPropertyFile("url");
		String USERNAME = futils.getDataFromPropertyFile("username");
		String PASSWORD = futils.getDataFromPropertyFile("password");
		
		/*To read data from excel file*/
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String Group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		String Industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		
		
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
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//Click on Organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//Click on Organization + image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter accountname
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getRandomnumber());
		////To click on group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		Thread.sleep(2000);
		//Dropdown WebElement
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		//Handle dropdown by visible text
		wutils.handledropdown(dropdown, 2);
		//Dropdown WebElement
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		//Handle dropdown by visible text
		wutils.handledropdown(industrydropdown, Industry);
		//Checkbox
		WebElement box = driver.findElement(By.name("notify_owner"));
		//Click action on checkbox
		wutils.action(driver, box);
	
		//To click Save button	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		//Admin image
		Thread.sleep(4000);
		WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Mouse hovering on admin image
		wutils.mousehover(driver, image);
		
		Thread.sleep(4000);
		//To signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	}

}
