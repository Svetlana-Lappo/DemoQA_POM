package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToWidgetsPage();
        new SidePanelPage(driver).selectSelectMenuBtn();
    }

    @Test
    public void clickOnStyleTest(){
        new SelectMenuPage(driver).clickOnOldStyleMenu("Blue");
    }

    @Test
    public void multiSelectDropDownTest(){
        new SelectMenuPage(driver).clickMultiSelectDropDown(new String[]{"Red","Black","Blue"});
    }

    @Test
    public void valueSelectTest(){
        new SelectMenuPage(driver).clickOnValueSelect("Another root option");
    }

    @Test
    public void oneSelectTest(){
        new SelectMenuPage(driver).clickOnSelectOne("Prof.");
    }

    @Test
    public void standardMultiSelectTest(){
        new SelectMenuPage(driver).clickOnStandardMultiSelect("saab");
    }
}
