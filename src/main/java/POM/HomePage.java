package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
		
		
		@FindBy(xpath="(//a[text()='Organizations'])[1]")
		private WebElement Organizationlink;

		public WebElement getOrganizationlink() {
			return Organizationlink;
		}
		
		@FindBy(xpath="//img[@title='Create Organization...']")
		private WebElement image;

		public WebElement getImage() {
			return image;
			
		}
		
		@FindBy(xpath="(//a[text()='Contacts'])[1]")
		private WebElement Contactslink;
		
	
		
		
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement Contactsimage;

		public WebElement getContactslink() {
			return Contactslink;
		}




		public WebElement getContactsimage() {
			return Contactsimage;
		}
	}


