package com.boatHeadphonesAssignment.base;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.boatHeadphonesAssignment.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
		
	  protected static WebDriver driver;
	  protected static Properties prop;
	  
	  @BeforeTest
	  public static void initialization() {
		  try {
		  prop=new Properties();
		  String projectPath=System.getProperty("user.dir");
		  FileInputStream is=new FileInputStream(projectPath+"/src/main/java/com/boatHeadphonesAssignment/config/config.properties");
		  prop.load(is);
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
		  driver.get(prop.getProperty("url"));
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  public void waitForVisibility(WebElement e) {
			WebDriverWait wait=new WebDriverWait(driver,TestUtils.Implicit_Wait);
			wait.until(ExpectedConditions.visibilityOf(e));
	  }
	  
	  public void click(WebElement e) {
		  waitForVisibility(e);
		  e.click();
	  }
	  
	  public void sendKeys(WebElement e, String text) {
		  waitForVisibility(e);
		  e.sendKeys(text);
	  }
	  
		public String getAttribute(WebElement e, String attribute) {
		   	  waitForVisibility(e);
		   	  return e.getAttribute(attribute);
		   	}
		
		public String getText(WebElement e) {
		   	  waitForVisibility(e);
		   	  return e.getText();
		   	}
	
	  public boolean isVisible(WebElement e) {
	   	  try {
	   	    waitForVisibility(e);
	   	    if (e.isDisplayed()) {
	   	      return true;
	   	    }
	   	  } catch(Exception exception) {
	    	    return false;
	   	  }
	   	return false;
	   }
	  
	public void scrollDownSmoothly() {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int height= ((Number)jse.executeScript("return document.body.scrollHeight")).intValue();
		for(int i=0;i<height;i++) {
			jse.executeScript("window.scrollBy(0,5)");
		 }
	}
	
	public void scrollToElement(WebElement e) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",e);
	}
	  
	  @AfterTest
	   public static void quit() {
		  driver.quit();
	  }

}
