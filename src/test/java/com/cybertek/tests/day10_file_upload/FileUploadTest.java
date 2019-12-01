package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        // Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement upload = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));


        upload.sendKeys("C:\\Users\\idriSky\\Desktop\\file.odt");

        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();

        String file = driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText();

        Assert.assertEquals(file, "file.txt", "verify the file name");


    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/upload");

        String projectpath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";

        String filePath = projectpath + "/" + relativePath;


        WebElement upload = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));


        upload.sendKeys(filePath);

        driver.findElement(By.xpath("//*[@id=\"file-submit\"]")).click();

        String file = driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText();

        Assert.assertEquals(file, "testfile.txt", "verify the file name");


    }
}