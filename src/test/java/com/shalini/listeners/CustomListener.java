package com.shalini.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.shalini.base.TestBase;
import com.shalini.utilities.Utils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListener extends TestBase implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        test =reportManager.startTest(result.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        TestBase.test.log(LogStatus.PASS,result.getName().toUpperCase()+" PASS");
        reportManager.endTest(test);
        reportManager.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            Utils.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TestBase.test.log(LogStatus.FAIL,result.getName().toUpperCase()+" Failed with exception :"+result.getThrowable());
        TestBase.test.log(LogStatus.FAIL,test.addScreenCapture(Utils.screenShotName));

        System.setProperty("org.uncommons.reportng.escape-output","false");
        Reporter.log("Test case has failed");
        Reporter.log("<a target=\"_blank\"href ="+Utils.screenShotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\"href ="+Utils.screenShotName+"><img src="+Utils.screenShotName+" height=200 width =200></img></a>");
        reportManager.endTest(test);
        reportManager.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
