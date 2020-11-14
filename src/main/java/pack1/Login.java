package pack1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import junit.framework.Assert;

public class Login extends BaseTest {

	@FindBy(name ="username")
	public WebElement un;
	
	@FindBy(name ="password")
	public WebElement pwd;

	@FindBy(className = "button")
	public WebElement loginbtn;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public void clickLogin() throws InterruptedException {
		un.sendKeys("saya");
		
		pwd.sendKeys("password");
		
		loginbtn.click();
		
		String title1 = driver.getTitle();
		System.out.println("Home Page title ::" + title1);
		Assert.assertEquals("ParaBank | About Us", title1);
	}
}
