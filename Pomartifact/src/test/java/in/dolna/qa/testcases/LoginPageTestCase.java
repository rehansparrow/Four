package in.dolna.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.dolna.qa.basepackage.TestBaseClass;
import in.dolna.qa.pages.HomePage;
import in.dolna.qa.pages.LoginPage;

public class LoginPageTestCase extends TestBaseClass{
	
	LoginPage loginobj;
	HomePage homeobj;
	
	
	 public LoginPageTestCase() {
		super();
	}
	

	@BeforeMethod
	public void setup() {
		try {
			initialization();
			
			loginobj =new LoginPage();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println();
		
		}
				
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginobj.validateLoginPageTitle();
		
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void crmlogoTest() {
		Boolean flag = loginobj.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homeobj = loginobj.login(prop.getProperty("username"), prop.getProperty("password"));
		
	
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
