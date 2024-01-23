package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test6 {

	
	@Test(dataProvider="data")
	public void facebook(String name,String password) {
		System.out.println("Hello"+name+"data"+password+"present");
	}
	
	@DataProvider
	public Object[][] data() {
		
		Object[][] j = new Object[3][2];
		j[0][0]="Akash";
		j[0][1]="ak12";
		j[1][0]="Arpitha";
		j[1][1]="ar12";
		j[2][0]="Arthi";
		j[2][1]="art12";
		return j;
	}
}
