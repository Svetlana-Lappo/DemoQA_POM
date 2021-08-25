package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase{
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="toolTipButton")
    WebElement toolTipBtn;
    @FindBy(css = ".tooltip-inner")
    WebElement toolTipsText;

    public ToolTipsPage hoverButtonToolTips() {
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipBtn).perform();
        String toolText = toolTipsText.getText();
        System.out.println("ToolTipText---> " + toolText);
        if(toolText.equalsIgnoreCase("You hovered over the Button")){
            System.out.println("Pass: ToolTip matching expected result");
        }else{
            System.out.println("Fail: ToolTip NOT matching expected result");
        }
        return this;
    }

    public ToolTipsPage hoverToolTipWithAttribute(){
        String actualToolTip = toolTipBtn.getAttribute("aria-describedby");
        String expectedToolTip = "You hovered over the Button";
        System.out.println("Actual Title of Tool Tip " + actualToolTip);
        if(actualToolTip.equals(expectedToolTip)){
            System.out.println("Test case Passed");
        }else{
            System.out.println("Test case Fail");
        }
        return this;
    }
}
