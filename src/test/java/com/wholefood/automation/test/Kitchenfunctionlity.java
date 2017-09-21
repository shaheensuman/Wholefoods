package com.wholefood.automation.test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 8/27/2017.
 */
public class Kitchenfunctionlity extends WholeFoodScriptBase {
    @Test
    public void navigateToRecipePage(){
        wholeFood().homepage().goRecipesPage();
        WebElementUtils.delayFor(5000);
        wholeFood().recipesPage().verifyRecipesPage();
    }

}
