package Basic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtils;
import CommonUtils.PropertFileUtils;
import CommonUtils.WebDriverUtils;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationPage;

public class CreateOrganizationpom {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		final WebDriver driver;
		
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		
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
		
		driver.get(URL);
		wutils.maximize(driver);
		wutils.implicitwait(driver);
		
		LoginPage lp = new LoginPage();
		PageFactory.initElements(driver, lp);
		lp.getUsernametf().sendKeys(USERNAME);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getSubmitbtn().click();
		
		
		HomePage hp = new HomePage();
		PageFactory.initElements(driver, hp);
		hp.getOrganizationlink().click();
		hp.getImage().click();
		
		
		OrganizationPage org = new OrganizationPage();
		PageFactory.initElements(driver, org);
		org.getOrganizatintf().sendKeys(OrgName);
		org.getAssignedtobtn().click();
		
		wutils.handledropdown(org.getAssignedtodropdown(), Group);
		org.getSavebtn().click();
		
		wutils.mousehover(driver, org.getImagebtn());
		
		org.getSignoutbtn().click();
	}

}
