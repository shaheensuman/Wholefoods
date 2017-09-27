package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.HomePageModel;
import com.wholefood.automation.framework.utils.VerifyConnection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;

/**
 * Created by jahangir shaheen on 8/13/2017.
 */
public class HomePageController extends HomePageModel {
    public HomePageController(WebDriver driver){
        super(driver);
    }

    public void verifyHomepage(){
        System.out.println("Homepage Url : "+driver.getCurrentUrl());
        String expectecTitle="Whole Foods Market | America’s Healthiest Grocery Store";
        String actualTitle=driver.getTitle().trim();
        Assert.assertEquals(actualTitle,expectecTitle);
    }
    public void goSignInPage(){
         SignInLink.click();
    }
    public void goShopOnlinePage(){
        shopOnlineLink.click();
    }
    public void goSalePage(){
        localSaleLink.click();
    }
    public void goRecipesPage(){
        RecipesPageLink.click();
    }
    public void topNavLinkConnection(){
        System.out.println(driver.getCurrentUrl());
        for (WebElement menu:topNavLink){
            String url=menu.getAttribute("href");
            String menuText=menu.getText();
            System.out.println(menuText+": "+url);
            try {
                VerifyConnection.varifyUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*    driver.navigate().to(url);
            System.out.println(driver.getCurrentUrl());
                String title=driver.getTitle();
              //  System.out.println(title);
            System.out.println(driver.getCurrentUrl());
                WebElementUtils.delayFor(2000);
                driver.navigate().back();

            System.out.println(driver.getCurrentUrl());

                WebElementUtils.delayFor(5000);
            System.out.println(driver.getCurrentUrl());

            */

        }
    }
    public void shoppingLinkConnection(){
        System.out.println(driver.getCurrentUrl());
        for (WebElement menu:shopMenuLink){
            String url=menu.getAttribute("href");
            String menuText=menu.getText();
            System.out.println(menuText+": "+url);
            try {
                VerifyConnection.varifyUrl(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*    driver.navigate().to(url);
            System.out.println(driver.getCurrentUrl());
                String title=driver.getTitle();
              //  System.out.println(title);
            System.out.println(driver.getCurrentUrl());
                WebElementUtils.delayFor(2000);
                driver.navigate().back();

            System.out.println(driver.getCurrentUrl());

                WebElementUtils.delayFor(5000);
            System.out.println(driver.getCurrentUrl());

            */

        }
    }
    public void shoppingLink(){
        HashMap<String,String> shoppingMenu=new HashMap<String, String>();

        for (WebElement menu:shopMenuLink){
            String url=menu.getAttribute("href");
            shoppingMenu.put(menu.getText(),url);
            // System.out.println(url);
        }
        Set<Map.Entry<String, String>> entrySet = shoppingMenu.entrySet();

        for (Map.Entry<String, String> entry : entrySet)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        //another way to go through each key and value
       /* Set<String>keySet=shoppingMenu.keySet();

        for (String key:keySet){
            System.out.println(key);
          //  System.out.println(key.length());
            System.out.println(shoppingMenu.get(key));
        }*/

    }
    public void findNavMenu(){
       for (WebElement navMenu:navMenuList){
          String navMenuText=navMenu.getText();
           System.out.println("menu: "+navMenuText);
       }
    }
    public void assertNavMenu(){
        //findNavMenu();
        String[] expectedMenuList={"Coupons","Local Sales","Recipes", "Shop Online","Customer Service"};

        String[]actualMenuList=new String[navMenuList.size()];
        int count=0;
        for(WebElement menu:navMenuList){
            String menuText=menu.getText();
            actualMenuList[count]=menuText;
            count++;
            System.out.println(menuText);
        }
        Assert.assertEquals(actualMenuList,expectedMenuList);
    }
    public void VerifyShoppingMenu(){
        String []expectedMenuList={"Find a Store", "Coupons", "Sales Flyers", "Catering & Online Ordering",
                "Gift Cards", "Store Departments", "Store Events"};
        HashSet<String> menuList=new HashSet<String>();
        int count=0;
        String[]actualMenu=new String[shoppingMenuList.size()];
        for (WebElement menu:shoppingMenuList){
            String menuText=menu.getText();

           // menuList.add(menuText);
            actualMenu[count]=menuText;
           // System.out.println(menuText);
           // System.out.println(actualMenu[count]);
           count++;
        }

        System.out.println("Actual menu: "+Arrays.toString(actualMenu));
        Assert.assertEquals(actualMenu,expectedMenuList);
        //actual always come first then expected

    }
    public void findingShoppingMenu(int index){
        HashSet<String> menuList=new HashSet<String>();
        String[]actualMenuList=menuList.toArray(new String[shoppingMenuList.size()]);
        String []expectedMenuList={"Find a Store", "Coupons", "Sales Flyers", "Catering & Online Ordering",
                "Gift Cards", "Store Departments", "Store Events"};
        System.out.println("Actual menu are ");
        System.out.println();
        int count=0;
        for (WebElement list:shoppingMenuList){
            actualMenuList[count]=list.getText();
            System.out.print(actualMenuList[count]+("\t"));
            count++;
        }
        System.out.println();
        System.out.println("Menu of index "+(index)+" is "+actualMenuList[index]);
        Assert.assertEquals(actualMenuList,expectedMenuList);


    }
    public void assertShoppingMenu(int index,String menu){
        HashSet<String> menuList=new HashSet<String>();

        String[]actualMenuList=menuList.toArray(new String[shoppingMenuList.size()]);
        String expectedMenu=new String(menu);

        System.out.println("Actual menu are ");
        System.out.println();
        int count=0;
        for (WebElement list:shoppingMenuList){
            actualMenuList[count]=list.getText();
            System.out.print(actualMenuList[count]+("\t"));
            count++;
        }
        System.out.println();
        if(index<shoppingMenuList.size()){
            System.out.println("Menu of index "+(index)+" is "+actualMenuList[index]);
            String actualMenu=actualMenuList[index].trim();
            Assert.assertEquals(actualMenu,expectedMenu.trim());
        }else
        {
            System.out.println("Index is out of boundary");
        }


    }
    public void image(){

        System.out.println(image.size());
    }
}
