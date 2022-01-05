package com.shalini.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shalini.testcases.LoginTest;
import com.shalini.utilities.ExcelReader;
import com.shalini.utilities.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.*;
public class TestBase {


    public static WebDriver driver;
    public static Properties configProperties = new Properties();
    public static Properties objectRepoProperties = new Properties();
    public static FileInputStream fis;
    public static ExcelReader excelReader = new ExcelReader("C:\\Users\\Shalini\\IdeaProjects\\testAutomation\\src\\test\\resources\\excel\\testdata.xlsx");
    //public static Logger log = Logger.getLogger(LoginTest.class);

    public ExtentReports reportManager = ExtentReportManager.getInstance();
    public static ExtentTest test;
    @BeforeSuite
    public void setUp() throws IOException {

        if(driver==null){
            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
            configProperties.load(fis);

            fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\ObjectRepo.properties");
            objectRepoProperties.load(fis);

            //log.debug("Loaded the properties file");

        }

        if(configProperties.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executebles\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if(configProperties.getProperty("browser").equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get(configProperties.getProperty("url"));
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
