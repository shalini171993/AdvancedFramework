package com.shalini.utilities;

import com.shalini.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Utils extends TestBase {

    public static String screenShotPath;
    public static String screenShotName;

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    public static void captureScreenshot() throws IOException {

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenShotName = "error_"+Math.random()+".jpg";
        FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
    }


}
