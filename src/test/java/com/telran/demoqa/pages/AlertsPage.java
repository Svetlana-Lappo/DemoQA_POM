package com.telran.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class AlertsPage extends PageBase{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="timerAlertButton")
    WebElement alertTwoBtn;
    @FindBy(id="confirmButton")
    WebElement alertThreeBtn;
    @FindBy(id="confirmResult")
    WebElement confirmText;
    @FindBy(id="promtButton")
    WebElement alertFourBtn;
    @FindBy(xpath="//span[@id='promptResult']")
    WebElement confirmSendText;



    public AlertsPage clickAlertButtonTwoAndWait() {
        click(alertTwoBtn,2);

          Alert myAlert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
          myAlert.accept();
          return this;
    }

    public AlertsPage clickAlertButtonThree() {
        click(alertThreeBtn,2);
        return this;
    }

    public AlertsPage clickOnCancelOrOkBtn(String text) {
        if(text!=null && text.equals("Cancel")){
            driver.switchTo().alert().dismiss();
            return this;

        }else if(text!=null && text.equals("Ok")){
            driver.switchTo().alert().accept();

        }

        return this;
    }

    public String getConfirmResult() {
        return confirmText.getText();
    }

    public AlertsPage clickAlertButtonFour() {
        click(alertFourBtn,2);
        return this;
    }

    public AlertsPage sendTextToAlert(String text) {
        if(text!=null){
            driver.switchTo().alert().sendKeys(text);
            System.out.println(driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }

        return this;
    }

    public String getConfirmOfInputText() {

        return confirmSendText.getText();
    }

    public AlertsPage acceptAlert(){
        driver.switchTo().alert().accept();
        return this;
    }
}
