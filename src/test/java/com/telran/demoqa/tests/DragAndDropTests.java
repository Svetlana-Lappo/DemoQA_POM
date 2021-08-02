package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DragAndDropPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        new HomePage(driver).goToInteractionsPage();
        new SidePanelPage(driver).selectDroppable();
    }

    @Test
    public void droppableTest(){
        new DragAndDropPage(driver).actionDragMe();
    }

    @Test
    public void droppableTest1(){
        new DragAndDropPage(driver).dragAndDropBy();
    }

    @Test
    public void droppableTest2(){
        new DragAndDropPage(driver).dragAndDropBy100();
    }
}
