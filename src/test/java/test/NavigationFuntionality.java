package test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 8/12/2017.
 */
public class NavigationFuntionality extends WholeFoodScriptBase {
    @Test
    public void verifyHomePage(){
        wholeFood().homepage();

        //wholeFood().homepage().verifyHomepage();
    }
    @Test
    public void navigateSignInPage(){
    wholeFood().homepage().goSignInPage();
     WebElementUtils.delayFor(2000);
     wholeFood().signInPage().verifySignInpage();
  }
    @Test
    public void navigateSalePage(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(5000);
        wholeFood().onSalePage().verifySalePage();
    }
    @Test
    public void navigateShopOnlinePage(){
        wholeFood().homepage().goShopOnlinePage();
        WebElementUtils.delayFor(4000);
        wholeFood().shopOnlinePage().verifyShopOnlinePage();
    }
    @Test
    public void navigateRecipepage(){
        wholeFood().homepage().goRecipesPage();
        WebElementUtils.delayFor(5000);
        wholeFood().recipesPage().verifyRecipesPage();
    }




}
