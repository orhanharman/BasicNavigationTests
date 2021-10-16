package com.cbt.homeWorks.day5_xPath_Amazon;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    /*
    1. go to amazon.com
    2. search for selenium
    3. click search button
    4. verify 1-48 of 205 results for "selenium"
     */

    public static void main(String[] args) {

        //1. go to amazon.com
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //2. search for "selenium"
        String keyWord = "selenium";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyWord);

        //3. click search button
        driver.findElement(By.id("nav-search-submit-button")).click();

        //4. verify 1-48 of 205 results for "selenium"
        String expectedText = "1-48 of 201 results for \"" + keyWord + "\"";
        String text1 = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText();
        String text2 = driver.findElement((By.xpath("//span[contains(text(),'results for')]/following-sibling::span[1]"))).getAttribute("textContent");
        String text3 = driver.findElement(By.xpath("//span[contains(text(),'results for')]/following-sibling::span[2]")).getText();



        String actualText = text1 + text2 + text3;

        if(expectedText.equals(actualText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected text: " + expectedText);
            System.out.println("Actual text: " + actualText);
        }

        driver.close();

    }

}