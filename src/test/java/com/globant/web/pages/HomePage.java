package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    // Element's mapping
    @FindBy(className = "btn_inventory")
    private List<WebElement> products;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCart;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutMenuItem;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    // Element's methods
    public List<WebElement> getProducts() {
        return products;
    }

    public void clickOnProduct(WebElement product) {
        product.click();
    }

    public void goToShoppingCart(){
        shoppingCart.click();
    }

    public void clickOnLogOut(){
        logOutMenuItem.click();
    }

    public void clickOnMenuBtn(){
        menuBtn.click();
    }

    public boolean isOnHomepage(){
        return isElementDisplayed(loginLogo);
    }
}