package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected ExtentReports report;  //this class is used for starting and building reports
    protected ExtentHtmlReporter htmlReporter;  //this class is used to create the HTML report file
    protected ExtentTest extentLogger;  //this will be definea test, enables adding logs, authors, test steps
    protected String url;

    @BeforeTest
    public void setUpTest() {
        report = new ExtentReports();  //initialize the class
        String projectPath = System.getProperty("user.dir");  //create report path
        String path = projectPath + "/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);   //initialize the html reporter with the report path
        report.attachReporter(htmlReporter);       //attach the html report to the report object
        htmlReporter.config().setReportName("Vytrack smoke test");
        report.setSystemInfo("Environment", "QA");    //set environmet information
        report.setSystemInfo("Browser", ConfigurationReader.get("Browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @AfterTest
    public void tearDownTest() {
        report.flush();   //this is when the report is actually created
    }

    @BeforeMethod
    @Parameters("env")
    public void setUpMethod(@Optional String env) {
        System.out.println("env = " + env);

        // if env variable is null use default url
        // if env variable is not null get url based on env

        if(env==null){
            url=ConfigurationReader.get("url");
        }else {
            url = ConfigurationReader.get(env+"_url");
        }
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        driver.get(url);
    }

    //ITestResult class describes the result of a test in TestNg
    @AfterMethod
    public void tearDownMethod(ITestResult result) throws InterruptedException, IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            //record the name of the failed test case
            extentLogger.fail(result.getName());
            //take the screenshot and return location of screenshot
            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenshotPath);
            //capture the exception
            extentLogger.fail(result.getThrowable());
        }else if(result.getStatus()==ITestResult.SKIP) {
            extentLogger.skip("Test Skipped: " + result.getName());
        }
            //close the driver
            Thread.sleep(1000);
            Driver.closeDriver();
        }
    }




