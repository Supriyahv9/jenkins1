package Basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;

public class CreateOrganizationtestng extends BaseClass {
	
	
	@Test
	public void Organization() throws IOException, InterruptedException {
	
	
		
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();
		
		/*To read data from property file*/
		
		
		/*To read data from excel file*/
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String Group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		String Industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
		
		
		
		
		
		//Click on Organization
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		Reporter.log("Creating organisation");
		//Click on Organization + image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter accountname
		driver.findElement(By.name("accountname")).sendKeys(OrgName+jutils.getRandomnumber());
		Reporter.log("account name is entered",true);
		//To click on group radio button
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
		Reporter.log("Organization is created",true);
		Thread.sleep(4000);
		
		
	
	
	}
}
