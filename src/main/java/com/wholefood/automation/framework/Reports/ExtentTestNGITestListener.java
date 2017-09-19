package com.wholefood.automation.framework.Reports;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

/**
 * Created by jahangir shaheen on 7/15/2017.
 */


public class ExtentTestNGITestListener implements ITestListener {
    //*********************************************************************************
  /*  private static ExtentManager extent = ExtentManager.createInstance("extent.html");
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();

    @Override
    public synchronized void onStart(ITestContext context) {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {

        ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(child);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {

        test.get().pass("Test passed");
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }*/
  //***********************************************************************************
    public static ExtentManager extentManager =  ExtentManager.getInstance().init("extent.html");

    @Override
    public synchronized void onStart(ITestContext context) {
        extentManager.createParentTest(context.getSuite().getName());
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extentManager.flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();
        String className = result.getMethod().getTestClass().getRealClass().getSimpleName();
        String packageName = result.getMethod().getTestClass().getRealClass().getPackage().getName();
        String testDescription = result.getMethod().getDescription();
        if (result.getParameters().length > 0) {
            testName = testName + "["
                    + result.getMethod().getCurrentInvocationCount() + "]";
            String parameters = Arrays.deepToString(result.getParameters());
            testDescription = testDescription + " with parameters "
                    + parameters;
        }
        extentManager.createChildTest(testName,testDescription);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        extentManager.testSuccess(result);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {

        extentManager.testFailure(result);
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

        extentManager.testSkipped(result);
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}