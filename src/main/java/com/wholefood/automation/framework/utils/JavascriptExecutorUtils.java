package com.wholefood.automation.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by PaxoStudent on 3/31/2017.
 */
public class JavascriptExecutorUtils {

    private WebDriver driver = null;

    public JavascriptExecutorUtils(WebDriver driver){
        this.driver = driver;
    }


    public void jsClickWebElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",  element);
    }

    public void jsHighlightWebElement(WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 3px solid blue;");
            delayFor(1000);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(1000);
        }
    }

    public void jsSetAttribute(WebElement element, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element, attributeName, attributeValue);
    }

    public void jsScrollElementIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  element);

    }


    private static void delayFor(int timeinMili) {
        try {
            Thread.sleep(timeinMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
