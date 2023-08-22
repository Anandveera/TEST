package pratice.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoCounter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day4 {
/*
 * Day_4 
 Assignment 

Credentials:
hari.radhakrishnan@qeagle.com
Leaf$1234



		ChromeOptions options = new ChromeOptions();	options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);



1. Launch https://login.salesforce.com/ 
2. Login to Salesforce with your username and password
3. Click on the App Launcher (dots)
4. Click View All
5. Type Content on the Search box
6. Click the Content Link
7. Click on Chatter Tab
8. Verify the Chatter title on the page
9. Click the Question tab
10. Type Question 
11. Type Details 
12. Click Ask
13. Confirm the question appears
14. Close the browser
 */
	
	WebDriver driver;
	String Question = "What is Selenium";
	@BeforeTest
	public void lanuchChrome() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	     driver = new ChromeDriver(options);
		//chromeoption.addArguments(null)
		// driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		
	}
	@Test
	public void loginSalesForce() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@name='pw']")).sendKeys("Leaf$1234");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()=\"View All\"]")).click();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@part='input']")).sendKeys("Sales");
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//mark[text()='Sales'][1]")).click();
		//a[@title='Chatter']
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebElement chatter = driver.findElement(By.xpath("//a[@title='Chatter']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("arguments[0].click();", chatter);
           driver.findElement(By.xpath("//a[@title='Chatter']")).isDisplayed();
           driver.findElement(By.xpath("//a[@title='Question']")).click();
           driver.findElement(By.xpath("//textarea[@placeholder='What would you like to know?']")).sendKeys(Question);
           driver.findElement(By.xpath("//div[@data-placeholder='If you have more to say, add details here...']")).sendKeys("Selenium is a free (open-source) automated testing framework used to validate web applications across different browsers and platforms. ");
           driver.findElement(By.xpath("//button[text()='Ask']")).click();
           
		
          WebElement ques =  driver.findElement(By.xpath("//span[@data-aura-rendered-by='44:3208;a']"));
          ques.isDisplayed();
          String attribute = ques.getAttribute(Question);
          if(Question.equals(attribute)) {
        	  System.out.println("Question ?"+ques.isDisplayed());
        	Thread.sleep(2000);  
          }
		
	driver.quit();
	
	}
	
	
	
}
