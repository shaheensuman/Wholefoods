package com.wholefood.automation.framework.CreatScriptBase;

import com.wholefood.automation.framework.controller.ApplicationController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by jahangir shaheen on 9/23/2017.
 */
public class FireFoxTestNgScriptBase {
    public WebDriver driver = null;
    ApplicationController wholeFood = null;

    // @Parameters("browser")

    @BeforeMethod
    public void setUp() {

        String DriverPath = System.getProperty("user.dir");
        String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", FFpath);
        driver = new FirefoxDriver();

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
            driver.close();
            // driver.quit();
            wholeFood=null;
        }
    }
}
