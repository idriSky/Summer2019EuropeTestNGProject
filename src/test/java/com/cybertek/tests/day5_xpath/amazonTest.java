package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://amazon.com");

        WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("selenium");

      WebElement searchClick=driver.findElement(By.xpath("//input[@value= 'Go']"));
       searchClick.click();

       WebElement result=driver.findElement(By.xpath("(//span[contains(.,'results for')])[2]"));

        //System.out.println(result.getText());

        String expectedResult="1-48 of 399 results for";
        String actualResult=result.getText();

        if(expectedResult.equals(actualResult)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
        }
       Thread.sleep(2000);
        driver.close();
    }
}
