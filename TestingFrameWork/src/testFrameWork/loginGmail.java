package testFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.loadProperty;

public class loginGmail {
public String url = "http://www.google.com";
public ExtentReports report; 
public ExtentTest logger;
public WebDriver driver; 
  @BeforeTest
  public void setup() throws IOException{
	  loadProperty proper = new utility.loadProperty();
	  Properties prop = proper.readPropFile(); 
	  System.setProperty(prop.getProperty("drivername"), prop.getProperty("chromedriver"));
	  driver = new ChromeDriver();

  }
  @Test 
  public void test2(){
	  report = new ExtentReports("C:/Report/home1.html");
	  logger = report.startTest("loginGmail");
	  driver.get(url);
	  logger.log(LogStatus.INFO, "Opening chrome browser");
	  String title = driver.getTitle();
	  logger.log(LogStatus.INFO, "Grab title");
	  Assert.assertTrue(title.contains("Google"));
	  logger.log(LogStatus.PASS, "Login Gmail verified");

  }
  
  @AfterMethod
  public void houseCleaning(ITestResult result){
	report.endTest(logger);
	report.flush();  
	driver.quit();
  }

}
