package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

     @BeforeMethod
     public void ensurePrecondition(){
         new HomePage(driver).goToBookStore().goToLoginPage().goToRegisterPage();

     }



     @Test
    public void registrationPositiveTest(){
         int i = (int) (System.currentTimeMillis()/1000%3600);

         new RegisterPage(driver).fillRegistrationForm("Alex","Olaf","alaf" + i,"Alaf1!_" + i)
                 .checkReCaptcha();
        // new RegisterPage(driver).clickOnRegisterButton();


    }
}
