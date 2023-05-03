package org.example;

import java.lang.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google_Price_Calculate_App
{
    WebDriver driver;
    public Google_Price_Calculate_App(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


//    }
    @FindBy(xpath ="/html[1]/body[1]/md-content[1]/md-card[1]/div[1]/md-card-content[1]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/div[1]/form[1]/div[1]/div[1]/md-input-container[1]/input[1]")
    WebElement instance_Field;
    @FindBy(xpath="//iframe[contains(@name,'goog_')]")
    WebElement new_Frame;
    public void Number_Of_Instances_Field(String NumberOfInstances) {
        driver.switchTo().frame(new_Frame);
        //frame inside frame
        driver.switchTo().frame("myFrame");
        instance_Field.sendKeys(NumberOfInstances);
    }

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    WebElement cookies_Ok_Btn;
    public void ManageCookie() throws InterruptedException {
        if (cookies_Ok_Btn.isDisplayed()) {
            cookies_Ok_Btn.click();
            Thread.sleep(1000);
        }
    }

    @FindBy(xpath="//md-select[@name='series']/parent::md-input-container")
    WebElement series;

//    class="md-text ng-binding"
    @FindBy(xpath="//md-option[@id='select_option_212']")
    WebElement Series_Type;
    public void Select_Series() throws InterruptedException {
        series.click();
        Thread.sleep(1000);
        Series_Type.click();
    }
    //first select series then MachineType

    @FindBy(xpath="//label[text()='Machine type']/parent::md-input-container")
    WebElement machine_Type_DropBox;
    @FindBy(xpath="//div[normalize-space()='n1-standard-8 (vCPUs: 8, RAM: 30GB)']")
    WebElement machineType;
    public void Select_Machine_Type() throws InterruptedException {
        machine_Type_DropBox.click();
        Thread.sleep(1000);
        machineType.click();
    }
    @FindBy(xpath="//md-checkbox[@aria-label='Add GPUs']")
    WebElement gpus_Check_Box;
    @FindBy(xpath="//md-select[@placeholder='GPU type']")
    WebElement Gpu_Type_Drop_Box;
    public void Add_Gpus_CheckBox()
    {
        gpus_Check_Box.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Number of GPUs']")
    WebElement number_Of_Gpus_DropBox;
    @FindBy(xpath ="//md-option[@id='select_option_497']")
    WebElement number_Of_Gpus;
    @FindBy(xpath="//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement gpus_Type;
    public void Select_Type_Of_Gpus() throws InterruptedException {
        Gpu_Type_Drop_Box.click();
        Thread.sleep(1000);
        gpus_Type.click();
    }
    public void Select_Number_Of_Gpus() throws InterruptedException {
        number_Of_Gpus_DropBox.click();
        Thread.sleep(500);
        number_Of_Gpus.click();
    }

    @FindBy(xpath="//md-select[@placeholder='Local SSD']")
    WebElement Local_Ssd_DropBox;
    @FindBy(xpath="//div[normalize-space()='2x375 GB']")
    WebElement Local_Ssd_Model;

    public void Select_Local_s_s_d() throws InterruptedException {
        Local_Ssd_DropBox.click();
        Thread.sleep(1000);
        Local_Ssd_Model.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Datacenter location']")
    WebElement Data_Center_Location_Drop_Box;
    @FindBy(xpath="//md-option[@id='select_option_253']//div[@class='md-text ng-binding'][normalize-space()='Frankfurt (europe-west3)']")
    WebElement Data_Center_Location;
    public void Select_Data_Center_Location() throws InterruptedException {
        Data_Center_Location_Drop_Box.click();
        Thread.sleep(1000);
        Data_Center_Location.click();
    }
    @FindBy(xpath="//md-select[@placeholder='Committed usage']")
    WebElement Commited_Uage_Drop_Box;
    @FindBy(xpath="//md-option[@id='select_option_134']")
    WebElement Commited_Usage_One_Year;
    public void Select_Committed_Usage() throws InterruptedException {
        Commited_Uage_Drop_Box.click();
        Thread.sleep(1000);
        Commited_Usage_One_Year.click();
    }
    @FindBy(xpath="//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")
    WebElement Add_To_Estimate_Button;
    public void Push_Add_To_Estimate()
    {
        Add_To_Estimate_Button.click();
    }
    @FindBy(xpath="//div[normalize-space()='Provisioning model: Regular']")
    WebElement Vm_Class_Data;

    public WebElement Get_Vm_Class_Data()
    {
        WebElement vmData = Vm_Class_Data;
        return vmData;
    }
    @FindBy(xpath="//div[normalize-space()='Region: Frankfurt']")
    WebElement location;
    public WebElement Get_Location()
    {
        WebElement loc=location;
        return loc;
    }


    @FindBy(xpath="//div[normalize-space()='Commitment term: 1 Year']")
    WebElement commitedTime;

    public WebElement Get_Commitment(){
        WebElement time=commitedTime;
        return time;
    }
    @FindBy(xpath="//div[contains (text(),'Instance type: n1-standard-8')]")
    WebElement instanceData;

    public WebElement Get_Instance_Type(){
        WebElement instance=instanceData;
        return instance;
    }
    @FindBy(xpath="//div[contains (text(),'Local SSD: 2x375 GiB')]")
    WebElement ssdData;

    public WebElement Get_Ssd_Data()
    {
        WebElement ssd=ssdData;
        return ssd;
    }
    @FindBy(xpath="//b[contains(text(),'Total Estimated Cost:')]")
    WebElement amount;
    public WebElement Get_Cost(){
        WebElement price=amount;
        return price;
    }
}
