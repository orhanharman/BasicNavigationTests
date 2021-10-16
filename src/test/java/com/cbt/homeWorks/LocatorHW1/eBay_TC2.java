package com.cbt.homeWorks.LocatorHW1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class eBay_TC2 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");

        String keyWord = "selenium";
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(keyWord);
        driver.findElement(By.xpath("//input[@id='gh-btn']")).click();

        String title = driver.getTitle();

        if(title.contains(keyWord)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.quit();

    }

}
