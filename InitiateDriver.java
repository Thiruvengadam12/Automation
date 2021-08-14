package org.web.automatiion.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;


public class InitiateDriver {
	
	public static ChromeDriver driver;

	@BeforeClass	  
    public static void startBrowser(){
      System.setProperty("Webdriver.chrome.driver","./Driver/ChromeDriver.exe");
      driver = new ChromeDriver();      
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS); 	  
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS); 	
      driver.get("https://www.channelnewsasia.com/");	  

   }

    @AfterClass
    public static void CloseBrowser(){
       driver.quit();
     }

   }
