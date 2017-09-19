package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by jahangir shaheen on 8/18/2017.
 */
public class SalePageModel extends PageBase {

  /*  @FindBy(how=How.ID,using = "edit-state")
   protected WebElement stateLocationBox;
    @FindBy(how = How.XPATH,using = ".//*[@id='edit-store']")
   protected WebElement storeLocationBox;
    @FindBy(how = How.CSS,using = "#store-select-submit")
   protected WebElement cuponButton;
   // @FindBy(how = How.CSS,using = ".text-wrap>h2")
   */
 // protected WebElement store=getDriver().findElement(By.cssSelector("#store-select-submit"));
 // protected  WebElement cupponLinks=getDriver().findElement(By.cssSelector("#quicktabs-tab-custom_quicktab_sales_coupons-1"));
 // protected  WebElement findStoreLink=getDriver().findElement(By.xpath(".//*[@id='block-wfm-blocks-wfm-blocks-footer']/div/div/div[1]/ul/li[1]/ul/li[1]/a"));
  @FindBy(how = How.XPATH,using = ".//*[@id='block-wfm-blocks-wfm-blocks-footer']/div/div/div[1]/ul/li[1]/ul/li[1]/a")
   protected WebElement findStoreLink;
   protected WebElement stateBox=driver.findElement(By.xpath(".//*[@id='edit-state']"));
   protected WebElement storeBox=driver.findElement(By.xpath(".//*[@id='edit-store']"));
   protected WebElement couponButton=driver.findElement(By.xpath(".//*[@id='store-select-submit']"));
   //protected List<WebElement>storeLists=driver.findElements(By.xpath(".//*[@id='edit-store']"));
   public SalePageModel(WebDriver driver) {
        super(driver);
       // PageFactory.initElements(getDriver(),this);
    }
}
