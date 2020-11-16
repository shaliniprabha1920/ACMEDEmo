package base;

import java.io.FileInputStream;
import java.io.IOException;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/admin.htm");
		System.out.println(driver);

	}

	// Extent Report:

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static ExtentTest test;

	@BeforeSuite
	public void setUpp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");
		Date date = new Date();
		String FileDate = dateFormat.format(date);

		System.out.println("setup method");

		// htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +
		// "/test-output/testReport.html");
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Data\\Selenium777\\ACMEDEmo\\test-output" + FileDate + "_extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Application Name", "Parasoft banking");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Final Report");
		/*
		 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 * htmlReporter.config().setTheme(Theme.STANDARD); htmlReporter.config().
		 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		 */
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case FAILED due to below issue: ",
					ExtentColor.RED));
			test.fail(result.getThrowable());
			System.out.println("Test Case Failure");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println(result.getName());

			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED ", ExtentColor.GREEN));
			System.out.println("Test Case Success");
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			System.out.println("Test Case Skipped");
		}
		System.out.println("Before Flush");
		extent.flush();
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}
