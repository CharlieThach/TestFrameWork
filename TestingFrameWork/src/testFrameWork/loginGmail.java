package testFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
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
  @Test (priority = 0)
  public void test2(){
//  driver.manage().window().maximize();
	  driver.get(url);
	  report = new ExtentReports("./Report/home.html");
	  logger = report.startTest("loginGmail");
	
	  String title = driver.getTitle();
	  logger.log(LogStatus.INFO, "Opening browser");
	  Assert.assertTrue(title.contains("Google"));
	  logger.log(LogStatus.INFO, "Compare page");
  }
  
  @AfterMethod
  public void houseCleaning(ITestResult result){
	  if(result.getStatus()== ITestResult.FAILURE){
		  System.out.println("Fail answer");
	  }
	report.endTest(logger);
	report.flush();  
	driver.quit();
  }

}
