package com.cybertek.tests.vytrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class fleet {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");

        WebElement username= driver.findElement(By.id("prependedInput"));
        username.sendKeys("storemanager65");
        //Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        //Thread.sleep(2000);

        WebElement login = driver.findElement(By.name("_submit"));
        login.click();

        Actions action = new Actions(driver);
        WebElement fleet = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        action.moveToElement(fleet).build().perform();
        WebElement contract =driver.findElement(By.xpath(""));
        contract.click();

        //driver.quit();
    }
}


