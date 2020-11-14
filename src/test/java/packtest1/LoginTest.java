package packtest1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pack1.Login;

public class LoginTest extends BaseTest {
	private Login login;

	public LoginTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		intialization();
		login = new Login();
		System.out.println(driver);
	}

	@Test
	public void loginPage() throws InterruptedException {
		login.clickLogin();
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
}
