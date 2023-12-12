package com.globant.web.tests;

import com.globant.web.pages.CartPage;
import com.globant.web.pages.CheckoutPage;
import com.globant.web.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @BeforeClass
    public void setUp(){
        super.setUp();
        login("standard_user", "secret_sauce");
    }

    @Test
    public void purchaseAProduct(){
        HomePage homePage = getHomePage();
        selectProducts(homePage, 1);
        homePage.goToShoppingCart();
        CartPage cartPage = getCartPage();
        cartPage.clickOnCheckout();
        CheckoutPage checkoutPage = getCheckOutPage();
        checkoutPage.enterFirstname("Cesar");
        checkoutPage.enterSecondname("Tipan");
        checkoutPage.enterPostalcode("11111");
        checkoutPage.clickOnContinueBtn();
        checkoutPage.clickOnFinishBtn();
        Assert.assertTrue(checkoutPage.isPurchaseCompleted(), "The purchase was not completed successfully.");
    }
}