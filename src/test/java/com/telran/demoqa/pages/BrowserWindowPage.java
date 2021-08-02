package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrowserWindowPage extends PageBase{
    public BrowserWindowPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="tabButton")
    WebElement newTabBtn;

    @FindBy(id="sampleHeading")
    WebElement sampleText;

    @FindBy(id="windowButton")
    WebElement windowBtn;

    @FindBy(id="messageWindowButton")
    WebElement newWindowMessageBtn;

    @FindBy(xpath="//body")
    WebElement newWindowMessageText;



    public BrowserWindowPage clickOnNewTabBtn() {
        click(newTabBtn,2);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewTab() {
        return sampleText.getText();
    }

    public BrowserWindowPage clickOnNewWindowBtn() {
        click(windowBtn,2);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }
    public String getTextFromNewWindow() {
        return sampleText.getText();
    }

    public BrowserWindowPage clickOnNewWindowMessageBtn() {
        click(newWindowMessageBtn,2);
        List<String> newWindowMessage = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowMessage.get(1));
        return this;
    }

    public String getTextFromNewWindowMessage() {
        return newWindowMessageText.getText();
    }



}
