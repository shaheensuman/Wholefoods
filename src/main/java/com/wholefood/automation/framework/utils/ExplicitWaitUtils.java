package com.wholefood.automation.framework.utils;


import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Iftekhar Ivaan on 3/9/2017.
 */
public class ExplicitWaitUtils {
    private WebDriver driver = null;
    private static final int DEFAULT_WAIT_TIME = 5000;

    public ExplicitWaitUtils(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElement(final By locator) {
        return waitForElement(locator,5000);
    }

    public WebElement waitForElement(final By locator, int timeToWaitInSec) {
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME,TimeUnit.MILLISECONDS);
        new JavascriptExecutorUtils(driver).jsHighlightWebElement(foo);
        return foo;
    }

    public WebElement waitForElementDisplayed(final By locator) {
        return waitForElementDisplayed(locator,5000);
    }

    public WebElement waitForElementDisplayed(final By locator, int timeToWaitInSec) {

        driver.manage().timeouts().implicitlyWait(100,TimeUnit.MILLISECONDS);

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeToWaitInSec, TimeUnit.SECONDS)
                .pollingEvery(100, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement element = driver.findElement(locator);
                if (element != null && element.isDisplayed()) {
                    //highlight(element);
                    return element;
                }
                return null;
            }
        });

        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME,TimeUnit.MILLISECONDS);
        new JavascriptExecutorUtils(driver).jsHighlightWebElement(foo);
        return foo;
    }

    public FluentWait<WebDriver> fluentWait() {
        return fluentWait(DEFAULT_WAIT_TIME,TimeUnit.MILLISECONDS);
    }

    public FluentWait<WebDriver> fluentWait(int duration, TimeUnit timeUnit) {
        return new FluentWait<WebDriver>(driver)       //<3>
                .withTimeout(duration, timeUnit)
                .pollingEvery(50, TimeUnit.MILLISECONDS)
                .ignoreAll(new ArrayList<Class<? extends Throwable>>() {
                    {
                        add(StaleElementReferenceException.class);
                        add(NoSuchElementException.class);
                    }
                }).withMessage("Selenium TimeoutException");
    }

    /*
    public void waitForAjaxToComplete() {
         Wait<WebDriver> wait = fluentWait();
         wait.until(jQuryHasFinishedProcessing());
     }
    */

    //waitForAjax(driver, "Ajax_call");
    public  void waitForAjax(WebDriver driver, String action) {
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        ((JavascriptExecutor) driver).executeAsyncScript(
                "var callback = arguments[arguments.length - 1];" +
                        "var xhr = new XMLHttpRequest();" +
                        "xhr.open('POST', '/" + action + "', true);" +
                        "xhr.onreadystatechange = function() {" +
                        "  if (xhr.readyState == 4) {" +
                        "    callback(xhr.responseText);" +
                        "  }" +
                        "};" +
                        "xhr.send();");
    }


    public void waitForAjax() throws InterruptedException
    {
        while (true)
        {
            if ((Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0")){
                break;
            }
            Thread.sleep(100);
        }
    }


    public void waitForVisibilityOfElement(WebElement element){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForVisibilityOfElement(By locator){
        WebElement element = driver.findElement(locator);
        waitForVisibilityOfElement(element);
    }

    public void waitForPageTitle(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForPageTitleContains(String title){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForInvisibilityOfElement(By locator){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementAttributeContains(WebElement element, String attributeName, String attributeValue){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.attributeContains(element,attributeName,attributeValue));
    }
    public void waitForElementAttributeContains(By locator, String attributeName, String attributeValue){
        WebElement element = driver.findElement(locator);
        waitForElementAttributeContains(element,attributeName,attributeValue);
    }

    public void waitForElementTextToBe(By locator, String text){
        FluentWait<WebDriver> wait = fluentWait();
        wait.until(ExpectedConditions.textToBe(locator,text));
    }

}
