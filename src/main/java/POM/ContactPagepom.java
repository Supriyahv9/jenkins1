package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPagepom {

	
	@FindBy(name="firstname")
	private WebElement firstnametf;
	
	
	@FindBy(name="lastname")
	private WebElement lastnametf;


	public WebElement getFirstnametf() {
		return firstnametf;
	}


	public WebElement getLastnametf() {
		return lastnametf;
	}
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement ContactAssignedtobtn;


	public WebElement getContactAssignedtobtn() {
		return ContactAssignedtobtn;
	}
	
	@FindBy(name="assigned_group_id")
	private WebElement Contactdropdown;


	public WebElement getContactdropdown() {
		return Contactdropdown;
	}
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement ContactSavebtn;


	public WebElement getContactSavebtn() {
		return ContactSavebtn;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Contactimage;


	public WebElement getContactimage() {
		return Contactimage;
	}
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement ContactSignoutbtn;


	public WebElement getContactSignoutbtn() {
		return ContactSignoutbtn;
	}
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement ContactPlusbtn;


	public WebElement getContactPlusbtn() {
		return ContactPlusbtn;
	}
	
	@FindBy(id="search_txt")
	private WebElement ContactSearchtf;


	public WebElement getContactSearchtf() {
		return ContactSearchtf;
	}
	
	@FindBy(name="search")
	private WebElement Searchbtn;


	public WebElement getSearchbtn() {
		return Searchbtn;
	}
	
	@FindBy(xpath="//a[text()='Wipros']")
	private WebElement Contacttext;


	public WebElement getContacttext() {
		return Contacttext;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
