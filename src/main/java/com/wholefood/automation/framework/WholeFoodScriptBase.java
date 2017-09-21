package com.wholefood.automation.framework;

import com.wholefood.automation.framework.Reports.ExtentTestNGITestListener;
import com.wholefood.automation.framework.controller.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */

@Listeners({ExtentTestNGITestListener.class})

public class WholeFoodScriptBase   {
  public WebDriver driver=null;
  ApplicationController wholeFood=null;
    @BeforeMethod
    public void setUp() {


                /*  ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                    */

            /*    InternetExplorerDriverManager.getInstance().setup();
                  driver=new InternetExplorerDriver();    */

        String DriverPath=System.getProperty("user.dir");
        String FFpath=DriverPath+"\\Drivers\\FF\\32bits\\geckodriver.exe";
        System.out.println(DriverPath);
        System.out.println(FFpath);

        System.setProperty("webdriver.gecko.driver",FFpath);
        driver=new FirefoxDriver();

       /* System.setProperty("webdriver.chrome.driver","C:\\MyDevelopment\\Macys-POM\\Drivers\\CH\\32Bits\\chromedriver.exe");
        driver=new ChromeDriver();    */

       /*  System.setProperty("webdriver.ie.driver","C:\\MyDevelopment\\DevTools\\Webdrivers\\IE\\32bits\\IEDriverServer.exe");
         driver=new InternetExplorerDriver() ; */


       // driver.manage().window().maximize();
        driver.navigate().to("https://www.wholefoodsmarket.com/");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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
          //  driver.close();
            driver.quit();
        }

    }
}
