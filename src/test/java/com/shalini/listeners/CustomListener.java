package com.shalini.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.shalini.base.TestBase;
import com.shalini.utilities.MonitoringMail;
import com.shalini.utilities.TestConfig;
import com.shalini.utilities.Utils;
import org.testng.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CustomListener extends TestBase implements ITestListener, ISuiteListener {
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

    @Override
    public void onStart(ISuite suite) {
        String ip = null;
        try {
            ip = "http//:"+ InetAddress.getLocalHost().getHostAddress()+":8080/job/Selenium_Maven/Extent_20Report/";
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        MonitoringMail mail = new MonitoringMail();
        try {
            mail.sendMail(TestConfig.server,TestConfig.from,TestConfig.to,TestConfig.subject,ip);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {

    }
}
