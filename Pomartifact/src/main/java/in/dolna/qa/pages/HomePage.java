package in.dolna.qa.pages; 

import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory; 

import in.dolna.qa.basepackage.TestBaseClass; 

public class HomePage extends TestBaseClass{ 
	
	@FindBy(xpath= "//td[contains(text(), 'User: Shaikh Ahmed')]") 
	WebElement user; 
	
	
	@FindBy(xpath= "//a[contains(text(), 'Contacts')]") 
	WebElement contact;  
	
	@FindBy(xpath= "//a[contains(text(), 'Deals')]") 
	WebElement deals; 
	
	@FindBy(xpath= "//a[contains(text(), 'Tasks')]") 
	WebElement task;  
	
	@FindBy(xpath= "//a[contains(text(), 'New Contact')]") 
	WebElement newContact; 
	

	
	//Initialize the WebElements 
	
	public HomePage() { 
		PageFactory.initElements(driver, this); 
	} 
	
	//Actions 
	
	public String verifyPageTitle() { 
		return driver.getTitle(); 
	} 
	
	public boolean verifyUserTitle() { 
		return user.isDisplayed(); 
	} 
	
	public ContactsPage clickContact() { 
		contact.click(); 
		return new ContactsPage(); 
	} 
	
	public DealsPage clickdeal() { 
		deals.click(); 
		return new DealsPage(); 
	} 
	
	public TasksPage clickTask() { 
		task.click(); 
		return new TasksPage(); 
	} 
	
	public void clickNewContact() { 
		Actions action = new Actions(driver); 
		action.moveToElement(contact).build().perform(); 
		newContact.click(); 
		
		
	} 
	


} 
