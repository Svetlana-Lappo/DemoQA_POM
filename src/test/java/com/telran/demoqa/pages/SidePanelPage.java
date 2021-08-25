package com.telran.demoqa.pages;

import com.telran.demoqa.tests.BrokenLinksAndImagesTests;
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

   // @FindBy(xpath = "//span[.='Text Box']")
   @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    WebElement textBoxBtn;

   @FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-5']")
   WebElement linksBtn;

    @FindBy(xpath="//div[@class='element-list collapse show']//li[@id='item-6']")
    WebElement imagesBtn;

    @FindBy(xpath = "//span[.='Tool Tips']")
    WebElement toolTipsBtn;



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

    public TextBoxPage selectTextBox(){
        textBoxBtn.click();
        return new TextBoxPage(driver);
    }

    public BrokenLinksAndImagesPage selectLinks() {
        clickWithAction(linksBtn,0,300);
        return new BrokenLinksAndImagesPage(driver);
    }

    public BrokenLinksAndImagesPage selectBrokenImages() {

        clickWithAction(imagesBtn,0,300);
        return new BrokenLinksAndImagesPage(driver);
    }

    public ToolTipsPage selectToolTips() {
        clickWithAction(toolTipsBtn,0,500);
        return new ToolTipsPage(driver);
    }
}
