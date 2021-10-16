package com.cbt.homeWorks.linkTestExamples;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class linkTest_partialLinkTest {

    @Test
    void verifyLinkIsWorking_linkText() throws InterruptedException {
        // find the link with text
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://kicchi.medium.com/");

        //we have to provide the full link text of the <a> element
        WebElement titleLink = driver.findElement(By.linkText("Unit Testing with JUnit5 in IntelliJ Maven Project [Software Development Engineer in Test Article Series Part 9]"));

        Thread.sleep(2000);

        titleLink.click();

        Thread.sleep(2000);

        String expectedTitle = "Unit Testing with JUnit5 in IntelliJ Maven Project [Software Development Engineer in Test Article Series Part 9] | by Hüseyin K. | Sep, 2021 | Medium";

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        driver.quit();
    }

    @Test
    void verifyLinkIsWorking_partialLinkText() throws InterruptedException {
        // find the link with text
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://kicchi.medium.com/");

        //we can provide part of the link text of the <a> element
        WebElement titleLink = driver.findElement(By.partialLinkText("Unit Testing with JUnit5"));

        Thread.sleep(2000);

        titleLink.click();

        Thread.sleep(2000);

        String expectedTitle = "Unit Testing with JUnit5 in IntelliJ Maven Project [Software Development Engineer in Test Article Series Part 9] | by Hüseyin K. | Sep, 2021 | Medium";

        Assert.assertEquals(driver.getTitle(), expectedTitle);

        driver.quit();
    }
}

