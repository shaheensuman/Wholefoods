package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.RecipesPageModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by jahangir shaheen on 8/27/2017.
 */
public class RecipesPageController extends RecipesPageModel {
    public RecipesPageController(WebDriver driver) {
        super(driver);
    }

    public void verifyRecipesPage(){
        System.out.println("page url : "+driver.getCurrentUrl());
        String actualtitle=driver.getTitle();
        System.out.println("page title : "+actualtitle);
        String expectedTitle="Recipes | Whole Foods Market";
        Assert.assertEquals(actualtitle,expectedTitle);

    }
}
