package in.dolna.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.dolna.qa.basepackage.TestBaseClass;

public class LoginPage extends TestBaseClass{
	
	//Page Factory or Object Repository
	
	//private static String pageurl= "https://www.freecrm.com";
	@FindBy(name ="username")
	WebElement username;
	
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath= "//input[@value= 'Login']")
	WebElement loginbutton;
	
	@FindBy(xpath ="//img[contains(@src, 'https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg')]")
	WebElement logo;
	
	public LoginPage() {
		//Initializing the Page Objects
		PageFactory.initElements(driver, this);
				
	}
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String UserName, String Password) {
		username.sendKeys(UserName);
		password.sendKeys(Password);
		loginbutton.submit();
		
		return new HomePage();
	}
	
	
	
	


}
