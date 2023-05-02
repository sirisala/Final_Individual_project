package org.GoogleCloud;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PricingCalculator {
    WebDriver driver;
    By newFrame = By.xpath("//iframe[contains(@name,'goog_')]");

    By enterInstances = By.xpath("/html[1]/body[1]/md-content[1]/md-card[1]/div[1]/md-card-content[1]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/div[1]/form[1]/div[1]/div[1]/md-input-container[1]/input[1]");


    By series =By.xpath("//md-select[@name='series']/parent::md-input-container");

    By seriesType=By.xpath("//*[@id='select_option_212']");

    By machines = By.xpath("//label[text()='Machine type']/parent::md-input-container");

    By machineType =By.xpath("//div[normalize-space()='n1-standard-8 (vCPUs: 8, RAM: 30GB)']");
    By GPUsCheckBox =By.xpath("//md-checkbox[@aria-label='Add GPUs']");

    By GPUTypeDropBox =By.xpath("//md-select[@placeholder='GPU type']");

    By numberOfGPUDropBox =By.xpath("//md-select[@placeholder='Number of GPUs']");
   By numberOfGpus =By.xpath ("//*[@id=\"select_option_497\"]/div[1]");

    By gpusType =By.xpath("//*[@id=\"select_option_494\"]/div[1]");

    By localSsdDropBox=By.xpath("//md-select[@placeholder='Local SSD']");

    By localSsdModel=By.xpath("//div[normalize-space()='2x375 GB']");

    By dataCenterLocationDropBox =By.xpath("//md-select[@placeholder='Datacenter location']");

    //By dataCenterLocation= By.xpath("//md-option[@id='select_option_252']//div[@class='md-text ng-binding'][normalize-space()='Frankfurt (europe-west3)']");

    By commitedUageDropBox=By.xpath("//md-select[@placeholder='Committed usage']");

    By commitedUsageOneYear=By.xpath("//*[@id=\"select_option_134\"]/div");

//    @FindBy(xpath="//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")
//    WebElement addToEstimateButton;
    By addToEstimateButton=By.xpath("//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']");






    public PricingCalculator(WebDriver driver){
        this.driver=driver;

    }

    public void enterDetails(String instances){
        WebElement f =driver.findElement(newFrame);
        driver.switchTo().frame(f);

        driver.switchTo().frame("myFrame");
        driver.findElement(enterInstances).sendKeys(instances);
    }
    public void selectSeries() throws InterruptedException {
        driver.findElement(series).click();
        Thread.sleep(1000);
        driver.findElement(seriesType).click();

    }
    public void selectMachine() throws InterruptedException {

        driver.findElement(machines).click();
        Thread.sleep(1000);
        driver.findElement(machineType).click();

    }
    public void AddGpusCheckBox() {
        driver.findElement(GPUsCheckBox).click();
    }
    public void selectTypeOfGpus() throws InterruptedException {
        driver.findElement(GPUTypeDropBox).click();
        Thread.sleep(1000);
        driver.findElement(gpusType).click();

    }
    public void selectNumberOfGpus() throws InterruptedException {
        driver.findElement(numberOfGPUDropBox).click();
        Thread.sleep(500);
        driver.findElement(numberOfGpus).click();
    }
    public void selectLocalSsd() throws InterruptedException {
        driver.findElement(localSsdDropBox).click();
        Thread.sleep(1000);
        driver.findElement(localSsdModel).click();
    }
    public void selectDataCenterLocation() throws InterruptedException {
        driver.findElement(dataCenterLocationDropBox).click();
        Thread.sleep(1000);
        WebElement lo= driver.findElement(dataCenterLocationDropBox);
        lo.sendKeys("Frankfurt (europe-west3)");
      // lo.sendKeys(Keys.ENTER);
    }
    public void selectCommittedUsage() throws InterruptedException {
        driver.findElement(commitedUageDropBox).click();
        Thread.sleep(1000);
        driver.findElement(commitedUsageOneYear).click();
    }

    public void Estimate() {
        driver.findElement(addToEstimateButton).click();
    }


    By vmClassData = By.className("//div[normalize-space()='Provisioning model: Regular']");

    By location =By.xpath("//div[normalize-space()='Region: Frankfurt']");

    By commitedTime= By.xpath ("//div[normalize-space()='Commitment term: 1 Year']");
    By instanceData = By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    By ssdData=By.xpath("//div[contains (text(),'Local SSD: 2x375 GiB')]");

    By amount=By.xpath("//b[contains(text(),'Total Estimated Cost:')]");
    public WebElement getVmClassData(){

        WebElement vmData= (WebElement) vmClassData;
        return vmData;
    }
    public WebElement getLocation(){
        WebElement lotn= (WebElement) location;
        return lotn;
    }
    public WebElement getCommitment(){
        WebElement time= (WebElement) commitedTime;
        return time;
    }
    public WebElement getInstanceType(){
        WebElement instance= (WebElement) instanceData;
        return instance;
    }
    public WebElement getSsdData(){
        WebElement ssd= (WebElement) ssdData;
        return ssd;
    }
    public WebElement getCost(){
        WebElement price= (WebElement) amount;
        return price;
    }


}
