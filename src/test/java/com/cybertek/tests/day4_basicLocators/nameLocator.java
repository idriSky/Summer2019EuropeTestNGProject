package com.cybertek.tests.day4_basicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        Thread.sleep(2000);

        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("erkam");

        Thread.sleep(2000);

        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("erkam@gmail.com");

        Thread.sleep(2000);

        WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        signUp.click();


        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        WebElement comfirmationmessage= driver.findElement(By.name("signup_message"));

        String actualMessage=comfirmationmessage.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        Thread.sleep(3000);
        driver.close();
    }
}
