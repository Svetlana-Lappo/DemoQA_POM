package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class DatePickerPage extends PageBase{
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="datePickerMonthYearInput")
    WebElement selectDateField;

    @FindBy(css=".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(css=".react-datepicker__year-select")
    WebElement selectYear;

    @FindBy(css = ".react-datepicker__day")
    List<WebElement> selectDay;

    @FindBy(id="dateAndTimePickerInput")
    WebElement selectDateAndTimeField;

    @FindBy(css=".react-datepicker__month-read-view")
    WebElement selectMonth1;

    @FindBy(css=".react-datepicker__month-option")
    List<WebElement> blockOfMonths;

    @FindBy(css=".react-datepicker__year-read-view")
    WebElement selectYear1;

    @FindBy(css=".react-datepicker__year-option")
    List<WebElement> blockOfYears;

    @FindBy(css=".react-datepicker__time-list-item ")
    List<WebElement> blockOfTimes;



    public DatePickerPage selectDateToInput(String month, String year, String date) {
        closeBanner();
        click(selectDateField,2);
        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        selectDay.get(getIndexElementByDate(month,date)).click();
        return this;
    }

    public int getIndexElementByDate(String month, String date){

        for(WebElement element: selectDay){
            String[] dataInfo = element.getAttribute("aria-label").split(",");
            if(dataInfo[1].contains(month) && dataInfo[1].contains(date)){
                return selectDay.indexOf(element);

            }
        }

      return -1;
    }

    public void selectDateAndTimeToInput(String month, String year, String date, String time){
     scrollUpOrDown(0,200);
     click(selectDateAndTimeField,2);
     click(selectMonth1,2);
     click(blockOfMonths.get(getIndexOfMonthFromBlock(month)),2);
     click(selectYear1,2);
     click(blockOfYears.get(getIndexOfYear(year)),2);
     click(selectDay.get(getIndexElementByDate(month,date)),2);
     click(blockOfTimes.get(getIndexOfTimeFromBlock(time)),2);

    }

    public int getIndexOfMonthFromBlock(String month) {
        for(WebElement element: blockOfMonths){
            if(element.getText().equals(month)){
              return blockOfMonths.indexOf(element);
            }
        }
        return -1;
    }


   public int getIndexOfYear(String year){
       System.out.println("getIndexOfYear");
       while(true) {
           int topYear = Integer.parseInt(blockOfYears.get(1).getText());
           int currentYear = Integer.parseInt(year);

           if (topYear < currentYear) {
               scroll(blockOfYears.get(0));
           } else if (currentYear < topYear - 10) {
               scroll(blockOfYears.get(12));
           } else {
               return topYear - currentYear + 1;
           }
       }

   }

   private void scroll(WebElement element){
        for(int i=0; i<11;i++){
            click(element,2);
        }
   }

    public int getIndexOfTimeFromBlock(String time){
        for(WebElement element: blockOfTimes){
            if(element.getText().equals(time)){
                return blockOfTimes.indexOf(element);
            }
        }
        return -1;

    }


}
