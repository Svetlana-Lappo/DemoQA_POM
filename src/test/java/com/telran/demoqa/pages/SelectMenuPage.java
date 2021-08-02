package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends PageBase{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="oldSelectMenu")
    WebElement oldStyleSelectMenu;

    @FindBy(xpath="(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath="//html")
    WebElement space;

    @FindBy(xpath="(//div[@class=' css-1wy0on6'])[1]")
    WebElement valueSelectMenu;

    @FindBy(id="selectOne")
    WebElement selectOne;

    @FindBy(id="cars")
    WebElement standardMultiSelectMenu;


    public SelectMenuPage clickOnOldStyleMenu(String text) {

        Select select = new Select(oldStyleSelectMenu);
        select.selectByVisibleText(text);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + "<------It is first");

        for (WebElement option: options){
            System.out.println(option.getText());
        }

        return this;
    }

    public SelectMenuPage clickMultiSelectDropDown(String[] textArr) {
       clickWithAction(multiSelectDropDown,0,50);
        for (String text : textArr) {
            WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", text)));
            element.click();
        }
        space.click();

        return this;
    }

    public SelectMenuPage clickOnValueSelect(String item) {
        clickWithAction(valueSelectMenu,0,20);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", item)));
        element.click();

        return this;
    }

    public SelectMenuPage clickOnSelectOne(String text) {
        clickWithAction(selectOne,0,150);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']", text)));
        element.click();
        return this;
    }

    public SelectMenuPage clickOnStandardMultiSelect(String carModel) {
        scrollUpOrDown(0,-50);
        Select select = new Select(standardMultiSelectMenu);
        select.selectByValue(carModel);
        return this;
    }
}
