package com.globant.web.tests;

import com.globant.web.pages.CartPage;
import com.globant.web.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RemoveElementsFromCartTest extends BaseTest {

    @BeforeClass
    public void setUp(){
        super.setUp();
        login("standard_user", "secret_sauce");
    }

    @Test
    public void removeItemFromCart(){
        int quantity = 3;
        HomePage homePage = getHomePage();
        selectProducts(homePage,quantity);
        homePage.goToShoppingCart();
        CartPage cartPage = getCartPage();
        removeAllItemsInCart(cartPage, quantity);
        Assert.assertTrue(cartPage.isCartEmpty(), "The cart was not empty");
    }

    private void removeAllItemsInCart(CartPage cartPage,int quantity){
        for(int i = 0; i < quantity; i++) {
            cartPage.clickOnRemove();
        }
    }
}
