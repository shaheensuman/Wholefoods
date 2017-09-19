package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.SignInPageModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by jahangir shaheen on 8/15/2017.
 */
public class SignInPageController extends SignInPageModel {

    public SignInPageController(WebDriver driver) {
        super(driver);
    }

    public void verifySignInpage(){
        String actualTitle=driver.getTitle();
        System.out.println("Page Title : "+actualTitle);
        System.out.println("Page Url : "+driver.getCurrentUrl());
        String expectedTitle="Sign In / Register | Whole Foods Market";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void goForSignIn(String email,String password){
        emailbox.sendKeys(email);
        passwordbox.sendKeys(password);
        signInButton.click();
    }

}
