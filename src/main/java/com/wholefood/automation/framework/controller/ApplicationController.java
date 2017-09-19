package com.wholefood.automation.framework.controller;

import org.openqa.selenium.WebDriver;

/**
 * Created by jahangir shaheen on 8/19/2017.
 */
public class ApplicationController {
    public WebDriver driver;
   public HomePageController homePage=null;
   public OnSalePageController onSalePage=null;
   public ShopOnlineController shopOnlinePage=null;
   public SignInPageController signInPage=null;
   public RecipesPageController recipesPage=null;
   public StoresController storesPage=null;

    public ApplicationController() {
    }

    public ApplicationController(WebDriver driver) {
        this.driver=driver;
    }
    public HomePageController homepage(){
        if (homePage==null){
            homePage=new HomePageController(driver);
        }return homePage;
    }
    public OnSalePageController onSalePage(){
        if(onSalePage==null){
            onSalePage=new OnSalePageController(driver);
        }return onSalePage;
    }
    public SignInPageController signInPage(){
        if(signInPage==null){
            signInPage=new SignInPageController(driver);
        }return signInPage;
    }
    public ShopOnlineController shopOnlinePage(){
        if(shopOnlinePage==null){
            shopOnlinePage=new ShopOnlineController(driver);
        }return shopOnlinePage;
    }
    public RecipesPageController recipesPage(){
        if(recipesPage==null){
            recipesPage=new RecipesPageController(driver);
        }return recipesPage;
    }
    public StoresController stores(){
        if (storesPage==null){
            storesPage=new StoresController(driver);
        }return storesPage;
    }

}
