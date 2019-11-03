package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    /**Verify URL changed
     1.  open browser
     2.go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     3. enter any email
     4. click on Retrieve password
     5. verify that url changed to http://practice.cybertekschool.com/email_sent */

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver  =  WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(3000);

        WebElement emailInput = driver.findElement(By.name("email"));

        emailInput.sendKeys("email@gmail.com");

        Thread.sleep(3000);

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String expectedUrl= "http://practice.cybertekschool.com/email_sents";

        String actualUrl= driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
