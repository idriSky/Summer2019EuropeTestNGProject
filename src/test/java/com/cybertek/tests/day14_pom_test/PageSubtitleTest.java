package com.cybertek.tests.day14_pom_test;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalenderEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events
    */

    @Test
    public void verifySubtitleTest(){
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        Assert.assertEquals(expectedSubtitle,actualSubtitle,"Verify subtitles");

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        String expectedSubtitle1 = "Calendar Events";
        String actualSubtitle1 =calenderEventsPage.getPageSubTitle();
        Assert.assertEquals(expectedSubtitle1,actualSubtitle1,"verify subtitle ");

    }

}
