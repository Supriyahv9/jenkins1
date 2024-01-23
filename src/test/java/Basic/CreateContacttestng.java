package Basic;

import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;
import CommonUtils.JavaUtils;
import CommonUtils.Listenerimplementation;
import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;


@Listeners(Listenerimplementation.class)
public class CreateContacttestng extends BaseClass {
	
	@Test
	
	public void CreateContact() throws EncryptedDocumentException, IOException, InterruptedException {
	
	PropertFileUtils futils = new PropertFileUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	ExcelUtils eutils = new ExcelUtils();
	JavaUtils jutils = new JavaUtils();

	/*To read data from excel file*/
	String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
	String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
	String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
	String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 5);
	String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 4, 5);
	
	
	String actualtitle = driver.getTitle();
	System.out.println(actualtitle);
	
	String Expectedtitle = "Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRMpune";
	
	Assert.assertEquals(actualtitle, Expectedtitle);
	//Click on contact
			driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			
			
			
			
			
			
			
			//Click on contact + image
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			//To enter firstname
			driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
			Reporter.log("firstname is entered",true);
			//To enter lastname
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
			Reporter.log("lastname is entered",true);
			
			
			
			
			
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
		Reporter.log("working on child window",true);
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
					wutils.screenshot(driver,"Screenshotname");		
			
					Thread.sleep(2000);
			//To perform scrolling 
					wutils.scrolling(driver);
					
					
		//To click Save button			
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Reporter.log("Contact is Created",true);	
}
	
	@Test
	public void actitme() {
		System.out.println("Hello");
	}
	
	@Test(dependsOnMethods="CreateContact")
	public void Facebook() {
		System.out.println("Bye");
	}
}
	
	