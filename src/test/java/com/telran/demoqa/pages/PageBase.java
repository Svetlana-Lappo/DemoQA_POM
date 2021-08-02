package com.telran.demoqa.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import java.util.Random;

public class PageBase {

    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void type(WebElement element, int timeout, String text) {

        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException wde) {
            System.out.println(wde);
        }
    }
    public void clickWithAction(WebElement element, int x, int y){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+ x + ","+ y + ")");
        element.click();
        //actions.moveToElement(element).moveByOffset(x, y).click().build().perform();
    }

    public void scrollUpOrDown(int x, int y){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+ x + ","+ y + ")");
    }

    public void click(WebElement element, int timeout){
       try{
           new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();

       }catch (WebDriverException wde){
           System.out.println(wde);
       }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public void takeScreenshotField(WebElement element) throws IOException {
        element.isSelected();
        File screenshotEmptyField = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotEmptyField, new File(System.getProperty("user.dir") + "/screenshots/"
                + new Random().nextInt() + ".png"));

    }

    public void takeScreenshot(String pathToFile) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void typeWithAction(WebElement element, int x, int y, String text) {
        if (text != null) {
            clickWithAction(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void closeBanner(){
        driver.findElement(By.id("close-fixedban")).click();

    }
}
