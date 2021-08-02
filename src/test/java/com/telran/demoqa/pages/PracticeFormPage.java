package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class PracticeFormPage extends PageBase{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="firstName")
    WebElement firstName;

    @FindBy(id="lastName")
    WebElement lastName;

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userNumber")
    WebElement userPhoneNumber;

    @FindBy(id="dateOfBirthInput")
    WebElement dateOfBirthInput;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;

    @FindBy(id="subjectsInput")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    @FindBy(xpath="//label[@for='hobbies-checkbox-1']")
    WebElement checkboxSports;

    @FindBy(xpath="//label[@for='hobbies-checkbox-2']")
    WebElement checkboxReading;

    @FindBy(xpath="//label[@for='hobbies-checkbox-3']")
    WebElement checkboxMusic;

    @FindBy(xpath="//html")
    WebElement space;

    @FindBy(id="uploadPicture")
    WebElement chooseFileBtn;

    @FindBy(id="currentAddress")
    WebElement currentAddressArea;

    @FindBy(id="state")
    WebElement state;

    @FindBy(id="react-select-3-input")
    WebElement stateBlock;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="react-select-4-input")
    WebElement cityBlock;

    @FindBy(id="submit")
    WebElement submitBtn;

    @FindBy(id="example-modal-sizes-title-lg")
    WebElement dialogForm;
    @FindBy(id="closeLargeModal")
    WebElement closeBtn;


    public PracticeFormPage fillPersonalData(String fname, String lname, String email, String phone) {

        type(firstName,2,fname);
        type(lastName,2,lname);
        type(userEmail,2,email);
        type(userPhoneNumber,2,phone);

        return this;
    }


    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            click(maleBtn,2);
        }else if (gender.equals("Female")){
            femaleBtn.click();
        }else {
            otherBtn.click();
        }
        return this;
    }

    public PracticeFormPage typeOfDay(String bDay) {
        clickWithAction(dateOfBirthInput, 0, 200);
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }


    public PracticeFormPage addSubject(String text) {

      type(subjectInput,3,text);
      click(selectInput,3);


      return this;
    }
    public PracticeFormPage addSubjectWithEnter(String text) {

        type(subjectInput,3,text);
        subjectInput.sendKeys(Keys.ENTER);

       return this;
    }

    public PracticeFormPage selectHobbies(String[] hobbies) {

        for (String hobby : hobbies) {

            if (hobby.equals("Sports")) {
                click(checkboxSports, 2);
            }
            if (hobby.equals("Reading")) {
                click(checkboxReading, 2);
            }
            if (hobby.equals("Music")) {
                click(checkboxMusic, 2);
            }else{
              space.click();
            }

        }

        return this;
    }


    public PracticeFormPage uploadFile(String path) {
        chooseFileBtn.sendKeys(path);
        pause(2000);
        return this;
    }

    public PracticeFormPage typeAddress(String text) {
        type(currentAddressArea,2,text);
        return this;
    }

    public PracticeFormPage inputState(String text) {

        clickWithAction(state,0,300);
        stateBlock.sendKeys(text);
        stateBlock.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage inputCity(String cityName) {
        clickWithAction(city,0,300);
        cityBlock.sendKeys(cityName);
        cityBlock.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage clickOnSubmitBtn(){
        clickWithAction(submitBtn,0,300);
        return this;
    }

    public String getTitleFromDialog() {

        return dialogForm.getText();
    }

    public PracticeFormPage closeSuccessDialog() {
        closeBanner();
        closeBtn.click();
        return this;
    }
}
