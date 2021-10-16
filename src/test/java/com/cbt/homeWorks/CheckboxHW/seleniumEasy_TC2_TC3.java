package com.cbt.homeWorks.CheckboxHW;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class seleniumEasy_TC2_TC3 {

    WebDriver driver;
    //If we declare any variable out of all methods but inside the class, we make it global, so it is valid for all methods

    @BeforeClass
    public void setUp(){
        //1.Open Chrome browser
        //2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void testCase2() throws InterruptedException {

        /*
        SeleniumEasy Checkbox Verification – TC2
        1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Success – Check box is checked” message is NOT displayed.
        4.Click to checkbox under “Single Checkbox Demo” section
        5.Verify “Success – Check box is checked” message is displayed.
         */

        //1 and 2 is already done via beforeClass method

        //3.Verify “Success – Check box is checked” message is NOT displayed
        WebElement successMsg = driver.findElement(By.id("txtAge"));
                                                 //By.cssSelector("input#isAgeSelected")
        System.out.println("successCheckbox.isDisplayed() = " + successMsg.isDisplayed());
        Assert.assertFalse(successMsg.isDisplayed(), "Message verification failed");

        //4.Click to checkbox under “Single Checkbox Demo” section
        driver.findElement(By.id("isAgeSelected")).click();

        //5.Verify “Success – Check box is checked” message is displayed
        System.out.println("successMsg.isDisplayed() = " + successMsg.isDisplayed());
        Assert.assertTrue(successMsg.isDisplayed(), "Message is not displayed");

        Thread.sleep(5000);

    }


    @Test
    public void testCase3() throws InterruptedException {

        /*
        SeleniumEasy Checkbox Verification – TC3
        1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Check All” button text is “Check All”
        4.Click to “Check All” button
        5.Verify all check boxes are checked
        6.Verify button text changed to “Uncheck All”
        */

        //1 and 2 is already done via beforeClass method

        //3.Verify “Check All” button text is “Check All”
        WebElement checkAll = driver.findElement(By.id("check1"));
                                               //By.cssSelector("#check1")
        String expectedCheckAllText = "Check All";
        String actualCheckAllText = checkAll.getAttribute("value");
        System.out.println("expectedCheckAllText = " + expectedCheckAllText);
        System.out.println("actualCheckAllText = " + actualCheckAllText);
        Assert.assertEquals(actualCheckAllText, expectedCheckAllText, "Texts are not same");

        //4.Click to “Check All” button
        checkAll.click();

        //5.Verify all check boxes are checked
        for(int i=1; i<5; i++) {
            Assert.assertTrue(driver.findElement(By.xpath("(//input[@type='checkbox'][@class='cb1-element'])["+i+"]")).isSelected());
        }

        //6.Verify button text changed to “Uncheck All”
        WebElement uncheckAll = driver.findElement(By.id("check1"));
        String uncheckAllText = uncheckAll.getAttribute("value");
        Assert.assertEquals(uncheckAllText, "Uncheck All");

        Thread.sleep(5000);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
