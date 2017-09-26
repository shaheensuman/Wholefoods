package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */
public class HomePageModel extends PageBase {

    protected HomePageModel(WebDriver driver){
        super(driver);
    }

    protected WebElement SignInLink=driver.findElement(By.xpath(".//*[@id='capture_signin_link']"));
    protected WebElement shopOnlineLink=driver.findElement(By.xpath(".//*[@id='block-menu-menu-brand-camp-top']/div/ul/li[4]/a"));
    protected WebElement onSaleLink=driver.findElement(By.xpath(".//*[@id='block-menu-menu-brand-camp-top']/div/ul/li[2]/a"));
    protected WebElement RecipesPageLink=driver.findElement(By.xpath(".//*[@id='block-menu-menu-brand-camp-top']/div/ul/li[3]/a"));
    protected List<WebElement> navMenuList=driver.findElements(By.xpath(".//*[@id='block-menu-menu-brand-camp-top']/div/ul/li"));
    protected List<WebElement>image=driver.findElements(By.tagName("img"));
    protected List<WebElement>shoppingMenuList=driver.findElements(By.xpath("//div[@class='footer-new-container']/div[1]/ul/li[1]/ul/li"));
    //anchor tag //a is specially for finding html links
    protected List<WebElement>shopMenuLink=driver.findElements(By.xpath("//div[@class='footer-new-container']/div[1]/ul/li[1]/ul//a"));
    protected List<WebElement> topNavLink=driver.findElements(By.xpath(".//div[@class='block-inner clearfix']/ul//a"));

}
