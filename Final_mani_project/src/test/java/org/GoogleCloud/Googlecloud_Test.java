package org.GoogleCloud;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Googlecloud_Test {


    WebDriver driver;

    Googlecloud g;
    PricingCalculator p;
    ClickOnLink c;

    String vmClass;
    String region;
    String ssd;
    String instance;
    String time;
    String cost;


    @Test
    @Parameters({"browser", "Url"})
     public void openGoogleCloud(String browser, String Url) throws InterruptedException {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
             g = new Googlecloud(driver);
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
             g = new Googlecloud(driver);
        }
        driver.get(Url);

//        Googlecloud g = new Googlecloud(driver);

    }
    @Test
    public void test() throws InterruptedException {
        g.googleCloud("Google Cloud Platform Pricing Calculator");

        c = new ClickOnLink(driver);
        c.openLink();


         p = new PricingCalculator(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        p.enterDetails("4");
        p.selectSeries();
        p.selectMachine();
        p.AddGpusCheckBox();
        p.selectTypeOfGpus();
        p.selectNumberOfGpus();
        p.selectLocalSsd();
        p.selectDataCenterLocation();
        p.selectCommittedUsage();
        p.Estimate();





    }
    @Test
    public void checkData(){
        vmClass  = p.getVmClassData().getText();
        region   = p.getLocation().getText();
        ssd      = p.getSsdData().getText();
        instance = p.getInstanceType().getText();
        time     = p.getCommitment().getText();
        cost     = p.getCost().getText();


        Assert.assertEquals(vmClass, "Provisioning model: Regular");
        Assert.assertEquals(region, "Region: Frankfurt");
        Assert.assertEquals(ssd, "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        Assert.assertEquals(instance, "Instance type: n1-standard-8\n" + "Committed Use Discount applied");
        Assert.assertEquals(time, "Commitment term: 1 Year");
        Assert.assertEquals(cost, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }



}
