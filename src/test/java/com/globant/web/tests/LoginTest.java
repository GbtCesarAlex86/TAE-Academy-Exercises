package com.globant.web.tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void LogInTest(){
        login("standard_user", "secret_sauce");
    }
}