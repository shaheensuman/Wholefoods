package com.wholefood.automation.framework.Model;

import com.wholefood.automation.framework.controller.PageBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by jahangir shaheen on 8/27/2017.
 */
public class RecipesPageModel extends PageBase {

    public RecipesPageModel(WebDriver driver) {
        super(driver);
    }
   protected String actualTitle= driver.getTitle();

}
