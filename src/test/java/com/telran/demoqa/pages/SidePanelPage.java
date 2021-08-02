package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }
   @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;

    @FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-8']")
    WebElement selectMenuBtn;
//    @FindBy(xpath = "//span[.='Select Menu']")
//    WebElement selectMenuBtn;
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormBtn;

    @FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-2']")
    WebElement datePickerBtn;

    //@FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-3']")
    @FindBy(xpath="//span[.='Droppable']")
    WebElement droppableBtn;




    public BrowserWindowPage goToBrowserWindowPage(){
       clickWithAction(browserWindowsBtn,0,300);
        return new BrowserWindowPage(driver);
    }
    public AlertsPage goToAlertsPage(){
        clickWithAction(alertsBtn,0,300);
        return new AlertsPage(driver);
    }
    public SelectMenuPage selectSelectMenuBtn(){
        clickWithAction(selectMenuBtn,0,800);
        return new SelectMenuPage(driver);
    }

    public PracticeFormPage selectPracticeForm() {
        clickWithAction(practiceFormBtn,0,300);
        return new PracticeFormPage(driver);
    }

    public DatePickerPage selectDatePickerPage() {
        clickWithAction(datePickerBtn,0,300);
        return new DatePickerPage(driver);

    }

    public DragAndDropPage selectDroppable() {
        clickWithAction(droppableBtn,0,300);
        return new DragAndDropPage(driver);
    }
}
