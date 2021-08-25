package com.telran.demoqa.tests;

import com.telran.demoqa.helpers.JSExecutor;
import com.telran.demoqa.pages.AlertsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @Test
    public void executorTest(){
        new HomePage(driver).goToElementsPage();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).typeDataWithExecutor("li","li.chang@gmail.com").clickOnSubmitJSE();
    }

    @Test
    public void checkBoxWithJSETest(){
        new HomePage(driver).goToForms();
        new SidePanelPage(driver).selectPracticeForm();
        new JSExecutor(driver).checkBoxJSE().alertWithJSE();
        new AlertsPage(driver).acceptAlert();
        new JSExecutor(driver).refreshBrowserWithJSE().getTitlePageWithJSE().getURLPageWithJSE().scrollWithJSE();
    }
}
