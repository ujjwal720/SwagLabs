package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    /*
    The BasePage main use is to create the reusable methods which we will be using in
    our finsh class it can project specific + we can create the resusable methods for the
    selenium function which we basically used in our test execution.

    It can be diffrent from project but basic things will remain same.

     */

    int explicitwaitseconds=20;
    public WebDriver driver;
    int sleepDurationInMiliSeconds=10;

    public BasePage(){

        this.driver= DriverInit.intilization();
    }


    public void sendKeys(WebElement ele, String value){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(explicitwaitseconds));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        ele.sendKeys(value);
    }

    public String getUrltittle(){
        return driver.getTitle();
    }

    public void elementtoClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void switchtoiframe(String frame) {
        driver.switchTo().frame(frame);
    }

    public void switchtodefault() {
        driver.switchTo().defaultContent();
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void waitForElement(WebElement element){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(explicitwaitseconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getText(WebElement element) {
        String str = element.getText();
        return str;
    }

    public void sleepForDuration() {
        try {
            Thread.sleep(sleepDurationInMiliSeconds);
        } catch (Exception ex) {

        }
    }



}
