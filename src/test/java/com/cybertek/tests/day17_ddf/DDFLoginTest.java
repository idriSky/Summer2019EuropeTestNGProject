package com.cybertek.tests.day17_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object [][] userData(){

        ExcelUtil data = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String[][] dataArray = data.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void loginTestDDF(String username, String password, String firstName, String lastName){
        extentLogger = report.createTest("Test "+ firstName+" "+lastName);

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

        String actualFullname = dashboardPage.getUserName();
        String expectedFullname = firstName+" "+lastName;

        Assert.assertEquals(actualFullname,expectedFullname,"compare full name");











    }


}
