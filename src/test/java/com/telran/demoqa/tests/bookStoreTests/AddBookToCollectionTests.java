package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).login("slana", "Slana!_1812");
    }

    @Test
    public void addBookToCollectionTest(){
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldBookTitle(text).clickByFirstBook().addToYourCollection().clickOnProfileButton();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));
    }


}
