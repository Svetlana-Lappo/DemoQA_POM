package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrowserWindowPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToAlertFrameWindowPage();
        new SidePanelPage(driver).goToBrowserWindowPage();
    }
    @Test
    public void newTabTest(){
        new BrowserWindowPage(driver).clickOnNewTabBtn();
        Assert.assertTrue(new BrowserWindowPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest(){
        new BrowserWindowPage(driver).clickOnNewWindowBtn();
        Assert.assertTrue(new BrowserWindowPage(driver).getTextFromNewWindow().contains("sample"));

    }
    @Test
    public void newWindowMessageTest(){
        new BrowserWindowPage(driver).clickOnNewWindowMessageBtn();
        Assert.assertTrue(new BrowserWindowPage(driver).getTextFromNewWindowMessage().contains("Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization."));

    }


}
