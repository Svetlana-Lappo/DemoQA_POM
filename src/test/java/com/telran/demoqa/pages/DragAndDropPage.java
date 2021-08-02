package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMeElement;

    @FindBy(id = "droppable")
    WebElement dropHereElement;


    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragMeElement,dropHereElement).build().perform();
        String textTo = dropHereElement.getText();
        if(textTo.equals("Dropped!")){
            System.out.println("PASS: Source is dropped to target as expected");
        }else{
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() {

        Actions actions = new Actions(driver);

        int xOffset1 = dragMeElement.getLocation().getX();
        int yOffset1 = dragMeElement.getLocation().getY();
        System.out.println("xOffset1----> " +xOffset1 + " yOffset1----> " +yOffset1);

        int xOffset = dropHereElement.getLocation().getX();
        int yOffset = dropHereElement.getLocation().getY();
        System.out.println("xOffset----> " +xOffset + " yOffset----> " +yOffset);

        xOffset =(xOffset - xOffset1) + 50;
        yOffset = (yOffset - yOffset1) +100;
        pause(2000);
        actions.dragAndDropBy(dragMeElement,xOffset,yOffset).build().perform();
        return this;
    }

    public DragAndDropPage dragAndDropBy100(){
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDropBy(dragMeElement,100,100).build().perform();
        return this;
    }
}
