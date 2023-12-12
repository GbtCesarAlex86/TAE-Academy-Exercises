package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
    }

    // Element's mapping
    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement logInBtn;


    // Element's methods
    public void enterUsername(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String psw){
        password.sendKeys(psw);
    }

    public void clickOnLogIn(){
        logInBtn.click();
    }

}
