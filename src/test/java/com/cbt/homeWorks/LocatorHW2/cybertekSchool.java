package com.cbt.homeWorks.LocatorHW2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cybertekSchool {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/login");

        String home = driver.findElement(By.xpath("//a[@class='nav-link']")).getText();
        String loginPage = driver.findElement(By.xpath("//h2[contains(text(),'Login Page')]")).getText();
        String username = driver.findElement(By.xpath("//label[@for='username']")).getText();
        String password = driver.findElement(By.xpath("//label[@for='password']")).getText();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("orhiharm");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);
        driver.quit();

    }

}
