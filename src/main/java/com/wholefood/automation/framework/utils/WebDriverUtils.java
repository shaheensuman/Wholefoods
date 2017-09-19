package com.wholefood.automation.framework.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by PaxoStudent on 3/31/2017.
 */
public class WebDriverUtils {

    private WebDriver driver;

    public WebDriverUtils(WebDriver driver){
        this.driver = driver;
    }


    public String switchWindowByTitle(String titleToMatch) {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String item : windows) {
            System.out.println(item);
            if (item.contentEquals(item)) {
                driver.switchTo().window(item);
                currentWindow = item;
                String title = driver.getTitle();
                if (title.contains(titleToMatch)) {
                    break;
                }
            }
        }
        return currentWindow;
    }

    public void closeAllOpenWindowExceptCurrent(WebDriver driver){

        String currentWindowHnd = driver.getWindowHandle();
        Set<String> winList = driver.getWindowHandles();
        for(String win : winList){
            if(!currentWindowHnd.contentEquals(win)){
                driver.switchTo().window(win);
                driver.close();
            }
        }
        driver.switchTo().window(currentWindowHnd);
    }

    public void switchWindowByURL(WebDriver driver, String url){

        String currentWindowHnd = driver.getWindowHandle();
        Set<String> winList = driver.getWindowHandles();
        for(String win : winList){
            driver.switchTo().window(win);
            String currentURL = driver.getCurrentUrl();
            if(currentURL.contentEquals(url)){
                break;
            }
        }
    }

}
