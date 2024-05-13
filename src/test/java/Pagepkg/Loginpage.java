package Pagepkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class Loginpage {
	ChromeDriver driver;
	
	@FindBy(id="user-name")
	WebElement usrname;
	
	@FindBy(id="password")
	WebElement paswrd;
	
	@FindBy(id="login-button")
	WebElement login;
	
	@FindBy(xpath ="//*[@id=\"inventory_container\"]/div")
	WebElement items;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
	WebElement cart;
	
	@FindBy(id="checkout")
	WebElement checkout;
	
	@FindBy(id="first-name")
	WebElement fstname;
	
	@FindBy(id="last-name")
	WebElement lstname;
	
	@FindBy(id="postal-code")
	WebElement pstcode;
	
	@FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
	WebElement cntnue;
	
	@FindBy(xpath = "/html/body/div/div[1]/div/div[3]/div")
	WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	
public Loginpage(ChromeDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);
	
}

public void setvalues(String username, String password)
{
	usrname.clear();
	usrname.sendKeys(username);
	paswrd.clear();
	paswrd.sendKeys(password);
}
public void login()
{
	login.click();
}
  public void addcart() {
	List<WebElement>li=items.findElements(By.tagName("button"));
	for(WebElement ct:li)
	{
		ct.click();
	}
  }
	public void cart() {
		
		cart.click();
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 1000);");
		checkout.click();
		
	}
	public void details() {
		fstname.sendKeys("Aiswarya");
		lstname.sendKeys("Sathyan");
		pstcode.sendKeys("683571");
	}
	public void continuemethod() {
		cntnue.click();
	}
	public void logout() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, -250);");
		menu.click();
		
		logout.click();
	}

}