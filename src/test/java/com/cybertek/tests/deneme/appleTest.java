package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;

import java.util.List;

public class appleTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
                driver.manage().window().maximize();
        driver.get("http://apple.com");
        Thread.sleep(2000);

        WebElement learnMore= driver.findElement(By.xpath("//a[@data-analytics-title=\"Learn more about iPhone 11 Pro\"]"));
        learnMore.click();

        WebElement iphone11pro=driver.findElement(By.xpath("//a[@data-analytics-title='product index']"));
        iphone11pro.click();

        driver.navigate().back();

        Thread.sleep(2000);

        WebElement continueButton=driver.findElement(By.xpath("//a[@data-analytics-title='continue button']"));
        continueButton.click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement tools= driver.findElement(By.xpath("//span[@class=\"ac-gn-menuicon-bread ac-gn-menuicon-bread-top\"]"));
        tools.click();











   // Thread.sleep(2000);
   // driver.close();
    }
}
