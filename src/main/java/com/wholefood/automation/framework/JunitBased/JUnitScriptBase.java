package com.wholefood.automation.framework.JunitBased;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jahangir shaheen on 8/19/2017.
 */
public class JUnitScriptBase {
    private WebDriver driver;

    public JUnitScriptBase() {

    }

    public JUnitScriptBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    public  void beforeClass() {
            System.out.println("*****************************before class**************************");


        }

        @Before
        public void setUp() {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

        /*FirefoxDriverManager.getInstance().setup();
        driver=new FirefoxDriver();
      driver.manage().window().maximize();*/
        }

        @After
        public void tearDown() {
            if (driver!=null){
                driver.close();
                driver.quit();
            }
        }

        @AfterClass

        public  void afterClass()
        {
            System.out.println("********************************After Class*************************");
        }
    }


