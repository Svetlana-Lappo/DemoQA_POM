package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends PageBase{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName-value")
    WebElement user;
    @FindBy(id="submit")
    WebElement logOutBth;
    @FindBy(xpath = "//*[@id='delete-record-undefined']")
    List<WebElement> booksList;
    @FindBy(id = "closeSmallModal-ok")
    WebElement okBtn;

    public ProfilePage verifyUserName(String userName){
        if(user.getText().equalsIgnoreCase(userName)){
            System.out.println("Correct user name: " + user.getText());
        }else{
            System.out.println("Incorrect user name: " +user.getText());
        }
        return this;
    }

    public LoginPage logOut(){
        logOutBth.click();
        return new LoginPage(driver);
    }

    public ProfilePage clickOnTrashToDeleteBook() {
        click(booksList.get(0),2);
        pause(500);
        click(okBtn,2);
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }
}
