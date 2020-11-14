package pack1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest{
	
	@FindBy(xpath ="//*[@id=\"headerPanel\"]/ul[2]/li[1]/a")
	public WebElement homeicon;
	
	@FindBy(xpath ="//*[@id=\"rightPanel\"]/p[1]/a")
	public WebElement readmore;
	
	@FindBy(xpath ="//*[@id=\"headerPanel\"]/ul[2]/li[2]/a")
	public WebElement abouticon;
	
	@FindBy(xpath ="//*[@id=\"headerPanel\"]/ul[2]/li[3]/a")
	public WebElement contacticon;
	
	@FindBy(xpath ="//*[@id=\"rightPanel\"]/h1")
	public WebElement customercaretitle;
	
	@FindBy(id ="name")
	public WebElement custname;
	
	@FindBy(id ="email")
	public WebElement custemail;
	
	@FindBy(id ="phone")
	public WebElement custephn;
	
	@FindBy(id ="message")
	public WebElement message;
	
	@FindBy(xpath ="//*[@id=\"contactForm\"]/table/tbody/tr[5]/td[2]/input")
	public WebElement sendtoccbtn;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickHomeIcon() throws InterruptedException {
		homeicon.click();
		readmore.click();
		
		driver.navigate().back();
		contacticon.click();
		String text = customercaretitle.getText();
		System.out.println("text prints upon clicking on contact icon  " +   text);
		
		custname.sendKeys("saniya");
		
		custemail.sendKeys("saniya.01@gmail.com");
		
		custephn.sendKeys("9763426598");
		
		message.sendKeys("Thanx for contacting with para site bank..Have a great day!");
		sendtoccbtn.click();
	}

}
