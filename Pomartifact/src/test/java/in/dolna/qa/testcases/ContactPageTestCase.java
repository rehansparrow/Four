package in.dolna.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.dolna.qa.basepackage.TestBaseClass;
import in.dolna.qa.pages.ContactsPage;
import in.dolna.qa.pages.HomePage;
import in.dolna.qa.pages.LoginPage;
import in.dolna.qa.util.TestUtil;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class ContactPageTestCase extends TestBaseClass {
	
	LoginPage loginobj;
	HomePage homeobj;
	TestUtil testutilobj;
	ContactsPage contactpageobj;
	
	String sheetName = "contacts";
	
	
	public ContactPageTestCase() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		testutilobj = new TestUtil();
		contactpageobj = new ContactsPage();
		loginobj = new LoginPage();
		homeobj = loginobj.login(prop.getProperty("username"), prop.getProperty("password"));
		testutilobj.switchtoFrame();
		contactpageobj = homeobj.clickContact();
		 	
		 
	}
	
	
	@Test(priority=1)
	public void verifyTitleTest() {
	String actualtitle= contactpageobj.contactTitle();
	Assert.assertEquals(actualtitle, "CRMPRO", "Not Matched Title");
	}
	
	@Test(priority= 2)
	public void verifyContactLabelTest() {
		
		Assert.assertTrue(contactpageobj.contactlabel(), "Label not matched");
			}
	
	@Test(priority= 3)
	public void verifySelectContactTest() { 		
		
		contactpageobj.selectContact("Shaikh Ahmed");
		contactpageobj.selectContact("Shaikh Ahmed");
	}
	
	@DataProvider
	public Object getTestData() {
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority= 4, dataProvider= "getTestData")
	public void validateCreateNewContactTestCase(String title, String firstName, String lastName, String company) {
		homeobj.clickNewContact();
		//contactpageobj.createNewContact("Mr.", "Shaikh", "Rehan", "Shaikh Solution");
		contactpageobj.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void teardown() { 
		driver.quit();
	}
	
	
}
