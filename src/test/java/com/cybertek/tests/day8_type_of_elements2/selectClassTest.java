package com.cybertek.tests.day8_type_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class selectClassTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("state"));

        Select stateList = new Select(dropDownElement);

        // returns all the available options of the dropdown
        List<WebElement> options = stateList.getOptions();

        for (WebElement option : options) {

            System.out.println(option.getText());

        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate the dropdown element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //create Select object by passing the element as a constructor
        Select stateList = new Select(dropdownElement);
        String expectedOption= "Select a State";
        String actualOption= stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify that actual option is match with expected ");

        // how to select options from the dropdown
        //1.using visible text
        //selectByVisibleTesxt("text);
        Thread.sleep(2000);
        //selecting Texas from the dropdown
        stateList.selectByVisibleText("Texas");
        actualOption= stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");

        //2. using index number
        // total option 52
        Thread.sleep(2000);
        stateList.selectByIndex(51);
        System.out.println(stateList.getFirstSelectedOption().getText());


        actualOption= stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Wyoming");


        //3. using the value
        Thread.sleep(2000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());





    }
}