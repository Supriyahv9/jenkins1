package Basic;

import java.io.IOException;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import CommonUtils.ExcelUtils;

import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;
import POM.ContactPagepom;
import POM.HomePage;
import POM.LoginPage;

public class CreateContactpom extends BaseClass {

	@Test
	public void Contact() throws IOException, InterruptedException {

		
		
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		
		
		/*To read data from excel file*/
		String FIRSTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 3);
		String LASTNAME = eutils.getDataFromExcelFile("Sheet1", 1, 4);
		String DROP = eutils.getDataFromExcelFile("Sheet1", 2, 1);
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 5);
		String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 4, 5);
		
		
		
		
		
		
		HomePage hp = new HomePage();
		PageFactory.initElements(driver, hp);
		hp.getContactslink().click();
		hp.getContactsimage().click();
		
		ContactPagepom cont = new ContactPagepom();
		PageFactory.initElements(driver, cont);
		cont.getFirstnametf().sendKeys(FIRSTNAME);
		cont.getLastnametf().sendKeys(LASTNAME);
		cont.getContactPlusbtn().click();
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);
		
		//To transfer control from parent to child
		wutils.switchtowindow(driver,CHILDURL);
		cont.getContactSearchtf().sendKeys(OrgName);
		cont.getSearchbtn().click();
		Thread.sleep(2000);
		cont.getContacttext().click();
		Thread.sleep(2000);
		
		//To transfer control from child to parent
		wutils.switchtowindow(driver,PARENTURL);
		PageFactory.initElements(driver, cont);
		cont.getContactAssignedtobtn().click();
		wutils.handledropdown(cont.getContactdropdown(), DROP);
		Thread.sleep(2000);
		cont.getContactSavebtn().click();
	
	}
		
	}


