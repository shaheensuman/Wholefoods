package com.wholefood.automation.framework;

import com.wholefood.automation.framework.Reports.ExtentTestNGITestListener;
import com.wholefood.automation.framework.controller.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */

@Listeners({ExtentTestNGITestListener.class})

public class WholeFoodScriptBase   {

    public WebDriver driver = null;
    ApplicationController wholeFood = null;

    public static final String USERNAME = "jahangirshaheen1";
    public static final String AUTOMATE_KEY = "Fa4hfLwzmSwVG9L4h2Qp";
    public static final String REMOTE_HUB = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Parameters("browser")

    @BeforeMethod
    public void setUp(String browser) throws MalformedURLException {

   /*    if (browser.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();


      /*  } else if (browser.equalsIgnoreCase("firefox")) {
            String DriverPath = System.getProperty("user.dir");
            String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFpath);
            driver = new FirefoxDriver();

      /*  } else if (browser.equalsIgnoreCase("ie")) {
            String DriverPath = System.getProperty("user.dir");
            String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFpath);
            driver = new FirefoxDriver();
        }

            /*    InternetExplorerDriverManager.getInstance().setup();
                  driver=new InternetExplorerDriver();    */


        System.out.println("*************before  test method*************");


        if (browser.equalsIgnoreCase("ff-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Firefox");
            caps.setCapability("browser_version", "56.0 beta");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1280x1024");
            driver = new RemoteWebDriver(new URL(REMOTE_HUB), caps);
        }else if(browser.equalsIgnoreCase("ch-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "59.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "7");
            caps.setCapability("resolution", "1280x1024");
            driver=new RemoteWebDriver(new URL(REMOTE_HUB),caps);
        }else if (browser.equalsIgnoreCase("ie-cloud")){
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "IE");
            caps.setCapability("browser_version", "11.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1280x1024");
            driver= new RemoteWebDriver(new URL(REMOTE_HUB), caps);
        }
        if (browser.equalsIgnoreCase("chrome")){
            ChromeDriverManager.getInstance().setup();
            driver=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("FireFox")){
            // FirefoxDriverManager.getInstance().setup();
            String DriverPath = System.getProperty("user.dir");
            String FFpath = DriverPath + "\\Drivers\\FF\\32bits\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", FFpath);
            driver = new FirefoxDriver();

        }


        try {
            driver.navigate().to("https://www.wholefoodsmarket.com/");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

            try {
                driver.quit();
            }catch (Exception ex){
                ex.printStackTrace();
            }

            wholeFood=null;
        }

    }
}
