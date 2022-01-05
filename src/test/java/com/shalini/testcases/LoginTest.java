package com.shalini.testcases;

import com.shalini.base.TestBase;
import com.shalini.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    Utils utils = new Utils();

    @Test
    public void checkManagerButton(){
        Assert.assertTrue(utils.isElementPresent(By.cssSelector(objectRepoProperties.getProperty("managerLoginBtn"))),"Manager button is not present in the page");
    }
    @Test
    public void login(){
        WebElement managerButton = driver.findElement(By.cssSelector(objectRepoProperties.getProperty("managerLoginBtn")));
        managerButton.click();
        Reporter.log("successfully executed");
    }
}
