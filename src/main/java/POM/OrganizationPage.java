package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage {

	
	@FindBy(name="accountname")
	private WebElement Organizatintf;

	public WebElement getOrganizatintf() {
		return Organizatintf;
	}
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement Assignedtobtn;

	public WebElement getAssignedtobtn() {
		return Assignedtobtn;
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement Assignedtodropdown;

	public WebElement getAssignedtodropdown() {
		return Assignedtodropdown;
	}
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement Savebtn;

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imagebtn;

	public WebElement getImagebtn() {
		return imagebtn;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement Signoutbtn;

	public WebElement getSignoutbtn() {
		return Signoutbtn;
	}
	
	
}
