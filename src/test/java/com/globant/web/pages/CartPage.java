package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    // Element's mapping

    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    @FindBy(className = "cart_button")
    private WebElement removeBtn;

    @FindBy(className = "cart_item_label")
    private WebElement cartItem;

    // Element's methods

    public void clickOnCheckout(){
        checkoutBtn.click();
    }

    public void clickOnRemove(){
        removeBtn.click();
    }

    public boolean isCartEmpty(){
        return isElementNotDisplayed(cartItem);
    }
}