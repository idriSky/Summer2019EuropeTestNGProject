package com.cybertek.tests.day16_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
    /*go to qa3.vytrack
login as a sales manager
navigate to customers ->contacts
click on email mbrackstone9@example.com
verify that full name is Ms Mariam Brackstone
verify that email is mbrackstone9@example.com
verify that phone number is +18982323434*/

public class verifyConctactInfoTests extends TestBase {

    @Test
    public void Test1(){
        extentLogger = report.createTest("Contact details Test");
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        extentLogger.info("Enter username: " + username);
        String password = ConfigurationReader.get("salesmanager_password");
        extentLogger.info("Enter password: "+ password);
        loginPage.login(username,password);
        extentLogger.info("Login as a sales manager");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Customers","Contacts");
        extentLogger.info("Navigate to customers -->contacts");

        contactsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        contactsPage.getContantEmail("mbrackstone9@example.com").click();
        extentLogger.info("Click on email mbrackstone9@example.com");

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String actualFullname = contactInfoPage.fullname.getText();
        String expectedFullname = "Ms Mariam Brackstone";

        Assert.assertEquals(actualFullname,expectedFullname,"Verify fullnames");
        extentLogger.info("Verify fullname is "+expectedFullname);

        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com");
        extentLogger.info("verify email is mbrackstone9@example.com");

        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434");
        extentLogger.info("Verify phone number is +18982323434");

    }

}
