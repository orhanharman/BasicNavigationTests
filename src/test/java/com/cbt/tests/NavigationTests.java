package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {

    public static void main(String[] args) {
        Browser("chrome");
        Browser("safari");
        //Browser("firefox");
        //Browser("edge");
    }

    public static void Browser(String browser) {

        WebDriver driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        String titleGoogle = driver.getTitle();

        driver.get("http://etsy.com");
        String titleEtsy = driver.getTitle();

        //goes back to previous page
        driver.navigate().back();

        //StringUtility.verifyEquals(titleGoogle, driver.getTitle());
        StringUtility s1 = new StringUtility();
        s1.verifyEquals(titleGoogle, driver.getTitle());

        //goes forward
        driver.navigate().forward();

        //StringUtility.verifyEquals(titleEtsy, driver.getTitle());
        s1.verifyEquals(titleEtsy, driver.getTitle());

        driver.close();

    }

}
