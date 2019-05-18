package in.dolna.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import in.dolna.qa.basepackage.TestBaseClass;

public class ContactsPage extends TestBaseClass{
	
	@FindBy(xpath= "//td[contains(text(), 'Contacts')]")
	@CacheLookup
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//td[@colspan='2']//child::input[@value='Save']")
	@CacheLookup
	WebElement saveButton;
	


	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String contactTitle() {
		return driver.getTitle();
		
	}
	
	public boolean contactlabel() {
		return contactslabel.isDisplayed();
	}
	
	public void selectContact(String name) {
	driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@value='52558276']")).click();
	
	}
	
	public void createNewContact(String title, String ftnm, String ltnm, String cmp) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
	firstName.sendKeys(ftnm);
	lastName.sendKeys(ltnm);
	company.sendKeys(cmp); 
	saveButton.click();
		
	}
	
	

}
