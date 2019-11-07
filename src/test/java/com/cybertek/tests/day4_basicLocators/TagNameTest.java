package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput=driver.findElement(By.tagName("input"));
        fullnameInput.sendKeys("Mike");

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("email@gmail.com");

        WebElement signUpInput=driver.findElement(By.tagName("button"));
        signUpInput.click();

        System.out.println(driver.findElement(By.tagName("h3")).getText());








        Thread.sleep(2000);
        driver.quit();

    }
}
