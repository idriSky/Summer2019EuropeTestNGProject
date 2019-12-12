package com.cybertek.tests.day11_actions_jsExecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class HoverTest {
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
    public void test1() {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img = driver.findElement(By.tagName("img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(img).perform();
        WebElement text = driver.findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void Test2() {
        driver.get("http://practice.cybertekschool.com/hovers");

        // with list
        Actions actions = new Actions(driver);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List<WebElement> texts = driver.findElements(By.tagName("h5"));

        for (int i = 0; i < images.size(); i++) {
            actions.moveToElement(images.get(i)).perform();
            Assert.assertTrue(texts.get(i).isDisplayed());
        }


    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        // with String manipulation
        for (int i = 1; i < 4; i++) {

            //creating dynamic xpath using i
            String imageXpath = "(//img)[" + i + "]";
            System.out.println("after combining string" + imageXpath);
            //passing xpath to weblement
            WebElement img = driver.findElement(By.xpath(imageXpath));

            //creating actions object
            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            //hovering over on the image
            actions.moveToElement(img).perform();

            //creating dynamic xpath for the text
            String textXpath = "//h5[.='name: user" + i + "']";
            System.out.println("textXpath = " + textXpath);

            //passing xpath to webelement
            WebElement text = driver.findElement(By.xpath(textXpath));
            //verifying text is displayed
            Assert.assertTrue(text.isDisplayed());
        }


    }
    @Test
    public void StaleTest(){
        driver.get("http://google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("selenium"+ Keys.ENTER);

        WebElement result = driver.findElement(By.id("resultStats"));
        Assert.assertTrue(result.isDisplayed());

        driver.navigate().back();

        input.sendKeys("Java"+Keys.ENTER);

    }
}