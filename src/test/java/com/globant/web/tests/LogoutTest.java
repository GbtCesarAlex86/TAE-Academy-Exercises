package com.globant.web.tests;

import com.globant.web.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @BeforeClass
    public void setUp(){
        super.setUp();
        login("standard_user", "secret_sauce");
    }

    @Test
    public void logOut(){
        HomePage homePage = getHomePage();
        homePage.clickOnMenuBtn();
        homePage.clickOnLogOut();
        Assert.assertTrue(homePage.isOnHomepage(), "Not in login page");
    }

}
