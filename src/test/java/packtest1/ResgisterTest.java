package packtest1;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pack1.HomePage;
import pack1.Login;
import pack1.Register;

public class ResgisterTest extends BaseTest{
	
	private Register register;
	private Login login;
	private HomePage homepage;

	public ResgisterTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		intialization();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		register = new Register();
		login = new Login();
		homepage = new HomePage();
		System.out.println(driver);
	}

	@Test

	public void registerPage() throws InterruptedException {
		register.clickRegister();
		login.clickLogin();
		homepage.clickHomeIcon();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
