package com.wholefood.automation.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by PaxoStudent on 3/31/2017.
 */
public class HandleSSLCertificateError {

    private WebDriver driver = null;

    public HandleSSLCertificateError(WebDriver driver){
        this.driver = driver;
    }

    public void handleFirefoxSSLError(){

        ExplicitWaitUtils waitUtils = new ExplicitWaitUtils(driver);
        WebElementUtils elementUtils = WebElementUtils.getInstance();
        JavascriptExecutorUtils jsUtils = new JavascriptExecutorUtils(driver);

        WebElement sslError =  waitUtils.waitForElement(By.cssSelector(".title-text"),5);
        if(sslError != null) {
            WebElement advancedButton = waitUtils.waitForElement(By.id("advancedButton"));
            jsUtils.jsClickWebElement(advancedButton);

            WebElement exceptionDialogButton = waitUtils.waitForElement(By.id("exceptionDialogButton"));
            exceptionDialogButton.click();

            RobotService robot = RobotService.getInstance();
            robot.pressTabKey(4);
            robot.delayFor(2000);
            robot.pressEnterKey();
        }
    }

}
