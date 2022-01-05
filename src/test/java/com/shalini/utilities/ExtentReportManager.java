package com.shalini.utilities;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentReportManager {

    public static ExtentReports extentReports;

    public static ExtentReports getInstance(){
        if(extentReports == null){
            extentReports = new ExtentReports(System.getProperty("user.dir")+"\\target\\extentReports\\extentReport.html",true, DisplayOrder.OLDEST_FIRST);
            //extentReports = new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\extentReport.html");
            extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extentConfig\\ReportsConfig.xml"));
        }
        return extentReports;
    }
}
