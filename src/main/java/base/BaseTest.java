package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {
	public static WebDriver driver;
	public static Properties Pro;

	public BaseTest() {
		Pro = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream("C:\\Data\\Selenium777\\ACMEDEmo\\src\\main\\java\\config\\config.properties");
			Pro.load(input);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void intialization() {
		String browserName = Pro.getProperty("browser");
		if (browserName.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\shali\\Downloads\\chromedriver_win32\\chromedriver.exe");
			/*
			 * DesiredCapabilities capabilities = new DesiredCapabilities();
			 * capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 * options.merge(capabilities);
			 */
			driver = new ChromeDriver();

		} else {
			System.out.println("driver is missing");
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		System.out.println(driver);

	}

}
