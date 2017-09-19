package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jahangir shaheen on 8/17/2017.
 */
public class ShoppingPageModel extends PageBase {

    public ShoppingPageModel(WebDriver driver) {
        super(driver);

    }

   public WebElement shopNowButton=driver.findElement(By.xpath(".//a[@class='orange-button-cta'][text()='Shop Now']"));

}
