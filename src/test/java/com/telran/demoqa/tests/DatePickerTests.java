package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DatePickerPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTests extends TestBase{

    @BeforeMethod

    public void ensurePreconditions(){
        new HomePage(driver).goToWidgetsPage();
        new SidePanelPage(driver).selectDatePickerPage();
    }


    @Test
    public void datePickerTestWithSelect(){
        new DatePickerPage(driver).selectDateToInput("September","2021","30");
    }

    @Test
    public void dateAndTimePickerTestWithSelect(){
        new DatePickerPage(driver).selectDateAndTimeToInput("September","2007","15","17:00");
    }
}
