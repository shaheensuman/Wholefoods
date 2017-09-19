package com.wholefood.automation.framework.JunitBased;
import com.wholefood.automation.framework.WholeFoodScriptBase;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */
public class ScriptBase {
    public WebDriver driver;

    public ScriptBase(WebDriver driver) {
        this.driver = driver;
    }


    public static void beforeClass() {
        System.out.println("*****************************before class**************************");


    }
    private WholeFoodScriptBase wholeFood;

    @BeforeMethod
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*FirefoxDriverManager.getInstance().setup();
        driver=new FirefoxDriver();
      driver.manage().window().maximize();*/
    }

    @AfterMethod
    public void tearDown() {
        wholeFood =null;
         if (driver!=null){
            driver.close();
            driver.quit();
         }

    }

        @AfterClass

        public static void afterClass()
        {
            System.out.println("********************************After Class*************************");
        }
    }
