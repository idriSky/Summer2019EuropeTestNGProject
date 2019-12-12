package com.cybertek.tests.DataTest;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class beinSport {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        // Thread.sleep(3000);
        //driver.quit();


    }
    @Test
    public void hoverOver() throws InterruptedException {
    driver.get("https://tr.beinsports.com/");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> images = driver.findElements(By.xpath("//*[@class='thumbs']//a[1]"));

        for (int i = 1; i <images.size() ; i++) {

            String hover = "//*[@class='thumbs']//a[" + i + "]";

            WebElement hoverOver= driver.findElement(By.xpath(hover));

            Actions actions = new Actions(driver);

            Thread.sleep(2000);
            actions.moveToElement(hoverOver).perform();

            System.out.println("hoverOver.getText() = " + hoverOver.getText());

        }

    }


}
