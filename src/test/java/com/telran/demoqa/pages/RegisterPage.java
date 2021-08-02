package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement firstname;

    @FindBy(id = "lastname")
    WebElement lastname;

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement reCAPTCHA;
    @FindBy(id="register")
    WebElement registerBtn;

    public RegisterPage fillRegistrationForm(String fName, String lName, String usName, String pswd){

        type(firstname,2,fName);
        type(lastname,2,lName);
        type(userName,2,usName);
        type(password,2,pswd);

        return this;

    }

    public RegisterPage checkReCaptcha(){
        clickWithAction(reCAPTCHA,0,300);
        return this;
    }

    public RegisterPage clickOnRegisterButton(){
        click(registerBtn,2);
        pause(2000);
        driver.switchTo().alert().accept();
        return this;
    }

}
