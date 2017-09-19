package test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.Test;

import java.util.Set;

//import org.junit.Test;

/**
 * Created by jahangir shaheen on 8/17/2017.
 */
public class ShopingFunctionality extends WholeFoodScriptBase {
    @Test
    public void goShopPage(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().verifyShopOnlinePage();
        WebElementUtils.delayFor(3000);
    }
    @Test
    public void goForShop(){
        wholeFood().homepage().goShopOnlinePage();

        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().goShopNow();

        WebElementUtils.delayFor(3000);
        Set<String>whs=driver.getWindowHandles();
        for (String wh:whs){
            System.out.println(wh);
        }
      String cw=  driver.getWindowHandle();
        System.out.println("current window = "+cw);
    }
    @Test
    public void shoppingUsingInvalidEmail(){

      wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(1000);
        wholeFood().shopOnlinePage().shopProcess("10462");

        WebElementUtils.delayFor(2000);
        wholeFood().shopOnlinePage().SignWithEmail("jahangir","shaheen","shaheen2017","shaheen2017");
    }
    @Test
    public void signWithValidEmailValidPassword(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(1000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().SignWithEmail("jahangir","shaheen","jshaheen03@gmail.com","shaheen2017");

    }
    @Test
    public void signExistingUser(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(1000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().SignWithEmail("jahangir","shaheen","jshaheen03@gmail.com","shaheen2017");
    }
    @Test
    public void signUpValidEmailShortPassword(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().shopProcess("10462");
       wholeFood().shopOnlinePage().signExistingUser("jahangir","shaheen","jshaheen03@gmail.com","shaheen2017");
    }
    @Test
    public void loginForAccountHolder(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().loginAsAccountHolder("jshaheen03@gmail.com","shaheen2017");
    }
    @Test
    public void startShopping() throws InterruptedException {
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().loginAsAccountHolder("jshaheen03@gmail.com","zayan2017");
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage.startShopping(10);
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().goToShopCart();
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage.checkedOut();
        WebElementUtils.delayFor(5000);
    }
    @Test
    public void StartShoppingTwo() throws InterruptedException {
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().loginAsAccountHolder("jshaheen03@gmail.com","zayan2017");
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage.modifyAmount(0,5,1);
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().goToShopCart();
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage.checkedOut();
        WebElementUtils.delayFor(5000);

    }
    @Test
    public void StartShoppingThree() throws InterruptedException {
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().shopProcess("10462");
        wholeFood().shopOnlinePage().loginAsAccountHolder("jshaheen03@gmail.com","zayan2017");
        WebElementUtils.delayFor(5000);
       // wholeFood().shopOnlinePage.modifyAmount2('A',5,1);
        wholeFood().shopOnlinePage().modifyAmount3('A',10,5);
        WebElementUtils.delayFor(3000);
        wholeFood().shopOnlinePage().goToShopCart();
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage.checkedOut();
        WebElementUtils.delayFor(5000);
        wholeFood().shopOnlinePage().inputAddress();
        WebElementUtils.delayFor(5000);

    }
    @Test
    public void findShoppingMenu(){
        wholeFood().homepage().findingShoppingMenu(4);
    }
    @Test
    public void isShoppingMenu(){

        wholeFood().homepage().assertShoppingMenu(10,"Gift Cards");
    }
    @Test
    public void checkShoppingMenu(){
        wholeFood().homepage().shoppingLink();
    }
}
