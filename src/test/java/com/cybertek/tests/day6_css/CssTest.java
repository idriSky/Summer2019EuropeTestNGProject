package com.cybertek.tests.day6_css;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClickButton = driver.findElement(By.cssSelector("#disappearing_button"));
        String message=dontClickButton.getText();
        System.out.println("message = " + message);

        WebElement buttonOne=driver.findElement(By.cssSelector("[onclick='button1()']"));
        String message1=buttonOne.getText();
        System.out.println("message1 = " + message1);


        driver.quit();
    }
}
