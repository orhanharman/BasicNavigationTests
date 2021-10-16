package com.cbt.homeWorks.LocatorHW1;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wikipedia_TC3 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org");

        String keyWord = "selenium webdriver";
        driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys(keyWord);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//a[@title='Selenium (software)']")).click();

        String keyWord2 = "Selenium_(software)";
        String url = driver.getCurrentUrl();

        if(url.endsWith(keyWord2)){
            System.out.println("Pass");
            System.out.println(keyWord2);
            System.out.println(url);
        }else{
            System.out.println("Fail");
            System.out.println(keyWord2);
            System.out.println(url);
        }

        driver.quit();

    }

}
