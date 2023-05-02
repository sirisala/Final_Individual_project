package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
        WebDriver driver;
        @Test
        public void open_link() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://pastebin.com/");
            driver.manage().window().maximize();

            PasteBin pb = new PasteBin(driver);

            pb.enterText(" \"Hello from WebDriver\" ");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)", "");

            pb.clickDropDown();
            pb.titleName("oo1");


            pb.create();
            pb.closewindow();

        }
}
