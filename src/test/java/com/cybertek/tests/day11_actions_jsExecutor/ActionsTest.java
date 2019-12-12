package com.cybertek.tests.day11_actions_jsExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/hovers");

        Actions action = new Actions(driver);

        WebElement img = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(img).perform();
        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
        user1.click();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(), "Verify message is display");

    }

}
