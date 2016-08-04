package testFrameWork;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utility.property;


public class loginGmail {
public String url = "http://www.gmail.com";
public WebDriver driver;

  @BeforeTest
  public void setup() throws IOException{
	  property proper = new utility.property();
	  Properties prop = proper.readPropFile(); 
	  
	  System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(url);
  }
  @Test (priority = 0)
  public void test2(){
	  System.out.println("second test");
  }
  
  @AfterMethod
  public void houseCleaning(){
	
  }

}
