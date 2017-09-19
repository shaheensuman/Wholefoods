package com.wholefood.automation.framework;

import com.wholefood.automation.framework.controller.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */


public class WholeFoodScriptBase   {
  public WebDriver driver=null;
  ApplicationController wholeFood=null;
    @BeforeMethod
    public void setUp() {

                  ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();

            /*    InternetExplorerDriverManager.getInstance().setup();
                  driver=new InternetExplorerDriver();    */

               // FirefoxDriverManager.getInstance().setup();
                 // driver=new FirefoxDriver();

         // System.setProperty("webdriver.gecko.driver","C:\\MyDevelopment\\Macys-POM\\Drivers\\FF\\32bits\\geckodriver.exe");
         // driver=new FirefoxDriver();

       /* System.setProperty("webdriver.chrome.driver","C:\\MyDevelopment\\Macys-POM\\Drivers\\CH\\32Bits\\chromedriver.exe");
        driver=new ChromeDriver();    */

       /*  System.setProperty("webdriver.ie.driver","C:\\MyDevelopment\\DevTools\\Webdrivers\\IE\\32bits\\IEDriverServer.exe");
         driver=new InternetExplorerDriver() ; */


        driver.manage().window().maximize();
        driver.navigate().to("https://www.wholefoodsmarket.com/");
        driver.manage().deleteAllCookies();

    }
    public ApplicationController wholeFood(){
        if(wholeFood==null){
            wholeFood=new ApplicationController(driver);
        }return wholeFood;
    }


    @AfterMethod
    public void tearDown() {
        wholeFood =null;
        if (driver!=null){
            driver.close();
            driver.quit();
        }

    }
}
