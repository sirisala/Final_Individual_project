package org.GoogleCloud;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Googlecloud {
    WebDriver driver;
    By searchButton = By.name("q");
    By enterString = By.xpath("//input[@placeholder='Search']");

    By searchString = By.xpath("//div[@id='suggestion-partial-query-0']//b[contains(text(),'google cloud platform pricing calculator')] ");


    public Googlecloud(WebDriver driver) {
        this.driver = driver;
    }

    public void googleCloud(String searchElement) throws InterruptedException {
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
        driver.findElement(enterString).sendKeys(searchElement);
        Thread.sleep(2000);

        WebElement s =driver.findElement(searchString);
      //  s.sendKeys(Keys.ENTER);
        driver.findElement(searchButton).click();
        driver.findElement(searchString).click();
//        Thread.sleep(2000);
        Thread.sleep(2000);
    }
}
