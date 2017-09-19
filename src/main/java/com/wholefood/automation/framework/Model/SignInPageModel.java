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

    protected WebElement emailbox= driver.findElement(By.id("capture_signIn_traditionalSignIn_emailAddress"));
    protected  WebElement passwordbox=driver.findElement(By.id("capture_signIn_traditionalSignIn_password"));
    protected  WebElement signInButton=driver.findElement(By.xpath(".//*[@id='capture_signin_link']"));
   // private  String actualTitle=getDriver().getTitle();

}
