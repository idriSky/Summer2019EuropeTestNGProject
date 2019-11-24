package com.cybertek.tests.deneme;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkboxAmazonTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://ebay.com");

        WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
        searchBox.sendKeys("iphone");

        WebElement searchButton=driver.findElement(By.xpath("//*[@id=\"gh-btn\"]"));
        searchButton.click();

        WebElement checkButton=driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/input"));
        checkButton.click();

        Thread.sleep(2000);



    }
}
