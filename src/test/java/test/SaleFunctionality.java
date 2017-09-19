package test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 8/18/2017.
 */
public class SaleFunctionality extends WholeFoodScriptBase {
    @Test
    public void verifyStates(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(5000);
        wholeFood().onSalePage().verifyStates();
    }
    @Test
    public void verifyStoresByState(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().verifyStoreLocation("Michigan");

    }

    @Test
    public void findingStore(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(5000);
        wholeFood().onSalePage().selectStore("New York",5);
        WebElementUtils.delayFor(2000);
    }

    @Test
    public void storeWithActualStoreName(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(5000);
        wholeFood().onSalePage().selectStoret2("New York",5,"Jericho");

    }

    @Test
    public void assertStoreLocation(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(3000);
        wholeFood().onSalePage().subMenuAfterClick("Nevada",4);
        WebElementUtils.delayFor(1000);
    }

    @Test
    public void verifyButton(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().cupponButonBeforeSelect();
    }

    @Test
    public void verifyCupponButton(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().cupponButonSelectStateOnly("Nevada");
    }

    @Test
    public void verifyCupponButtonTwo(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().cupponButonAfterselect("Nevada",4);
    }
    @Test
    public void getcoupon(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().cupponButonAfterselect("Nevada",4);
        WebElementUtils.delayFor(4000);
        wholeFood().onSalePage().saleAndCoupon("New York",4);
        WebElementUtils.delayFor(3000);
    }
    @Test
    public void navigateStores(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySrores();
    }
    @Test
    public void findingStores(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySubMenu();
    }

    public void findingSubMenu(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySubMenu();
    }

    @Test
    public void goForCupon(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().goForCoupon();
        WebElementUtils.delayFor(3000);
    }

    @Test
    public void VerifyCupons(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().veryfyCupponlist();
        WebElementUtils.delayFor(3000);
    }

    @Test
    public void selectAllCupons(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().selectAllCkBox();
        WebElementUtils.delayFor(3000);
    }

    @Test
    public void getsalePrice(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySalePrice();

    }
    @Test
    public void getsalePriceTwo(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySalePriceTwo("any TWO (2) Just products","$1.00 off");
    }
    @Test
    public void getsalePriceThree(){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores("New York",3);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().VerifySalePriceThree();
    }

    // data use from same class.

    @Test(dataProvider = "dataOne")
    public void selectAllCuponsByData(String stateName,int storeIndex){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores(stateName,storeIndex);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().selectAllCkBox();
        WebElementUtils.delayFor(3000);
    }

    @Test(dataProvider = "dataTwo")
    public void verifyStoresWithData(String state,int index,String expStore){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(5000);
        wholeFood().onSalePage().selectStoret2(state,index,expStore);

    }

    //using @dataProvidor and @Test in the same class

    @DataProvider(name = "dataOne")
    public static Object[][]dataProviderMethodOne(){
        return new Object[][]{{"New York",5},{"Nevada",4}};

    }

    @DataProvider(name = "dataTwo")
    public static Object[][]dataProviderMethodTwo(){
        return new Object[][]{{"New York",6,"Lake Grove"},{"Maryland",1,"Annapolis"}};
    }
}
