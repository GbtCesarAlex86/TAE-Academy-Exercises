package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    // Element's mapping
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement secondNameInput;

    @FindBy(id = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(className = "complete-header")
    private WebElement completedMsg;

    // Element's methods
    public void enterFirstname(String firstname){
        firstNameInput.sendKeys(firstname);
    }

    public void enterSecondname(String secondname){
        secondNameInput.sendKeys(secondname);
    }

    public void enterPostalcode(String postalcode){
        postalCodeInput.sendKeys(postalcode);
    }

    public void clickOnContinueBtn(){
        continueBtn.click();
    }

    public void clickOnFinishBtn(){
        finishBtn.click();
    }

    public boolean isPurchaseCompleted() {
        return isElementDisplayed(completedMsg);
    }
}