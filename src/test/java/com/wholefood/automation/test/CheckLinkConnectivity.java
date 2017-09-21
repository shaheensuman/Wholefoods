package com.wholefood.automation.test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 9/3/2017.
 */
public class CheckLinkConnectivity extends WholeFoodScriptBase {
    @Test
    public void shoppingLinkConnection(){
        wholeFood().homepage().shoppingLinkConnection();
    }
    @Test
    public void topNavLinkConnection(){
        wholeFood().homepage().topNavLinkConnection();
    }
}
