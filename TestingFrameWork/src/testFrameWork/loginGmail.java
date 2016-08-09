package testFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.loadProperty;

public class loginGmail {
public String url = "http://www.gmail.com";
public ExtentReports report; 
public ExtentTest logger;
public WebDriver driver; 
WebDriverWait wait;
Properties prop;
loadProperty proper;

	loginGmail(){
	  proper = new utility.loadProperty();
	  try {
		prop = proper.readPropFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	  System.setProperty(prop.getProperty("drivername"), prop.getProperty("chromedriver"));
	  report = new ExtentReports("C:/Report/Gmail.html");

  }
  @BeforeMethod
  public void starterDriver(){
	  driver = new ChromeDriver();
	  wait = new WebDriverWait(driver, 10); 
  }
  @Test
  public void checkPage(){
	 
	  logger = report.startTest("checkPage");
	  driver.get(url);
	  logger.log(LogStatus.INFO, "Opening chrome browser");
	  String title = driver.getTitle();
	  logger.log(LogStatus.INFO, "Grab title");
	  Assert.assertTrue(title.contains("Gmail"));
	  logger.log(LogStatus.INFO, "Login Gmail verified");
	  report.endTest(logger);
  }
  @Test 
  public void validLogin(){
	  logger = report.startTest("validLogin");
	  driver.get(url);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.id("next")));
	  	logger.log(LogStatus.PASS, "Opening chrome browser");
	  driver.findElement(By.id("Email")).sendKeys(prop.getProperty("user"));
	  driver.findElement(By.id("next")).click(); 
	  	wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
	  	logger.log(LogStatus.INFO, "Grab title page");
	  driver.findElement(By.id("Passwd")).sendKeys(prop.getProperty("pass"));
	  driver.findElement(By.id("signIn")).click();
	  	wait.until(ExpectedConditions.elementToBeClickable(By.id("gbqfb")));
	  Assert.assertTrue(driver.getTitle().contains("choithach@gmail.com"));
	  	report.endTest(logger);
	  
  }
  @Test
  public void invalidLogin(){
	 logger = report.startTest("invalidLogin"); 
	 driver.get(url);
	  driver.findElement(By.id("Email")).sendKeys(prop.getProperty("user"));
	  driver.findElement(By.id("next")).click(); 
	  	wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
	  	logger.log(LogStatus.INFO, "Grab title page");
		  driver.findElement(By.id("Passwd")).sendKeys("testing");
		  driver.findElement(By.id("signIn")).click();
		  Assert.assertTrue(driver.getTitle().contains("choithach@gmail.com"));
		  report.endTest(logger);
  }
  @AfterMethod
  public void closeDriver(){
	  driver.quit();
  }
  @AfterTest
  public void houseCleaning(){
	report.flush();  

  }

}
