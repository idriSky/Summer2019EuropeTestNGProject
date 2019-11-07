package com.cybertek.tests.day3_webElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyComfimationMessage {

    /**Verify confirmation message
     1. open browser
     2. go to http://practice.cybertekschool.com/forgot_password
     3. Links to an external site.
     4. enter any email
     5. verify that email is displayed in the input box
     6. click on Retrieve password
     7. verify that confirmation message says 'Your e-mail's been sent!'*/

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        Thread.sleep(2000);

        WebElement forgottenMailInput= driver.findElement(By.name("email"));

        String expectedEmail="test@gmail.com";
        forgottenMailInput.sendKeys(expectedEmail);
        String actualEmail=forgottenMailInput.getAttribute("value");

        if(expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedEmail = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        String expectedMessage="Your e-mail's been sent!";
        WebElement comfirmationmessage= driver.findElement(By.name("confirmation_message"));

       String actualMessage=comfirmationmessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

    Thread.sleep(2000);
    driver.quit();
    }
}
