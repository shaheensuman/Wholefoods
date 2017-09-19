package test;

import com.wholefood.automation.framework.WholeFoodScriptBase;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 9/3/2017.
 */
public class PageMenuFunctionality extends WholeFoodScriptBase {
    @Test
    public void getNavMenu(){
        wholeFood().homepage().findNavMenu();
    }
    @Test
    public void verifyNavMenu(){
        wholeFood().homepage().assertNavMenu();
    }
}
