package in.dolna.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.dolna.qa.basepackage.TestBaseClass;
import in.dolna.qa.pages.ContactsPage;
import in.dolna.qa.pages.HomePage;
import in.dolna.qa.pages.LoginPage;
import in.dolna.qa.util.TestUtil;

public class HomePageTestCases extends TestBaseClass{
	
	LoginPage loginobj;
	HomePage homeobj;
	TestUtil testutilobj;
	ContactsPage contactpageobj;
	
	
	 public HomePageTestCases() {
	super();
	}
	
	
	@BeforeMethod 
	
	public void setup() {
		initialization();
		loginobj = new LoginPage();
		homeobj = loginobj.login(prop.getProperty("username"), prop.getProperty("password"));
		testutilobj = new TestUtil();
		contactpageobj = new ContactsPage();
		
		
	}
	
	@Test
	
	public void verifyHomePageTitleTest() {
		String actualTitle = homeobj.verifyPageTitle();
		Assert.assertEquals(actualTitle, "CRMPRO", "Page Title not matched");
		 
	}
	
	@Test
	public void verifyUserTitleTest() {
		
		testutilobj.switchtoFrame();
		Assert.assertTrue(homeobj.verifyUserTitle());
	}
	
	
	@Test
	public void verifyclickContactTest() {
		testutilobj.switchtoFrame();
		contactpageobj = homeobj.clickContact();
	}
	
	
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
	
	
	
	

}
