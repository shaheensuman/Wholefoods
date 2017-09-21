package com.wholefood.automation.test;

import com.aventstack.extentreports.ExtentReports;
import com.wholefood.automation.framework.WholeFoodScriptBase;
import org.testng.annotations.Test;

/**
 * Created by jahangir shaheen on 9/2/2017.
 */
public class ImageFunctionality extends WholeFoodScriptBase {
    @Test
    public void imageTest(){
        ExtentReports reports=new ExtentReports();
        reports.attachReporter();
        wholeFood().homepage().image();
    }
}
