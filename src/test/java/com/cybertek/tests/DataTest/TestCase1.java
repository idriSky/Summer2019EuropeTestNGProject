package com.cybertek.tests.DataTest;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase1 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //1 Go to "https:// qa1.vytrack.com/"
        driver.get("https://qa1.vytrack.com/");

        //2 login as a store maneger
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager65");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        WebElement message = driver.findElement(By.xpath("//*[@class='message']"));
        WebElement close = driver.findElement(By.xpath("//*[@class='close']"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(message));
        if (message.isDisplayed()) {
            close.click();
        }

        WebElement activities = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        actions.moveToElement(activities).perform();

        wait.until(ExpectedConditions.visibilityOf(activities));
        driver.findElement(By.xpath("//*[text()='Calendar Events']")).click();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        // Thread.sleep(3000);
        //driver.quit();


    }

    @Test
    public void Test1() throws InterruptedException {

        WebElement options = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[2]/div"));
        Assert.assertTrue(options.isDisplayed(), "Verify that the page subtitle 'options' is disable");

    }

    @Test
    public void Test2() throws InterruptedException {


        List<WebElement> pageNum = driver.findElements(By.xpath("//*[@type='number']"));
        System.out.println(pageNum.size());
        System.out.println(pageNum.get(0).getText());


        //String page = pageNum.getAttribute("value");

        // Assert.assertTrue(page.equals("1"),"Verify that page number is equals to 1");


    }

    @Test
    public void Test3() throws InterruptedException {


        Select button = new Select(driver.findElement(By.xpath("//*[@class='btn dropdown-toggle ']")));
        String x = button.getFirstSelectedOption().getText();
        System.out.println(x);
        button.selectByVisibleText("25");


        // WebElement pageview = driver.findElement(By.xpath("//*[@class='btn dropdown-toggle ']"));
        // Thread.sleep(5000);
        //  pageview.click();
        //List<WebElement> number = driver.findElements(By.xpath("//*[@class='btn dropdown-toggle ']"));
       /*
        String numberPrint = String.valueOf(number.size());
        for(WebElement value:number){
            System.out.println(value.getText());*/
    }
    // System.out.println("numberPrint = " + numberPrint);


       /* String acutalNum = pageview.getText();
        String expecteNum= "25";
        Assert.assertEquals(acutalNum,expecteNum,"Verify that view per page Number is equal to 25");*/




    @Test
    public void test4(){

        //4 Veirfy that number of calender events(rows in the table) is equal to number of records
        List<WebElement> numberEvents = driver.findElements(By.xpath("//table[@class=\"grid table-hover table table-bordered table-condensed\"]//tbody/tr"));
        String numberOfEvents = String.valueOf(numberEvents.size());

        String numberRecords = driver.findElement(By.xpath("(//label[@class=\"dib\"])[3]")).getText();

        String[] array = numberRecords.split(" ");
        System.out.println(array[2]);
        System.out.println(numberOfEvents);
        numberRecords = array[2];

        Assert.assertTrue(numberRecords.equals(numberOfEvents), "Verify that number of calendar events (rows in the table) is equals to number of records");
    }
    @Test
    public void Test5() throws InterruptedException {
        //verify that all calender events were selected
        driver.findElement(By.xpath("(//*[@type='checkbox'])[7]")).click();
        List<WebElement> rows = driver.findElements(By.xpath("//*[@class='grid table-hover table table-bordered table-condensed']//tbody[1]"));
        List<WebElement> columns = driver.findElements(By.xpath("//*[@class='grid table-hover table table-bordered table-condensed']//tbody//td[1]"));

        for (int i = 1; i <rows.size() ; i++) {

            for (int j = 1; j <columns.size() ; j++) {

        String Cell ="//*[@class='grid table-hover table table-bordered table-condensed']//tbody["+i+"]//td["+j+"]";

        WebElement checkBox=driver.findElement(By.xpath(Cell));
        Assert.assertTrue(checkBox.isSelected());

            }

        }

    }
    @Test
    public void Test6() throws InterruptedException {

       Thread.sleep(5000);
       WebElement row = driver.findElement(By.xpath("//*[@class='grid-row row-click-action']"));
       row.click();

       WebElement generalInfo = driver.findElement(By.xpath("(//*[@class='responsive-block'])[1]"));

       Assert.assertTrue(generalInfo.isDisplayed(),"verify that general information is displayed");





    }
}
