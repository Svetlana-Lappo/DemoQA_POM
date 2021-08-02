package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends PageBase{
    public BookStorePage(WebDriver driver) {
        super(driver);
    }
   @FindBy(id="login")
    WebElement loginBtn;

    @FindBy(id="newUser")
    WebElement newUserBtn;

    @FindBy(id="searchBox")
    WebElement searchInput;

    @FindBy(xpath="//span[@class='mr-2']/a")
    WebElement nameOfBook;

    @FindBy(css=".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement firstTitleInBookList;
    
    @FindBy(css=".text-right.fullButton")
    WebElement addToCollectionBtn;

    @FindBy(css=".show #item-3")
    WebElement profileBtn;

    public LoginPage goToLoginPage(){
        click(loginBtn,2);
        return new LoginPage(driver);
    }

    public RegisterPage goToRegisterPage(){
        click(newUserBtn,2);
        return new RegisterPage(driver);
    }

    public BookStorePage typeInSearchFieldBookTitle(String text) {
       // pause(500);
        type(searchInput,2,text);
        return this;
    }


    public String takeNameOfBook() {
        pause(2000);
        return nameOfBook.getText();
    }

    public String verifyEmptyField() {
        return firstTitleInBookList.getText();
    }

    public BookStorePage clickByFirstBook() {
        click(nameOfBook,2);
        return this;
    }

    public BookStorePage addToYourCollection() {
       // click(addToCollectionBtn,2);
        clickWithAction(addToCollectionBtn,0,700);
        pause(2000);
        driver.switchTo().alert().accept();//alert Form accept
        return this;
    }

    public ProfilePage clickOnProfileButton() {
        click(profileBtn,2);
        return new ProfilePage(driver);
    }
}
