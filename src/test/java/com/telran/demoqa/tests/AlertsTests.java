package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AlertsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToAlertFrameWindowPage();
        new SidePanelPage(driver).goToAlertsPage();
    }

    @Test
    public void alertWaitTest(){
        new AlertsPage(driver).clickAlertButtonTwoAndWait();
    }

    @Test
    public void cancelAlertTest(){
        new AlertsPage(driver).clickAlertButtonThree().clickOnCancelOrOkBtn("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void alertSendTextTest(){
        new AlertsPage(driver).clickAlertButtonFour().sendTextToAlert("Hello");
        Assert.assertTrue(new AlertsPage(driver).getConfirmOfInputText().contains("Hello"));
    }
}
