package com.wholefood.automation.framework.JunitBased;

import com.wholefood.automation.framework.controller.HomePageController;
import com.wholefood.automation.framework.controller.OnSalePageController;
import com.wholefood.automation.framework.controller.ShopOnlineController;
import com.wholefood.automation.framework.controller.SignInPageController;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


/**
 * Created by jahangir shaheen on 8/19/2017.
 */
public class WholeFoodJUnitScriptBase extends JUnitScriptBase {
    public HomePageController homePage;
    public SignInPageController signInPage;
    public ShopOnlineController shopOnline;
    public OnSalePageController onSalePage;
    public WholeFoodJUnitScriptBase(){}
    public WholeFoodJUnitScriptBase(WebDriver driver){
        super(driver);
    }

    @Override
    @Before


    public void setUp(){
        super.setUp();
        getDriver().navigate().to("https://www.wholefoodsmarket.com/");


    }
    public HomePageController homePage(){
        if (homePage==null){
            homePage= new HomePageController(getDriver());
        }
        return homePage;
    }
    public SignInPageController signInPage(){
        if(signInPage==null){
            signInPage=new SignInPageController(getDriver());
        }return signInPage;
    }
    public ShopOnlineController shopOnline(){
        if(shopOnline==null){
            shopOnline=new ShopOnlineController(getDriver());
        }return shopOnline;
    }
    public OnSalePageController onsalePage(){
        if (onSalePage==null){
            onSalePage=new OnSalePageController(getDriver());
            // PageFactory.initElements(getDriver(),OnSalePageController.class);
        }return onSalePage;
        // PageFactory.initElements(getDriver(),OnSalePageController.class);
    }
}
