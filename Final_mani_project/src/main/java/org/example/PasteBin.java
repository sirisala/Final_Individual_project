package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class PasteBin {

   WebDriver driver;

   By createText = By.id("postform-text");

   By expirationPaste = By.xpath("//*[@id=\"select2-postform-expiration-container\"]");


   By selectElement = By.xpath("//span[@class='select2-results']/ul/li[3]");

   By pasteTitle = By.xpath("//input[@id='postform-name']");

   public PasteBin(WebDriver driver ){
      this.driver = driver;
   }

   public void enterText(String text) throws InterruptedException {
      driver.findElement(createText).sendKeys(text);
      Thread.sleep(2000);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,500)", "");
      Thread.sleep(2000);
   }

   public void clickDropDown() throws InterruptedException {
      WebElement element = driver.findElement(expirationPaste);
      element.click();
      Thread.sleep(1000);

      driver.findElement(selectElement).click();




   }public void titleName(String title) throws InterruptedException {
      driver.findElement(pasteTitle).sendKeys(title);
      Thread.sleep(2000);

   }

   public void create() {
      driver.findElement(By.xpath("//button[contains(text(),'Create New Paste')]")).click();

   }
   public void closewindow(){
      driver.close();
   }



}