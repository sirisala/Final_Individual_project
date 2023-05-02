package org.GoogleCloud;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickOnLink {
    WebDriver driver;

    By link = By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a/b");

    public ClickOnLink(WebDriver driver){
        this.driver=driver;
    }
    public void openLink() throws InterruptedException {
        driver.findElement(link).click();

        Thread.sleep(4000);

    }
}
