package com.wholefood.automation.framework.CreatScriptBase;

import com.wholefood.automation.framework.controller.ApplicationController;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by jahangir shaheen on 9/22/2017.
 */
public class ChromeTestNgScriptBase {
    public WebDriver driver = null;
    ApplicationController wholeFood = null;


    @BeforeMethod
    public void setUp() {

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();

        System.out.println("*************before  test method*************");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        try {
            driver.navigate().to("https://www.wholefoodsmarket.com/");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
    public ApplicationController wholeFood() {
        if (wholeFood == null) {
            wholeFood = new ApplicationController(driver);
        }
        return wholeFood;
    }



    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.close();//close the window the driver is focasing on.ie latest window.
            driver.quit();//close all windows
            //instance of all pages must be delete in testng.
            wholeFood=null;// to delete all instance after @test method.
        }
    }


}
