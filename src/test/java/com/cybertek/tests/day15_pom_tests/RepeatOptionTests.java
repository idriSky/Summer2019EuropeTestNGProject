package com.cybertek.tests.day15_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

     /*VERIFY RADIO BUTTONS
        Open browser
        Login as driver
        Go to Activities->Calendar
        Click on create calendar events
        Click on repeat
        Verfiy that repeat every days is checked
        verify that repeat weekday is not checked*/

public class RepeatOptionTests extends TestBase {

    @Test
    public void test1() {


    LoginPage loginPage = new LoginPage();

    String username = ConfigurationReader.get("driver_username");
    String password = ConfigurationReader.get("driver_password");

    loginPage.login(username,password);

        //Go to Activities->Calendar
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        //Verfiy that repeat every days is checked
       Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"verify days rb is selected");

       // verify that repeat weekday is not checked
       Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify weekday rb is not selected");


    }

    /*VERIFY REPEAT OPTIONS
    Open browser
    Login as driver
    Go to Activities->Calendar
    Click on create calendar events
    Click on repeat
    Verify that repat options are Daily, Weekly, Monthly,Yearly(in this order)*/
    @Test
    public void test2(){

        /*Open browser
        Login as driver*/
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        //Go to Activities->Calendar
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        //get text of each webelement and return as a list of String
        List<String> actualList = BrowserUtils.getElementsText(actualOptions);

//        List<String> actualList = new ArrayList<>();
//
//        for (WebElement option : actualOptions) {
//            //get each weblement text inside the dropdown and add to actual list
//            actualList.add(option.getText());
//        }


        //compare actual and expected list
        Assert.assertEquals(actualList,expectedList,"Compare dropdown values");
        //Assert.assertEquals(actualOptions,expectedList);






    }
}
