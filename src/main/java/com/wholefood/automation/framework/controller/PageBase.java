package com.wholefood.automation.framework.controller;

import org.openqa.selenium.WebDriver;

/**
 * Created by jahangir shaheen on 8/19/2017.
 */
public class PageBase {
    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
