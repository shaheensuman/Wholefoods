package com.wholefood.automation.test;

import com.wholefood.automation.framework.DataProvider.WholeFoodData;
import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 9/18/2017.
 * using @dataProvider and @Test in different class.
 */
public class DataDrivenTestFunctionality extends WholeFoodScriptBase {
    @Test(dataProvider = "firstdata" ,dataProviderClass = WholeFoodData.class)
    public void findingStoreByData(String stateName,int storeIndex){
        wholeFood().homepage().goSalePage();
        WebElementUtils.delayFor(2000);
        wholeFood().onSalePage().navigateStores(stateName,storeIndex);
        WebElementUtils.delayFor(2000);
        wholeFood().stores().verifySubMenu();
    }


    @Test(dataProvider = "seconddata" ,dataProviderClass = WholeFoodData.class)
    public void findShoppingMenu(int menuIndex){
        wholeFood().homepage().findingShoppingMenu(menuIndex);
    }
}
