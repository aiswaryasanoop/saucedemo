package Testpkg;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pagepkg.Loginpage;
import Utilities.Excelutil;



public class Logintest {
	
	ChromeDriver driver;
	String baseurl="https://www.saucedemo.com";
	
	@BeforeTest
	public void setup() {
		driver= new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test	
	public void test() throws Exception {
		Loginpage ob=new Loginpage(driver);
		 String xl="C:\\Users\\sanoo\\OneDrive\\Desktop\\Luminar\\Book2.xlsx";
		 String sheet="sheet1";
		 int rowcount=Excelutil.getRowcount(xl, sheet);
		 for(int i=1;i<=rowcount;i++)
		 {
			 String username=Excelutil.getCellValue(xl, sheet, i, 0);
			 System.out.println("username----"+username);
			 String password= Excelutil.getCellValue(xl, sheet, i, 1);
			 System.out.println("password----"+password);
			 ob.setvalues(username, password);
			 ob.login();
			 
		 }
		
		 ob.addcart();
		 ob.cart();
		 ob.details();
		 ob.continuemethod();
		 ob.logout();
		 
	}

}
