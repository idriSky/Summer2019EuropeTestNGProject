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

import javax.swing.*;

public class DragAnDrop {
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
    public void DragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //we have to provide source and target to this method, it will drag and drop
        actions.dragAndDrop(source,target).perform();

    }
    @Test
    public void DragAndDropChaining(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();

        // if you are chaining action we add build() method before perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You did great!']")).isDisplayed(),"Verify 'You did great!' diplayed");


    }



}
