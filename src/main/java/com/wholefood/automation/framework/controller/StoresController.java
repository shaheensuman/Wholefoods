package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.StoresPageModel;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jahangir shaheen on 9/16/2017.
 */
public class StoresController extends StoresPageModel {
    public StoresController(WebDriver driver) {
        super(driver);
    }

    public void verifySrores() {
        String Title = driver.getTitle();
        String Url = driver.getCurrentUrl();
        System.out.println("page title: " + Title);
        System.out.println("store Url: " + Url);
        boolean isTitle = Title.contains("Coupon");
        boolean isUrl = Url.endsWith("thirdand3rd");
        Assert.assertTrue(isTitle);
        Assert.assertTrue(isUrl);

    }

    public void verifySubMenu() {
        String[] expectedMenu = {"SALES", "COUPONS"};
        int count = 0;
        String[] actualMenu = new String[menuList.size()];

        for (WebElement munu : menuList) {
            System.out.println(munu.getText());
            actualMenu[count] = munu.getText();
            count++;
        }
        Assert.assertEquals(actualMenu, expectedMenu);
    }

    public void goForCoupon() {
        WebElementUtils.delayFor(2000);
        couponButton.click();
    }

    public void veryfyCupponlist() {
        couponButton.click();
        WebElementUtils.delayFor(2000);
        System.out.println("Total product for coupon printing: " + couponProductList.size());
        for (WebElement coupon : couponProductList) {
            String productDescript = coupon.getText();
            System.out.println(productDescript);
        }
    }

    public void selectAllCkBox() {
        couponButton.click();
        WebElementUtils.delayFor(2000);
        boolean ckBoxStatus;
        ckBoxStatus = selectAllCoupon.isSelected();

        if (ckBoxStatus == false) {
            selectAllCoupon.click();
        }
        WebElementUtils.delayFor(2000);
        List<WebElement> couponList = driver.findElements(By.xpath(".//input[contains(@id,'edit-print-select')]"));

        for (WebElement coupon : couponList) {
            boolean status = coupon.isSelected();
            if (status == false) {
                System.out.println(coupon.getAttribute("name") + " is not selected");
            }
        }
    }

    public void verifySalePrice() {
        couponButton.click();
        String[] productList = new String[couponProductList.size()];
        String[] offPriceItems = new String[offPriceList.size()];
        int count = 0;
       /* for (WebElement product:couponProductList ){
            productList[count]=product.getText();
           // System.out.println(product.getText());
           count++;
        }
        System.out.println(offPriceItems.length);
        */
        int size = 0;
        for (WebElement item : offPriceList) {
            offPriceItems[size] = item.getText();
            //System.out.println(item.getText());
            size++;
        }

        System.out.println(offPriceItems.length);
        for (int i = 0; i < 32; i++) {
            System.out.println(offPriceItems[i]);

        }
    }

    public void verifySalePriceTwo(String product ,String offPrice) {
        couponButton.click();
        HashMap<String, String> priceMap = new HashMap<>();

        for (int i = 0; i < 32; i++) {
            priceMap.put(couponProductList.get(i).getText(), offPriceList.get(i).getText());
        }
      /*
        Set<String>myset=myMap.keySet();
        for (String set:myset){
            System.out.println(set);
        } */
        Set<Map.Entry<String, String>> keyAndValueSet = priceMap.entrySet();

        for (Map.Entry<String, String> entry : keyAndValueSet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        String actual_off_Price=priceMap.get(product).trim();

        Assert.assertEquals(actual_off_Price,offPrice.trim());
    }

    public void VerifySalePriceThree() {
        couponButton.click();
        String[] productList = new String[couponProductList.size()];

        int count = 0;
        for (WebElement product : couponProductList) {
            productList[count] = product.getText();
            System.out.println(product.getText());
            count++;
        }
    String[] salePriceList = new String[offPriceList.size()];
        for (WebElement item : offPriceList) {
            salePriceList[count] = item.getText();
            System.out.println(item.getText());
            count++;
        }


     /*   for (int i=0;i<5;i++) {
            productList[i] = couponProductList.get(i).getText();
           // System.out.println(productList[i]);
        }

        for (int i=0;i<5;i++) {
            salePriceList[i] = offPriceList.get(i).getText();
           // System.out.println(salePriceList[i]);

        }
        for(int i=0;i<5;i++){
            System.out.println(productList[i]+" : "+salePriceList[i]);
        }   */
    }
}
