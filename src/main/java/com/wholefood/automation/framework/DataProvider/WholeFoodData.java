package com.wholefood.automation.framework.DataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by jahangir shaheen on 9/17/2017.
 */
public class WholeFoodData {
    @DataProvider(name = "firstdata")

    public static Object[][]dataProviderMethod(){
        return new Object[][]{{"New York",5},{"Nevada",4}};
    }
    @DataProvider(name = "seconddata")
    public static Object[][]dataProviderMethodTwo(){
        return new  Object[][]{{1},{2},{3}};
    }
}
