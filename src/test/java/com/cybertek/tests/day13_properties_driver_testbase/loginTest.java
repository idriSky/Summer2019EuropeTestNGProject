package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
public class loginTest extends TestBase {

    @Test
    public void test1(){
        driver.get("http://qa2.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
    }
    @Test
    public void test2(){
        driver.get(ConfigurationReader.get("url"));


    }
}
