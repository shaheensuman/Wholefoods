package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by jahangir shaheen on 9/15/2017.
 */
public class StoresPageModel extends PageBase {
    public StoresPageModel(WebDriver driver) {
        super(driver);
    }
    protected List<WebElement> menuList=driver.findElements(By.xpath(".//*[@id='quicktabs-custom_quicktab_sales_coupons']/div[1]//li"));
    protected WebElement couponButton=driver.findElement(By.xpath(".//*[@id='quicktabs-custom_quicktab_sales_coupons']/div[1]//li[2]"));
   protected List<WebElement>couponList=driver.findElements(By.xpath(".//input[contains(@id,'edit-print-select')]"));
   //List<WebElement>couponList=driver.findElements(By.xpath(".//input[contains(@id,'edit-print-select')]"));
    protected  WebElement selectAllCoupon=driver.findElement(By.xpath(".//input[@id='edit-select-all-coupons']"));
    protected  WebElement firstCoupon=driver.findElement(By.xpath(".//*[@id='edit-print-select-0']"));
    protected  WebElement seventhtCoupon=driver.findElement(By.xpath(".//*[@id='edit-print-select-7']"));
    protected List<WebElement> couponProductList=driver.findElements(By.xpath(".//*[@id='wfm-coupons-print-form']/div/div/div/div/span[2]"));
    protected List<WebElement> imageList=driver.findElements(By.xpath(".//*[@id='wfm-coupons-print-form']/div/div/div/div/div[2]//img"));
    protected List<WebElement> offPriceList=driver.findElements(By.xpath(".//*[@id='wfm-coupons-print-form']/div/div/div/div/span[1]/span"));
}
