package in.dolna.qa.basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import in.dolna.qa.util.TestUtil;
import in.dolna.qa.util.WebEventListener;

public class TestBaseClass {
	
	
	public static WebDriver driver; 
	public static Properties prop; 
	public static EventFiringWebDriver e_driver; 
	public static WebEventListener eventListener; 
	
	public TestBaseClass()  { 	
		try { 
			prop = new Properties(); 
			FileInputStream ip = new FileInputStream("C://Users//shaikh//eclipse-workspace//Pomartifact//src//main//java//in//dolna//qa//config//config.properties");
			prop.load(ip); 
		} catch (FileNotFoundException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
			catch (IOException e2) { 
				// TODO: handle exception 
				e2.printStackTrace(); 
			} 
		} 
	
		public static void initialization() { 
			String browserName = prop.getProperty("browser"); 
			
			if(browserName.equals("chrome")) { 
				System.setProperty("webdriver.chrome.driver", "C:/Users/shaikh/Desktop\\Chrome Driver\\chromedriver.exe"); 
				 driver = new ChromeDriver(); 
			} 
		else if(browserName.equals("FireFox")) 
			{ 
				System.setProperty("webdriver.gecko.driver","C://Users//shaikh//Desktop//geckodriver-v0.23.0-win64//geckodriver.exe");
				driver= new FirefoxDriver();  		
			} 
			
				else { 
				System.out.println("No Browser found"); 
				
					}  
			
			
			e_driver = new EventFiringWebDriver(driver); 
			eventListener = new WebEventListener(); 
			e_driver.register(eventListener); 
			driver = e_driver; 
			driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_TimeOut, TimeUnit.SECONDS); 	
		
		driver.manage().window().maximize(); 
		driver.get(prop.getProperty("url")); 
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_TimeOut, TimeUnit.SECONDS); 
		
		
		
			
		}
	
	
	
	}
	
	
	
	


