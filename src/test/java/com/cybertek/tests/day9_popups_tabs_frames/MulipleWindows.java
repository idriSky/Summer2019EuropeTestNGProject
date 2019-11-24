package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MulipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void trearDownMethod() throws InterruptedException {

        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before clicking the link " + driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("Before clicking the link " + driver.getTitle());


       // driver.switchTo().window()

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);

        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println(windowHandles.size());

        for (String handle:windowHandles) {
            if (!currentWindowHandle.equals(handle)){
                driver.switchTo().window(handle);
            }

        }
        System.out.println("After switchin "+ driver.getTitle());

        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");

        String targetWindowTitle = "New Window";

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());

       Set<String> windowHandles = driver.getWindowHandles();

        for (String handle:windowHandles ) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetWindowTitle)){
                break;
            }
        }

        System.out.println("After loop, title is : "+driver.getTitle());



    }


}
