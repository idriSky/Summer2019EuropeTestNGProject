package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        Thread.sleep(2000);

      //  WebElement homeLink=driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

       // homeLink.click();

     //   WebElement text= driver.findElement(By.xpath("/html/body/div/div/div/div/p"));

      //  String textx1=text.getText();

     //   System.out.println(textx1);

        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();



    Thread.sleep(2000);
    driver.close();
    }

}
