package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromCollectionTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).login("slana", "Slana!_1812");
    }
    @Test
    public void deleteBookFromCollectionTest(){

        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldBookTitle(text).clickByFirstBook().addToYourCollection().clickOnProfileButton().clickOnTrashToDeleteBook();

    }

}
