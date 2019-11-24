package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

      driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void trearDownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        driver.findElement(By.xpath("//*[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//*[text()='No']")).click();

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[2]")).click();

        alert.dismiss();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[3]")).click();

        alert.sendKeys("Cybertek");
        Thread.sleep(1000);
        alert.accept();


    }
}
