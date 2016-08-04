package testFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.loadProperty;

public class loginGmail {
public String url = "http://www.gmail.com";
public WebDriver driver;

  @BeforeTest
  public void setup() throws IOException{
	  loadProperty proper = new utility.loadProperty();
	  Properties prop = proper.readPropFile(); 
	  
	  System.setProperty(prop.getProperty("drivername"), prop.getProperty("chromedriver"));
	  driver = new ChromeDriver();
	  driver.get(url);
  }
  @Test (priority = 0)
  public void test2(){
	  System.out.println("second test");
  }
  
  @AfterMethod
  public void houseCleaning(){
	driver.quit();
  }

}
