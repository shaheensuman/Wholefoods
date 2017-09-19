package com.wholefood.automation.framework.controller;

import com.wholefood.automation.framework.Model.ShoppingPageModel;
import com.wholefood.automation.framework.utils.JavascriptExecutorUtils;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Set;

/**
 * Created by jahangir shaheen on 8/17/2017.
 */
public class ShopOnlineController extends ShoppingPageModel {

    public ShopOnlineController(WebDriver driver) {
        super(driver);

    }
  /*  WebElement firstNameBox=driver.findElement(By.name("first_name"));
    WebElement lastnameBox=driver.findElement(By.name("last_name"));
    WebElement emailbox=driver.findElement(By.name("email"));
    WebElement passwordBox=driver.findElement(By.name("password"));
    WebElement signWithEmailButton=driver.findElement(By.cssSelector(".rcp-form-submit-button.ic-btn.ic-btn-success.undefined"));//
    WebElement message=driver.findElement(By.xpath(".//*[@id='signup-widget']/div/div[3]/form/div[2]/fieldset[2]/div"));
  */
    public void verifyShopOnlinePage(){
        System.out.println("page url : "+driver.getCurrentUrl());
        String expectedTitle="Online Ordering and Catering | Whole Foods Market";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public void goShopNow(){
        shopNowButton.click();
    }
    public void shopProcess(String zipcode){
        goShopNow();
        String currentWindow=driver.getWindowHandle();
        Set<String> windows=driver.getWindowHandles();
        for (String window:windows){
            //System.out.println(window);
            if(!currentWindow.contentEquals(window)){
                driver.switchTo().window(window);
            }
        }
    WebElementUtils.delayFor(3000);
    WebElement zipBox=driver.findElement(By.xpath("//input[@class='form-control u-textCenter']"));
    WebElement startShoppingButton=driver.findElement(By.cssSelector(".rcp-form-submit-button.ic-btn.ic-btn-success.undefined"));
    zipBox.sendKeys(zipcode);
    startShoppingButton.click();
    WebElementUtils.delayFor(3000);

    WebElement welcome=driver.findElement(By.xpath("//div[@class='heading']"));
    if(welcome!=null){
        String welcometext=welcome.getText();
        if (welcometext.contains(zipcode)){
            System.out.println(welcometext);
        }else {
            System.out.println("yooo");
        }
    }

    }
    public void SignWithEmail(String FirstName,String Lastname,String email,String password){
       // shopProcess();
        WebElement firstNameBox=driver.findElement(By.name("first_name"));
        WebElement lastnameBox=driver.findElement(By.name("last_name"));
        WebElement emailbox=driver.findElement(By.name("email"));
        WebElement passwordBox=driver.findElement(By.name("password"));
        WebElement signWithEmailButton=driver.findElement(By.cssSelector(".rcp-form-submit-button.ic-btn.ic-btn-success.undefined"));
        WebElementUtils.delayFor(3000);
        firstNameBox.sendKeys(FirstName);
        lastnameBox.sendKeys(Lastname);
        emailbox.sendKeys(email);
        passwordBox.sendKeys(password);
        signWithEmailButton.click();
        WebElementUtils.delayFor(2000);


       /* if(password.length()<6){
            WebElement message=driver.findElement(By.xpath(".//*[@id='signup-widget']/div/div[3]/form/div[2]/fieldset[2]/div"));
            String actuaMessaget=message.getText();
            String expectedMessage="is too short (minimum is 6 charactersx)";
            System.out.println("password is too short");
            //boolean istooshort=password.contains("@");
            Assert.assertEquals(actuaMessaget,expectedMessage);
        }*/
    }
    public void ShortPassword(String FirstName,String Lastname,String email,String password){
        SignWithEmail(FirstName, Lastname,email,password);

        if(password.length()<6){
            WebElement message=driver.findElement(By.xpath(".//*[@id='signup-widget']/div/div[3]/form/div[2]/fieldset[2]/div"));
            String actuaMessage=message.getText();
            String expectedMessage="is too short (minimum is 6 characters)";
            System.out.println("password is less than 6 characters.");
            //boolean istooshort=password.contains("@");
            Assert.assertEquals(actuaMessage,expectedMessage);
        }

    }
    public void signExistingUser(String FirstName,String Lastname,String email,String password ){
        WebElement firstNameBox=driver.findElement(By.name("first_name"));
        WebElement lastnameBox=driver.findElement(By.name("last_name"));
        WebElement emailbox=driver.findElement(By.name("email"));
        WebElement passwordBox=driver.findElement(By.name("password"));
        WebElement signWithEmailButton=driver.findElement(By.cssSelector(".rcp-form-submit-button.ic-btn.ic-btn-success.undefined"));
        WebElementUtils.delayFor(3000);
        firstNameBox.sendKeys(FirstName);
        lastnameBox.sendKeys(Lastname);
        emailbox.sendKeys(email);
        passwordBox.sendKeys(password);
        signWithEmailButton.click();
        WebElementUtils.delayFor(2000);
        WebElement mgs=driver.findElement(By.xpath(".//*[@id='signup-widget']/div/div[3]/form/div[2]/fieldset[1]/div"));
        String msgtext=mgs.getText();
        String expectedMsg="has already been taken";
       // Assert.assertTrue(true,msgtext);
        Assert.assertEquals(msgtext,expectedMsg);
    }
    public void loginAsAccountHolder(String email,String password){
        WebElement loginLink=driver.findElement(By.xpath("html/body/div[3]/div/div[4]/div[1]/div/a[2]"));
        loginLink.click();
        WebElementUtils.delayFor(3000);
        WebElement emailBox=driver.findElement(By.name("email"));
        WebElement passwordBox=driver.findElement(By.name("password"));
        WebElement loginButton=driver.findElement(By.cssSelector(".rcp-form-submit-button.ic-btn.ic-btn-success.undefined"));
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
        WebElementUtils.delayFor(3000);
       // WebElement thanksButton=driver.findElement(By.cssSelector(".ic-btn.ic-btn-lg.ic-btn-secondary"));
       // thanksButton.click();
    }
    public void startShopping(int add) throws InterruptedException {

        WebElement addButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[2]"));

        System.out.println(addButton.isDisplayed());
        JavascriptExecutorUtils java=new JavascriptExecutorUtils(driver);
        for (int i=0;i<=add;i++){
            java.jsClickWebElement(addButton);
            Thread.sleep(2);
        }
    }
    public void modifyAmount(int option,int add,int sub) throws InterruptedException {

        switch (option){
            case 0:
                JavascriptExecutorUtils utils1=new JavascriptExecutorUtils(driver);
                WebElement addButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[2]"));
                for (int i=0;i<=add;i++){
                    utils1.jsClickWebElement(addButton);
                    Thread.sleep(2);
                }
                break;

            case 1:
                JavascriptExecutorUtils utils2=new JavascriptExecutorUtils(driver);
                WebElement minusButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[1]"));
                for (int i=0;i<=sub;i++){
                    utils2.jsClickWebElement(minusButton);
                    Thread.sleep(2);
                }
                break;
            default:
                System.out.println(" please check option");
        }

    }
    public void modifyAmount2(char plusOrMinus,int add,int sub) throws InterruptedException {

        switch (plusOrMinus){
            case 'A':
                JavascriptExecutorUtils utils1=new JavascriptExecutorUtils(driver);
                WebElement addButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[2]"));
                for (int i=0;i<=add;i++){
                    utils1.jsClickWebElement(addButton);
                    Thread.sleep(2);
                }
                break;

            case 'B':
                JavascriptExecutorUtils utils2=new JavascriptExecutorUtils(driver);
                WebElement minusButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[1]"));
                for (int i=0;i<=sub;i++){
                    utils2.jsClickWebElement(minusButton);
                    Thread.sleep(2);
                }
                break;
            default:
                System.out.println(" please check option");
        }

    }
    public void modifyAmount3(char plusOrMinus,int add,int sub) throws InterruptedException {
        JavascriptExecutorUtils utils=new JavascriptExecutorUtils(driver);
        int count=0;
        switch (plusOrMinus){
            case 'A':
                WebElement addButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[2]"));

                do {
                    utils.jsClickWebElement(addButton);
                    Thread.sleep(2);
                    count++;
                }while (count<add);
                break;

            case 'B':
                // JavascriptExecutorUtils utils2=new JavascriptExecutorUtils(driver);
                WebElement minusButton=driver.findElement(By.xpath(".//*[@id='react-main-content']/div/div/div/div[5]/div/div/ul/div[1]/div/div/li[1]/div[1]/div[4]/div[2]/button[1]"));
                while (count<sub){
                    utils.jsClickWebElement(minusButton);
                    count++;
                }

                break;
            default:
                System.out.println(" please check option");
        }

    }
    public void goToShopCart(){
        WebElement cart=driver.findElement(By.cssSelector(".ic-btn.ic-btn--viewCart"));
        cart.click();
        WebElementUtils.delayFor(3000);
    }
    public void checkedOut(){
        WebElement checkOutButton=driver.findElement(By.cssSelector(".cart-footer-action"));
        checkOutButton.click();
    }
    public void inputAddress(){
        WebElement street=driver.findElement(By.xpath("//input[@class='form-control street-input inspectletIgnore']"));
        WebElement apartmenr=driver.findElement(By.xpath("//input[@class='form-control'][@name='address2']"));
        WebElement businessname=driver.findElement(By.xpath("//input[@class='form-control' ][@name='business_name']"));
        WebElement zipcode=driver.findElement(By.xpath("//input[@class='form-control zip-input' and @name='zip_code']"));
       // WebElement phoneNumber=driver.findElement(By.name("phone"));
        WebElement deliveryOption=driver.findElement(By.xpath("//textarea[@name='note']"));
        WebElement continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        street.sendKeys("1919 mcgraw ave");
        apartmenr.sendKeys("2B");
        zipcode.sendKeys("10462");
       // phoneNumber.sendKeys("3476408386");
        continueButton.click();

    }

}