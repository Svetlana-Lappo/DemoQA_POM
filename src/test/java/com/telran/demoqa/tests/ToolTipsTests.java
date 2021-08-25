package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import com.telran.demoqa.pages.ToolTipsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToWidgetsPage();
        new SidePanelPage(driver).selectToolTips();
    }

    @Test
    public void hoverToolTipsTest(){
        new ToolTipsPage(driver).hoverButtonToolTips();
    }

//    @Test
//    public void hoverToolTipsWithAttributeTest(){
//        new ToolTipsPage(driver).hoverToolTipWithAttribute();
//    }
}
