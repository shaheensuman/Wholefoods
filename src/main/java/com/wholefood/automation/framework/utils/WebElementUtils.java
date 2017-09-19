package com.wholefood.automation.framework.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import java.util.List;

/**
 * Created by Iftekhar Ivaan on 3/2/2017.
 */
public class WebElementUtils {

    private static WebElementUtils instance = null;

    private WebElementUtils(){
    }

    public static WebElementUtils getInstance(){
        if(instance == null){
            instance = new WebElementUtils();
        }
        return instance;
    }


    public void checkboxCheck(WebElement element, boolean state){
        String checkBoxState = element.getAttribute("checked");
        if((checkBoxState == null || checkBoxState.contentEquals("false")) && state == true){
            element.click();
        }
        else if((checkBoxState != null && checkBoxState.contentEquals("true")) && state == false){
            element.click();
        }

    }
    public void checkboxCheckEx(WebElement element, boolean state){
        String checkBoxState = element.getAttribute("checked");
        if((checkBoxState == null || checkBoxState.contentEquals("false")) && state){
            element.click();
        }
        else if((checkBoxState != null && checkBoxState.contentEquals("true")) && !state){
            element.click();
        }


    }

    public void checkCheckbox(WebElement element) {
        String checkBoxState = element.getAttribute("checked");
        if(checkBoxState == null || checkBoxState.contentEquals("false")){
            element.click();
        }
    }
    public void unCheckCheckbox(WebElement element) {
        String checkBoxState = element.getAttribute("checked");
        if(checkBoxState != null && checkBoxState.contentEquals("true")){
            element.click();
        }
    }

    public void selectItemFromCombobox(WebElement element, String itemToSelect){
        element.click();
        List<WebElement> options = element.findElements(By.tagName("option"));
        for(WebElement item : options){
            System.out.println(item.getText());
            if(item.getText().trim().contentEquals(itemToSelect)){
                item.click();
            }
        }
        element.click();
    }

    public void selectBootstrapCombobox(WebElement element, String itemToSelect) {
        WebElement parent = element.findElement(By.xpath(".."));
        List<WebElement> items = parent.findElements(By.xpath(".//ul/li/a"));
        for(WebElement item : items){
            System.out.println("Item: " + item.getText());
            if(item.getText().trim().contentEquals(itemToSelect)){
                item.click();
                break;
            }
        }
    }

    public void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void jsClick(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",  element);
    }

    public void highlight(WebDriver driver , WebElement element) {
        for (int i = 0; i < 2; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 2px solid red;");
            delayFor(200);
            js.executeScript(
                    "arguments[0].setAttribute('style', arguments[1]);",
                    element, "");
            delayFor(200);
        }
    }

    public void hoverItem(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void hoverItemEx(WebDriver driver, WebElement element){
        Locatable hoverItem = (Locatable) element;
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        mouse.mouseMove(hoverItem.getCoordinates());
    }

    public void mouseHoverJScript(WebDriver driver, WebElement HoverElement) {
        try {
            if (isElementPresent(HoverElement)) {
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
                ((JavascriptExecutor) driver).executeScript(mouseOverScript,HoverElement);
            } else {
                System.out.println("Element was not visible to hover " + "\n");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element with " + HoverElement
                    + "is not attached to the page document"
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + HoverElement + " was not found in DOM"
                    + e.getStackTrace());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while hovering"
                    + e.getStackTrace());
        }
    }

    public static boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            if (element.isDisplayed()
                    || element.isEnabled())
                flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
        } catch (StaleElementReferenceException e) {
            flag = false;
        }
        return flag;
    }

    public static void delayFor(int timeinMili) {
        try {
            Thread.sleep(timeinMili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
