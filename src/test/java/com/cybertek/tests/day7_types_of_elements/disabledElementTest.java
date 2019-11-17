package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class disabledElementTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton=driver.findElement(By.id("green"));


        System.out.println("Is element enable: "+ greenRadioButton.isEnabled());

        Assert.assertFalse(greenRadioButton.isSelected(),"verify that green button is not enable");

        greenRadioButton.click();
    }
    @Test
    public void test2(){
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox=driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));

        System.out.println("is input enable: " + inputBox.isEnabled());

        inputBox.sendKeys("mike ");


    }
}
