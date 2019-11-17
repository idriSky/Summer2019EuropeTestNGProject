package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioButton() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton=driver.findElement(By.id("blue"));
        WebElement redRaduoButton=driver.findElement(By.id("red"));

        // how to check radio button selected or not

        System.out.println( "Is blue selected: "+ blueRadioButton.isSelected());
        System.out.println( "Is red selected: "+ redRaduoButton.isSelected());

        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue button is selected");
        Assert.assertFalse(redRaduoButton.isSelected(),"verify that red button is not selected");

        //how to select radio button
        System.out.println("Click red radio button");
        redRaduoButton.click();
        System.out.println( "Is blue selected: "+ blueRadioButton.isSelected());
        System.out.println( "Is red selected: "+ redRaduoButton.isSelected());

        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue is not selected");
        Assert.assertTrue(redRaduoButton.isSelected(),"verify that red button is selected");

    Thread.sleep(2000);
    driver.quit();
    }

}
