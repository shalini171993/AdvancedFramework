package com.shalini.testcases;

import com.shalini.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddCustomerTest extends TestBase {


    @Test(dataProvider = "getData")
    public void addCustomerDetails(String fname,String lname,String postCode) throws InterruptedException {
     /*   driver.findElement(By.cssSelector(objectRepoProperties.getProperty("managerLoginBtn"))).click();
        Thread.sleep(3000);*/
        driver.findElement(By.cssSelector(objectRepoProperties.getProperty("addCustomerBtn"))).click();
        Thread.sleep(3000);
       /* driver.findElement(By.cssSelector(objectRepoProperties.getProperty("firstName"))).sendKeys(fname);
        driver.findElement(By.cssSelector(objectRepoProperties.getProperty("lastName"))).sendKeys(lname);
        driver.findElement(By.cssSelector(objectRepoProperties.getProperty("postCode"))).sendKeys(postCode);
        driver.findElement(By.cssSelector(objectRepoProperties.getProperty("addButton"))).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();*/
    }

    @DataProvider
    public Object[][] getData(){
        String sheetname = "AddCustomerTest";
        int rows = excelReader.getRowCount(sheetname);
        int columns=excelReader.getColumnCount(sheetname);

        Object[][] data= new Object[rows-1][columns];
        for(int rowNum =2;rowNum<=rows;rowNum++){
            for(int colNum = 0;colNum<columns;colNum++){
                data[rowNum-2][colNum]= excelReader.getCellData(sheetname,colNum,rowNum);
            }
        }
        return data;
    }
}
