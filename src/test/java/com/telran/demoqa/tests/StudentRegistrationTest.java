package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PracticeFormPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentRegFormTest(){
        new PracticeFormPage(driver)
                .fillPersonalData("Alex","Dunkel","al.dunkel@gmail.com","0123456789")
                .selectGender("Male").typeOfDay("12 May 2001").addSubjectWithEnter("Maths").selectHobbies(new String[]{"Music"})
                .uploadFile("C:\\Tools\\birds.jpg")
                .typeAddress("Tortuga")
               .inputState("NCR")
               .inputCity("Delhi").clickOnSubmitBtn();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleFromDialog().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeSuccessDialog();
    }
}
