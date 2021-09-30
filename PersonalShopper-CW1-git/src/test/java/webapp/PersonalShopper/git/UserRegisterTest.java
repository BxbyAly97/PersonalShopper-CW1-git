package webapp.PersonalShopper.git;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class UserRegisterTest {
	
  //declare Selenium WebDriver
	private WebDriver webDriver;
	
  @Test
  public void insertRegForm(){
	  
	  //Load local host Register Page as a new page
	  webDriver.navigate().to("http://localhost:8085//PersonalShopper-CW1-git/CustomerServlet");
	  
	  // To click a hyperlink that redirects to a register form page
	  webDriver.findElement(By.xpath("//a[@href='/PersonalShopper-CW1-git/regPage.jsp']")).click();
	  
	// enter a valid user name
	  webDriver.findElement(By.name("userName")).sendKeys("Alyshyia FinalCW");
	  
	// enter a valid password
	  webDriver.findElement(By.name("password")).sendKeys("aly_finalcw");
		  
	// enter a valid birth date
	
	  webDriver.findElement(By.name("dob")).sendKeys("09092021");
	  
	// enter a valid address
	  webDriver.findElement(By.name("address")).sendKeys("9 Woodlands Ave 9, Singapore 738964");
		  
	// enter a valid email
	  webDriver.findElement(By.name("email")).sendKeys("sitinuralyshyia@gmail.com");
	  
	// enter a valid phone
	  webDriver.findElement(By.name("phone")).sendKeys("98519304");
	  
	  // Find the register button		
      webDriver.findElement(By.name("Register")).submit();
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	//Setting system properties of ChromeDriver
	
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver_94.exe");

	  //initialize ChromeDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	//Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();	
  }

}
