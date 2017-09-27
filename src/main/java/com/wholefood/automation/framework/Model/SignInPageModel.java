package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jahangir shaheen on 8/13/2017.
 */
public class SignInPageModel  extends PageBase {

    public SignInPageModel(WebDriver driver) {
        super(driver);
    }

    protected WebElement emailbox= driver.findElement(By.id("email-address"));
    protected  WebElement passwordbox=driver.findElement(By.id("login_password"));
    protected  WebElement signInButton=driver.findElement(By.xpath(".//*[@id='login-form']/div[4]/input"));
   // private  String actualTitle=getDriver().getTitle();

}
