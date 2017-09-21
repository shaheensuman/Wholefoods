package com.wholefood.automation.test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import com.wholefood.automation.framework.utils.WebElementUtils;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 9/2/2017.
 */
public class SignInFunctionality extends WholeFoodScriptBase {
    @Test
    public void invalidEmailInvalidPassword(){
        wholeFood().homepage().goSignInPage();
        WebElementUtils.delayFor(3000);
        wholeFood().signInPage().goForSignIn("jahangir","shaheen");
        WebElementUtils.delayFor(3000);
    }
}
