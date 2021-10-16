package com.cbt.homeWorks.LocatorHW1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class eBay_TC1_AnotherApproach {

    @Test
    void AmazonGetSearchResult(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=iphone&_sacat=0");

        WebElement webElement = driver.findElement(By.cssSelector(".srp-controls__count-heading"));
        String innerHTML = webElement.getAttribute("innerHTML");
        String outerHTML = webElement.getAttribute("outerHTML");
        String value = webElement.getAttribute("value");
        String text = webElement.getText();

        System.out.println("innerHTML = " + innerHTML);
        System.out.println("outerHTML = " + outerHTML);
        System.out.println("value = " + value);
        System.out.println("text = " + text);

        driver.quit();

    }

}
