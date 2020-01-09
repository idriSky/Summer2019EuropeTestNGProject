package com.cybertek.TestCase_4;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCase4 extends TestBase {

    @Test
    public void Test1(){
        extentLogger = report.createTest("Tester meeting");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        extentLogger.info("Enter username: "+ username);

        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("Enter password: "+ password);

        loginPage.login(username,password);
        extentLogger.info("Login as store manager");

        DashboardPage dashboardPage = new DashboardPage();
        //dashboardPage.waitUntilLoaderScreenDisappear();

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities than Calender Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();


        WebElement threeDots = driver.findElement(By.cssSelector(".grid-row:nth-child(5) .dropdown-toggle"));
        actions.moveToElement(threeDots).perform();
        extentLogger.info("Hover over on three dots for Tester meeting calender event");
        BrowserUtils.waitFor(2);
        //WebElement xx = driver.findElement(By.xpath("(/html/body/ul/li/ul/li/a)[1]"));
       // Assert.assertTrue(xx.isDisplayed());

        for(int i =1; i<4 ; i++){
        String icon = "(/html/body/ul/li/ul/li/a)["+i+"]" ;
           // System.out.println(icon);
        WebElement icons = driver.findElement(By.xpath(icon));
            System.out.println(icons.getAttribute("value"));
            Assert.assertTrue(icons.isDisplayed());
    }
        extentLogger.pass("PASS");

    }
    @Test
    public void Test2(){
        extentLogger = report.createTest("Column still display Test");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        extentLogger.info("Enter username: "+ username);

        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("Enter password: "+ password);

        loginPage.login(username,password);
        extentLogger.info("Login as store manager");

        DashboardPage dashboardPage = new DashboardPage();
       // dashboardPage.waitUntilLoaderScreenDisappear();

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities than Calender Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.grid.click();
        extentLogger.info("click on grid option button");

        //column-c103
        for (int i=3; i<9; i++) {
            String options = "//*[@id='column-c10'" + i + "]";
            WebElement optionClick = driver.findElement(By.xpath(options));
            optionClick.click();
        }

        WebElement title = driver.findElement(By.xpath("//*[@class='grid-header-cell__link']"));
        Assert.assertTrue(title.isDisplayed());
        extentLogger.pass("Pass: Title column still disable");
    }
    @Test
    public void Test3(){
        extentLogger = report.createTest("Save and CloseTest");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        extentLogger.info("Enter username: "+ username);

        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("Enter password: "+ password);

        loginPage.login(username,password);
        extentLogger.info("Login as store manager");

        DashboardPage dashboardPage = new DashboardPage();
        // dashboardPage.waitUntilLoaderScreenDisappear();

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities than Calender Events");
        //dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Events Button");

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.saveAndClose1.click();
        extentLogger.info("click on Create Calendar Event button");

        Assert.assertTrue(createCalendarEventsPage.saveAndClose2.isDisplayed());
        System.out.println(createCalendarEventsPage.saveAndClose2.getText());
        extentLogger.info("save and close is available");

        Assert.assertTrue(createCalendarEventsPage.saveAndNew.isDisplayed());
        System.out.println(createCalendarEventsPage.saveAndNew.getText());
        extentLogger.info("save and new is available");

        Assert.assertTrue(createCalendarEventsPage.save.isDisplayed());
        System.out.println(createCalendarEventsPage.save.getText());
        extentLogger.info("save is available");

        extentLogger.pass("PASS: Save and Close test  ");


    }
    @Test
    public void Test4(){
        extentLogger = report.createTest("Verify All Calendar Event Subtitle");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        extentLogger.info("Enter username: "+ username);

        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("Enter password: "+ password);

        loginPage.login(username,password);
        extentLogger.info("Login as store manager");

        DashboardPage dashboardPage = new DashboardPage();
        // dashboardPage.waitUntilLoaderScreenDisappear();

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities than Calender Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        extentLogger.info("Click on Create Calendar Events Button");

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();

        createCalendarEventsPage.cancel.click();
        extentLogger.info("Click on Cancel button");

       Assert.assertTrue(createCalendarEventsPage.pageSubTitle.isDisplayed(),"Verify page subtitle");
       extentLogger.pass("PASS: All Calendar Events subtitle is displayed");

    }
    @Test
    public void Test5(){
        extentLogger = report.createTest("Verify difference between end and start time");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        extentLogger.info("Enter username: "+ username);

        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("Enter password: "+ password);

        loginPage.login(username,password);
        extentLogger.info("Login as store manager");

        DashboardPage dashboardPage = new DashboardPage();
        // dashboardPage.waitUntilLoaderScreenDisappear();

        dashboardPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("Navigate to Activities than Calender Events");
        //dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(5);
        driver.findElement(By.xpath("//*[@title='Create Calendar event']")).click();
        extentLogger.info("Click on Create Calendar Events Button");

        BrowserUtils.waitFor(5);
        WebElement start = driver.findElement(By.xpath("//*[@id=\"time_selector_oro_calendar_event_form_start-uid-5e0904f78915c\"]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", start);





        // start.click();
        //Select select = new Select(start);
       // System.out.println(select.getFirstSelectedOption().getText());
       // WebElement end = driver.findElement(By.xpath("//*[@id=\"time_selector_oro_calendar_event_form_end-uid-5e0904f78924c\"]"));


    }

}
