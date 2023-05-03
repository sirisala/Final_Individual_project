package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google_Price_Cal_Test {
    WebDriver driver;
    Google_Price_Calculate_App obj;
    String VM_Of_Class;
    String region;
    String S_S_D;
    String No_of_Instance;
    String Time_Taken;
    String Cost_of_USD;


    @BeforeClass
    @Parameters({"browser", "Url"})
    public void openbrowser(String browser, String Url)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            obj = new Google_Price_Calculate_App(driver);
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            obj = new Google_Price_Calculate_App(driver);
        }
        driver.get(Url);
    }

    @Test
    public void checkInformationInVmClassString() throws InterruptedException
    {

//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        obj = new Google_Price_Calculate_App(driver);
//
//        driver.get("https://cloud.google.com/products/calculator");

        driver.manage().window().maximize();
        obj.Number_Of_Instances_Field("4");
        obj.Select_Series();
        Thread.sleep(5000);
        obj.Select_Machine_Type();
        Thread.sleep(5000);
        obj.Add_Gpus_CheckBox();
        obj.Select_Type_Of_Gpus();
        obj.Select_Number_Of_Gpus();
        obj.Select_Local_s_s_d();
        obj.Select_Data_Center_Location();
        obj.Select_Committed_Usage();
        obj.Push_Add_To_Estimate();
        //Data Store from Object

        VM_Of_Class = obj.Get_Vm_Class_Data().getText();
        region=obj.Get_Location().getText();
        S_S_D = obj.Get_Ssd_Data().getText();
        No_of_Instance = obj.Get_Instance_Type().getText();
        Time_Taken = obj.Get_Commitment().getText();
        Cost_of_USD = obj.Get_Cost().getText();
    }
    @Test
    public void check_Data_is_correct()
    {
        Assert.assertEquals(VM_Of_Class,"Provisioning model: Regular");
        Assert.assertEquals(region,"Region: Frankfurt");
        Assert.assertEquals(S_S_D, "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        Assert.assertEquals(No_of_Instance, "Instance type: n1-standard-8\n"+ "Committed Use Discount applied");
        Assert.assertEquals(Time_Taken, "Commitment term: 1 Year");
        Assert.assertEquals(Cost_of_USD, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }
    @AfterClass
    public void driverclode()
    {
        driver.close();
    }

}
