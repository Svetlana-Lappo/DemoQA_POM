package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement userName;

    @FindBy(id="password")
    WebElement pswd;

    @FindBy(id="login")
    WebElement loginBtn;
    @FindBy(id="newUser")
    WebElement newUserBtn;

    public ProfilePage login(String name, String password){
        type(userName,2,name);
        type(pswd,2,password);
        loginBtn.click();
        return new ProfilePage(driver);

    }

    public LoginPage loginNegative(String name, String password){
        type(userName,2,name);
        type(pswd,2,password);
        loginBtn.click();
        return this;

    }

    public RegisterPage goToRegisterPage(){
        click(newUserBtn,2);
        return new RegisterPage(driver);
    }


  }



