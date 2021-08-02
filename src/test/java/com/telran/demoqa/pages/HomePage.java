package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='category-cards']/div[6]")
    WebElement bookStoreAppCard;
    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindowCard;
    @FindBy(xpath = "//div[@class='category-cards']/div[4]")
    WebElement widgetsCard;

    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement formsCard;

    @FindBy(xpath = "//div[@class='category-cards']/div[5]")
    WebElement interactionsCard;



    public BookStorePage goToBookStore(){
        click(bookStoreAppCard,2);
        return new BookStorePage(driver);
    }

    public SidePanelPage goToAlertFrameWindowPage(){
        clickWithAction(alertsFrameWindowCard,0,300);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToWidgetsPage() {
        clickWithAction(widgetsCard,0,300);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToForms() {
        clickWithAction(formsCard,0,200);
        return new SidePanelPage(driver);
    }

    public SidePanelPage goToInteractionsPage() {
        clickWithAction(interactionsCard,0,300);
        return new SidePanelPage(driver);
    }
}
