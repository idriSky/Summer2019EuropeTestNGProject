package com.cybertek.tests.day15_extentreport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemotest {
    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used to create th HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;
    @BeforeMethod
    public void setUp(){
        //initialize the class
        report = new ExtentReports();
        //create report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath +"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter= new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack smoke test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", "chrome");
        report.setSystemInfo("Tester","Europe+UK testers");

    }


    @Test
    public void test1(){

        // give name to the curretn test
        extentLogger = report.createTest("TC342 loging as driver");

        //test steps
        //info() --> write test steps
        extentLogger.info("Open chrom");

        extentLogger.info("go to url");

        extentLogger.info("enter driver info");

        extentLogger.info("click submit");

        extentLogger.info("verify logged in");

        //Pass()--> marks the test case as passed
        extentLogger.pass("TC342 passed");
    }

    @AfterMethod
    public void teardorwn(){

        report.flush();
    }
}





