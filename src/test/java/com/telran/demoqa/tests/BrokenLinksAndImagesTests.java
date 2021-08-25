package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrokenLinksAndImagesPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class BrokenLinksAndImagesTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToElementsPage();

    }

    @Test
    public void getAllLinksTest(){
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksAndImagesPage(driver).checkAllUrl();
    }

    @Test
    public void getBrokenLinksTest()  {
        new SidePanelPage(driver).selectLinks();
        new BrokenLinksAndImagesPage(driver).checkBrokenLinks();
    }

    @Test
    public void getBrokenImagesTest(){
        new SidePanelPage(driver).selectBrokenImages();
        new BrokenLinksAndImagesPage(driver).checkBrokenImages();
    }
}
