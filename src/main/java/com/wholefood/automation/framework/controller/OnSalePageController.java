package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.SalePageModel;
import com.wholefood.automation.framework.utils.JavascriptExecutorUtils;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


/**
 * Created by jahangir shaheen on 8/18/2017.
 */
public class OnSalePageController extends SalePageModel {

    public OnSalePageController(WebDriver driver) {
        super(driver);
    }

    public void verifySalePage(){

        System.out.println("page url is : "+driver.getCurrentUrl());
        String expectedTitle="Sales and Coupons | Whole Foods Market ".trim();
        String actualTitle=driver.getTitle();
        System.out.println( "page title is ; "+actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void verifyStates(){

        Select stateNames=new Select(stateBox);
        List<WebElement>states=stateNames.getOptions();
        String []actualStates=new String[states.size()];
        int count=0;
        for(WebElement state :states){
            //System.out.println(state.getText());
            actualStates[count]=state.getText();
            count++;

        }
        System.out.println(" Number of states listed : "+count);
        String [] expectedStates={"Please Select Your Location", "British Columbia" ,"Ontario",
                                "United Kingdom","Alabama", "Arizona","Arkansas", "California",
                                "Colorado","Connecticut","District Of Columbia","Florida",
                                "Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa",
                                "Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts",
                                "Michigan","Minnesota","Mississippi","Missouri","Nebraska",
                                "Nevada","New Hampshire","New Jersey","New Mexico","New York",
                                "North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania",
                                "Rhode Island","South Carolina","Tennessee","Texas","Utah",
                                "Virginia","Washington","Wisconsin"};
        Assert.assertEquals(actualStates,expectedStates);
    }

    public void verifyStoreLocation(String stateName){
        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        String[]expectedStoreLocation={"Please Select a Store","Ann Arbor - 3135 Washtenaw Ave",
                                     "Cranbrook - 990 W. Eisenhower Parkway",
                                     "Detroit - 115 Mack Ave.","East Lansing - 2750 E. Grand River Ave.",
                                     "Rochester Hills - 2918 Walton Blvd",
                                      "Troy - 2880 West Maple Rd",
                                      "West Bloomfield - 7350 Orchard Lake Road"};

        Select storesName=new Select(storeBox);
        List<WebElement>storesList=storesName.getOptions();
        String [] actualStoreLocation=new String[storesList.size()];
        int count=0;
        for(WebElement store:storesList){
            actualStoreLocation[count]=store.getText();
            count++;
        }
        System.out.println("Number of stores in "+stateName+ " is: "+count);
        Assert.assertEquals(actualStoreLocation,expectedStoreLocation);
    }


    public void selectStore(String stateName,int index) {
        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

         Select stores=new Select(storeBox);
         stores.selectByIndex(index);
         WebElementUtils.delayFor(2000);

         couponButton.click();
         WebElementUtils.delayFor(2000);

         WebElement storeMsg= driver.findElement(By.xpath(".//div[@class='store-box']/a[1]"));
         String storeName=storeMsg.getText();
         boolean isDisplay=storeMsg.isDisplayed();
         System.out.println(isDisplay);

        System.out.println( "State name: "+stateName+", store name: "+storeName);
         //welcomeMgs.contains(storeList.get(index).getText());
         String expectedStoreName="Jericho";
        Assert.assertEquals(storeName,expectedStoreName);
        Assert.assertTrue(isDisplay);
    }

    public void selectStoret2(String stateName,int index,String expStoreName) {

        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        Select stores=new Select(storeBox);
        stores.selectByIndex(index);
        WebElementUtils.delayFor(2000);

        couponButton.click();
        WebElementUtils.delayFor(2000);

        WebElement storeMsg= driver.findElement(By.xpath(".//div[@class='store-box']/a[1]"));
        String storeName=storeMsg.getText();
        boolean isDisplay=storeMsg.isDisplayed();
        System.out.println(isDisplay);

        System.out.println( "State name: "+stateName+", store name: "+storeName);

        Assert.assertEquals(storeName,expStoreName);
        Assert.assertTrue(isDisplay);
    }


    public void subMenuAfterClick(String stateName,int index){
        int expMenuSize=1;
        List<WebElement>subMunuList=driver.findElements(By.xpath(".//div[@class='breadcrumb']//a"));
        System.out.println("No of menus before selection is: "+subMunuList.size());
        int actualmenuSize=subMunuList.size();
        for(WebElement subMunu:subMunuList){
            System.out.println( "menu: "+subMunu.getText()+" Link: "+subMunu.getAttribute("href"));
            System.out.println();
        }
        Assert.assertEquals(actualmenuSize,expMenuSize);

        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        Select stores=new Select(storeBox);
        stores.selectByIndex(index);
        WebElementUtils.delayFor(2000);

        couponButton.click();
        WebElementUtils.delayFor(2000);

        List<WebElement>munuLists=driver.findElements(By.xpath(".//div[@class='breadcrumb']//a"));
        System.out.println("No of menus after selection is: "+munuLists.size());
        int expectedSize=2;
        int actualSize=munuLists.size();
        for(WebElement munu:munuLists){
            System.out.println("menu: "+munu.getText()+" Link: "+munu.getAttribute("href"));
        }

         boolean sizeMatch=munuLists.get(1).getText().trim().contains("Tenaya");
        Assert.assertEquals(actualSize,expectedSize);


        System.out.println(sizeMatch);
    }

    public void cupponButonBeforeSelect(){
        couponButton.click();
        boolean isEnable=couponButton.isEnabled();
        System.out.println("Is cuppon button enabale: "+isEnable);
    }

    public void cupponButonSelectStateOnly(String stateName){
        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);
        couponButton.click();
        boolean isEnable=couponButton.isEnabled();
        System.out.println("Is cuppon button enabale: "+isEnable);
    }
    public void cupponButonAfterselect(String stateName,int index){
        JavascriptExecutorUtils java=new JavascriptExecutorUtils(driver);
        java.jsHighlightWebElement(stateBox);
        WebElementUtils.delayFor(1000);

        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        Select stores=new Select(storeBox);
        stores.selectByIndex(index);
        WebElementUtils.delayFor(2000);

        boolean isEnable=couponButton.isEnabled();
        couponButton.click();

        System.out.println("Is cuppon button enabale: "+isEnable);

    }
    public void saleAndCoupon(String stateName,int index){
        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        Select stores=new Select(storeBox);
        stores.selectByIndex(index);
        WebElementUtils.delayFor(2000);

        boolean isEnable=couponButton.isEnabled();
        System.out.println( "Is cuppon is enable: "+isEnable);
        couponButton.click();

        String Title=driver.getTitle();
        System.out.println(Title);


    }
    public void navigateStores(String stateName,int index){
        Select state=new Select(stateBox);
        state.selectByVisibleText(stateName);
        WebElementUtils.delayFor(2000);

        Select stores=new Select(storeBox);
        stores.selectByIndex(index);
        WebElementUtils.delayFor(2000);
        couponButton.click();
    }
}
