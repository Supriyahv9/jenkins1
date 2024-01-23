package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test3 {

	@Test
	public void Login() {
		System.out.println("LoginPage");
		Assert.assertEquals("Pune", "Deccan");
	}
	
	@Test(dependsOnMethods="Login")
	public void Home() {
		System.out.println("HomePage");
	}
	
	@Test(dependsOnMethods="Login")
	public void Logout() {
		System.out.println("LogoutPage");
	}
}
