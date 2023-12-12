package com.globant.web.tests;

import com.globant.web.pages.CartPage;
import com.globant.web.pages.CheckoutPage;
import com.globant.web.pages.HomePage;
import com.globant.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseTest {

    private WebDriver driver;

    protected void login(String username, String password) {
        LoginPage loginPage = getLoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLogIn();
    }

    @BeforeSuite
    public void setUp(){
        this.driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver, "https://www.saucedemo.com/");
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public CartPage getCartPage(){
        return new CartPage(driver);
    }

    public CheckoutPage getCheckOutPage(){
        return new CheckoutPage(driver);
    }

    private List<Integer> getRandomLisOfNumbers(int quantity){
        List<Integer> randomIndexList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantity; i++){
            int randomIndex;
            do{
                randomIndex = random.nextInt(quantity);
            } while(randomIndexList.contains(randomIndex));
            randomIndexList.add(randomIndex);
        }
        return randomIndexList;
    }

    protected void selectProducts(HomePage homePage, int quantity){
        List<WebElement> products = homePage.getProducts();
        List<Integer> randomIndexs = getRandomLisOfNumbers(quantity);
        for (int index : randomIndexs) {
            WebElement product = products.get(index);
            homePage.clickOnProduct(product);
        }
    }
}