package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
       // Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.tagName("button")).click();

        WebElement username = driver.findElement(By.id("username"));

        WebDriverWait wait = new WebDriverWait(driver,10);


        wait.until(ExpectedConditions.visibilityOf(username));

        username.sendKeys("Mike Smith");


    }
    @Test
    public void Teat2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");


        driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

        WebElement myInputBox = driver.findElement(By.cssSelector("input[type='text']"));

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(myInputBox));


        myInputBox.sendKeys("hello");




    }


}
