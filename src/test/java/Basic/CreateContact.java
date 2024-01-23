package Basic;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateContact {
	
	@Test
	
	public void Contact() throws IOException, InterruptedException {
		final WebDriver driver;
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		
		/*To read data from property file*/
		String BROWSER =futils.getDataFromPropertyFile("browser");
		String URL = futils.getDataFromPropertyFile("url");		
		String USERNAME = futils.getDataFromPropertyFile("username");	
		String PASSWORD=futils.getDataFromPropertyFile("password");
		
		
		/*To read data from excel file*/
		String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
		String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
		String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 5);
		String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 4, 5);
		
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
		//Click on contact
		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		//Click on contact + image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//To enter firstname
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		//To enter lastname
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//To click on group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		//Dropdown WebElement
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		//Handle dropdown by visible text
		wutils.handledropdown(dropdown, DROP);
		
		//Click on + image in Organization name
driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
	
		//To transfer control from parent to child
		wutils.switchtowindow(driver,CHILDURL);
	
		//To enter Organization name in search tf
	driver.findElement(By.id("search_txt")).sendKeys("Wipro");
	//To click on search button
	driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		//To click on text
		driver.findElement(By.xpath("//a[text()='Wipro']")).click();
		
		//To transfer control from child to parent
		wutils.switchtowindow(driver,PARENTURL);
				
				
		//To take webpage screenshot		
				//wutils.screenshot(driver);		
		
				Thread.sleep(2000);
		//To perform scrolling 
				wutils.scrolling(driver);
				
				
	//To click Save button			
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
	//Admin image
		WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Mouse hovering on admin image
		wutils.mousehover(driver, image);
		
		Thread.sleep(2000);
		//To signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	
	
	
	
	
				}
	
				
	
	}


