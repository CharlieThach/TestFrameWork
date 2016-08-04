package testFrameWork;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class loginGmail {
public String url = "http://www.google.com";
public WebDriver driver;

  @BeforeTest
  public void setup(){
	  driver = new FirefoxDriver();
	  driver.get(url);
  }
  @Test (priority = 1)
  public void login() {
	  System.out.println("Hello you");
  }
  @Test (priority = 0)
  public void test2(){
	  System.out.println("second test");
  }
  
  @AfterMethod
  public void houseCleaning(){
	  
  }

}
