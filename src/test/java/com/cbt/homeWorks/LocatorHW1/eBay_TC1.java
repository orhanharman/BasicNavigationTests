package com.cbt.homeWorks.LocatorHW1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class eBay_TC1 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java");
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        //String text1 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/child::span[1]")).getText();
        //WebElement text2 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/text()"));
        String text3 = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();

        System.out.println("Search results is: " + text3);

        driver.quit();

    }

}
