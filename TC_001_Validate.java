package org.web.automation.testcases;


import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import org.web.automatiion.base.InitiateDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


public class TC_001_Validate extends InitiateDriver {
	JavascriptExecutor js = (JavascriptExecutor) driver;
    Actions act = new Actions(driver);


     @Test
     public void tc001() throws InterruptedException{
           String headline=driver.findElement(By.cssSelector("#block-mc-cna-theme-mainpagecontent > article > div > div.layout.layout--threecol-section.layout--threecol-section--25-50-25 > div.layout__region.layout__region--second > section > div > div.feature-card.feature-card-- > div.feature-card__content.feature-card__content-- > h1 > a")).getText();
           driver.findElement(By.cssSelector("#block-mc-cna-theme-mainpagecontent > article > div > div.layout.layout--threecol-section.layout--threecol-section--25-50-25 > div.layout__region.layout__region--second > section > div > div.feature-card.feature-card-- > div.feature-card__content.feature-card__content-- > h1 > a")).click();
           String actual=driver.findElement(By.cssSelector("#block-mc-cna-theme-mainpagecontent > article > div.content > div:nth-child(2) > div > section > div > h1")).getText();
           Assert.assertEquals(headline,actual);
           

           js.executeScript("window.scrollBy(0,1000)");
           Thread.sleep(30);
                for(int i=0;i<3;i++){
                        act.sendKeys(Keys.PAGE_UP).build().perform();
          }    
                Thread.sleep(15);
                driver.findElementByLinkText("Expand to read the full story").click();

    }
     @Test
     public void tc002(){
         js.executeScript("window.scrollBy(0,-1000)");
         act.sendKeys(Keys.PAGE_UP).build().perform();

         String edition = driver.findElementByXPath("/html/body/div[1]/div[1]/header/div[3]/div/div/nav/nav/ul/li[4]/a").getText();
         driver.findElementByXPath("/html/body/div[1]/div[1]/header/div[3]/div/div/nav/nav/ul/li[4]/a").click();
         String expected=driver.findElement(By.cssSelector ("#block-mc-cna-theme-mainpagecontent > article > div > div:nth-child(1) > div > section > h1 > span")).getText();
         Assert.assertEquals(edition,expected);

     }
     public void tc003(){
    	 driver.findElementByXPath("/html/body/div[1]/div[1]/header/div[3]/div/div/nav/nav/ul/li[12]/span").click();
    	 driver.findElementByXPath("/html/body/div[1]/div[1]/div[2]/section[1]/div/div/div/div/div[1]/div[2]/ul/li[11]/a").click();
    	 String condition=driver.findElementByXPath("/html/body/div[1]/div[1]/div[3]/main/div/section/article/div/div[1]/div/section/div[2]/div/div[1]/div/div[2]/div[1]/div[4]").getText();
    	 System.out.println("Weather is " + condition);
     }

}
