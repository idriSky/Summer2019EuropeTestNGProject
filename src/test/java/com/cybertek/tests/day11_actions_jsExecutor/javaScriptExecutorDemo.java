package com.cybertek.tests.day11_actions_jsExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class javaScriptExecutorDemo {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        // Thread.sleep(3000);
        //driver.quit();


    }

    @Test
    public void click() {

        driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Dropdown"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", link);


    }

    @Test
    public void type() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("input[type='text']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String str = "Hello disable inputBox";

        jse.executeScript("arguments[0].setAttribute('value', '" + str + "')", inputBox);

    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,250)");
        }


        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }
}
