package pack1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import junit.framework.Assert;

public class Register extends BaseTest {

	@FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
	public WebElement regiclick;

	@FindBy(id = "customer.firstName")
	public WebElement fn;

	@FindBy(id = "customer.lastName")
	public WebElement ln;

	@FindBy(id = "customer.address.street")
	public WebElement address;

	@FindBy(id = "customer.address.city")
	public WebElement city;

	@FindBy(id = "customer.address.state")
	public WebElement state;

	@FindBy(id = "customer.address.zipCode")
	public WebElement zipcode;

	@FindBy(id = "customer.phoneNumber")
	public WebElement phone;

	@FindBy(id = "customer.ssn")
	public WebElement ssn;

	@FindBy(id = "customer.username")
	public WebElement un;

	@FindBy(id = "customer.password")
	public WebElement pwd;

	@FindBy(id = "repeatedPassword")
	public WebElement cnfmpwd;

	@FindBy(className = "button")
	public WebElement regibtn;

	public Register() {
		PageFactory.initElements(driver, this);
	}

	public void clickRegister() throws InterruptedException {
		regiclick.click();

		fn.sendKeys("Sanya");

		ln.sendKeys("Sharif");

		address.sendKeys("Mumbai 101");

		city.sendKeys("Mumbai");

		state.sendKeys("Maharastra");

		zipcode.sendKeys("400001");

		phone.sendKeys("9763426598");

		ssn.sendKeys("765234");

		un.sendKeys("saya");

		pwd.sendKeys("password");

		cnfmpwd.sendKeys("password");

		regibtn.click();

		String title = driver.getTitle();
		System.out.println("Home Page title ::" + title);
		Assert.assertEquals("ParaBank | About Us", title);
	}

}
